package com.ozady.carston.views.rental

import android.Manifest
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.ozady.carston.R
import com.ozady.carston.databinding.ActivityRentalCarBinding
import com.ozady.carston.utils.CalendarHelper
import java.text.SimpleDateFormat
import java.util.*

import com.ozady.carston.views.notifications.NotificationsListActivity


class RentalCarActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityRentalCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRentalCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        showDatePicker(binding.startDate)
        showDatePicker(binding.endDate)

        binding.myLocation.setOnClickListener {
            getCurrentLocation()
        }

        Handler().postDelayed({
            getCurrentLocation()
        },2000)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNext.setOnClickListener {
            startActivity(Intent(this,SelectDateTimeActivity::class.java))
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this,NotificationsListActivity::class.java))
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
        val loc = mMap.myLocation

        try {
            val sydney = LatLng(loc.latitude, loc.longitude)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f), 5000, null)

        }catch (e:Exception){

        }

        setupLocClient()
        // Add a marker in Sydney and move the camera
    }

    fun showDatePicker(data:TextView) {
        // DatePicker

        data.text = SimpleDateFormat("dd MMM yyyy, hh:mm a").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd MMM yyyy, hh:mm a" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            data.text = sdf.format(cal.time)


        }

        data.setOnClickListener {

            val dialog = DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))

           // dialog.datePicker.maxDate = CalendarHelper.getCurrentDateInMills()
            dialog.show()
        }
    }

    private lateinit var fusedLocClient: FusedLocationProviderClient
    // use it to request location updates and get the latest location

    private fun setupLocClient() {
        fusedLocClient =
            LocationServices.getFusedLocationProviderClient(this)
    }

    @SuppressLint("NewApi")
    private fun getCurrentLocation() {
        setupLocClient()
        // Check if the ACCESS_FINE_LOCATION permission was granted before requesting a location
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {

            // call requestLocPermissions() if permission isn't granted
            requestLocPermissions()
        } else {

            fusedLocClient.lastLocation.addOnCompleteListener {
                // lastLocation is a task running in the background
                val location = it.result //obtain location
                if (location != null) {

                    val latLng = LatLng(location.latitude, location.longitude)

                    Toast.makeText(this, latLng.toString(), Toast.LENGTH_SHORT).show()

                    mMap.addMarker(MarkerOptions().position(latLng).title("get by gps").icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.blue_car2)
                    ))

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f), 5000, null)

                    mMap.addCircle(CircleOptions().center(latLng).radius(1000.0).strokeColor(Color.BLUE).strokeWidth(1f).fillColor(getColor(R.color.mapColor1)))

                    mMap.addCircle(CircleOptions().center(latLng).radius(500.0).strokeColor(Color.RED).strokeWidth(1f).fillColor(getColor(R.color.mapColor2)))


                } else {
                    Toast.makeText(this, "not found loaction", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "No location found")
                }
            }
        }
    }

    private fun requestLocPermissions() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), //permission in the manifest
            REQUEST_LOCATION)
    }

    companion object {
        private const val REQUEST_LOCATION = 1 //request code to identify specific permission request
        private const val TAG = "logapp" // for debugging
    }

}