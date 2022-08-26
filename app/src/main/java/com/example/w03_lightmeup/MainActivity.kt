@file:Suppress("UnusedImport")

package com.example.w03_lightmeup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {

    val imageViewModel: ImageViewModel by viewModels()


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = findViewById<ImageView>(R.id.imagesalternative)
        home.setImageDrawable(getDrawable(imageViewModel.state))

//        savedInstanceState?.let {
//            state = it.getInt("home")
//            home.setImageDrawable(getDrawable(state))
      //  }

            home.setOnClickListener {
                imageViewModel.nextImage()
//                state = when(state)
//                {
//                    R.drawable.ic_home_black_24dp->R.drawable.ic_settings_black_24dp
//                    R.drawable.ic_settings_black_24dp -> R.drawable.ic_home_black_24dp
//                    else ->R.drawable.ic_home_black_24dp
//                }
            home.setImageDrawable(getDrawable(imageViewModel.state))

        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("home",state)
//    }
}

class ImageViewModel: ViewModel(){
    var state = R.drawable.ic_home_black_24dp

    fun nextImage(){
        state = when(state) {
            R.drawable.ic_home_black_24dp->R.drawable.ic_settings_black_24dp
            R.drawable.ic_settings_black_24dp -> R.drawable.ic_home_black_24dp
            else ->R.drawable.ic_home_black_24dp
        }
    }
}