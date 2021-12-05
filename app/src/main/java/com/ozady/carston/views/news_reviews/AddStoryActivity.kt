package com.ozady.carston.views.news_reviews

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import com.ozady.carston.databinding.ActivityAddStoryBinding
import com.ozady.carston.databinding.ActivityStoryViewBinding
import com.ozady.carston.utils.FileUtils
import java.io.File

class AddStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStoryBinding

    var typeStory = 1
    lateinit var uri: Uri
    var sendingFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        typeStory = intent.getIntExtra("typeStory",1)

        when(typeStory){
            2->{
                getImageFun()
            }
            3->{
                getFromCam()
            }
        }

    }

    private fun getFromCam() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, 3)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    private fun getImageFun() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.apply {
            type = "image/*"
        }
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {

            if (requestCode ==1){
                loadImageFun(data)
            }else if (requestCode ==3){
                val imageBitmap = data.extras?.get("data") as Bitmap
                binding.storyImg.setImageBitmap(imageBitmap)
            }
        }
    }

    private fun loadImageFun(data: Intent) {
        uri = data.data!!
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = preferences.edit()
        editor.putString("image", uri.toString())
        editor.commit()
        sendingFile = File(FileUtils.getSmartFilePath(this, data.data!!) ?: "")
        binding.storyImg.setImageURI(uri)
    }

}