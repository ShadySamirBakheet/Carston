package com.ozady.carston.views.settings

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ozady.carston.databinding.ActivityCarViewBinding
import com.ozady.carston.databinding.ActivityContactSupportBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class ContactSupportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactSupportBinding

    var messanger = "https://www.messenger.com/t/2118476798430137"
    var facebook = "https://www.facebook.com/AplexEgypt/"
    var mail = "info@eye-law.net"
    var host = "http://eye-law.net"
    var phone = "+20233825252"
    var youtube = "https://www.youtube.com/channel/UCCghB95SxXhPA0tPPWq8l8w"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.phoneCon.setOnClickListener {
             callNumber()
        }

        binding.emailCon.setOnClickListener {
            send()
        }

        binding.whatsAppCon.setOnClickListener {
            openWhatsApp()
        }

        binding.hostCon.setOnClickListener {
            openLink(host)
        }

        binding.youtubeCon.setOnClickListener {
            openLink(youtube)
        }

        binding.messangerCon.setOnClickListener {
            openLink(messanger)
        }

        binding.facebookCon.setOnClickListener {
            openLink(facebook)
        }

    }

    private fun callNumber() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                1
            )
        }else{
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:" +phone)
            startActivity(callIntent)
        }

    }

    private fun openWhatsApp() {
        val uri = Uri.parse("smsto:$phone")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.setPackage("com.whatsapp")
        startActivity(intent)
    }

    private fun openLink(Link: String) {
        val uri = Uri.parse(Link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun send() {
        val TO = arrayOf(mail)
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail vs..."))
            Log.i("Finished email...", "Finished sending email...")
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show()
        }
    }

}