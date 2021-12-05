package com.ozady.carston.views.rental

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.ozady.carston.adapters.data.date.SelectTimeAdapter
import com.ozady.carston.databinding.ActivitySelectDateTimeBinding
import java.text.SimpleDateFormat
import java.util.*


class SelectDateTimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectDateTimeBinding

    var date1 :Date = Date()
    var date2 :Date = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectDateTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.picker.isEnabled = false
        binding.picker2.isEnabled = false

        binding.backBtn.setOnClickListener {
            finish()
        }

        showDatePicker(binding.startDate,true)
        showDatePicker(binding.endDate,false)

        binding.startTimeList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectDateTimeActivity,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = SelectTimeAdapter(this@SelectDateTimeActivity)
        }

        binding.endTimeList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectDateTimeActivity,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = SelectTimeAdapter(this@SelectDateTimeActivity)
        }

    }


    fun showDatePicker(data: TextView, dateSet: Boolean) {
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

            if (dateSet){
                date1 = cal.time
            }else{
                date2 = cal.time
            }

            showDatesFun()

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

    private fun showDatesFun() {
       ///binding.picker.setDate(date1.time,true,true)
       binding.picker2.setDate(date2.time,true,true)
       binding.picker.maxDate=date2.time
       binding.picker.minDate=date1.time

        MaterialDatePicker.Builder.dateRangePicker().setSelection(
            Pair(
                date1.time,
                date2.time
            )
        )

        ///val dateP = MaterialDatePicker.Builder.dateRangePicker().setSelection(Pair(date1.time, date2.time)).build()
/*
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()

        cal1.set(Calendar.YEAR, date1.year)
        cal1.set(Calendar.MONTH, date1.month)
        cal1.set(Calendar.DAY_OF_MONTH, date1.day)

        cal2.set(Calendar.YEAR, date2.year)
        cal2.set(Calendar.MONTH, date2.month)
        cal2.set(Calendar.DAY_OF_MONTH, date2.day)
*/
    }

}