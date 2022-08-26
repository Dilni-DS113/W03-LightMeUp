@file:Suppress("UnusedImport")

package com.example.w03_lightmeup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
   var state = R.drawable.ic_home_black_24dp
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = findViewById<ImageView>(R.id.imagesalternative)

        savedInstanceState?.let {
            state = it.getInt("home")
            home.setImageDrawable(getDrawable(state))
        }

            home.setOnClickListener {
                state = when(state)
                {
                    R.drawable.ic_home_black_24dp->R.drawable.ic_settings_black_24dp
                    R.drawable.ic_settings_black_24dp -> R.drawable.ic_home_black_24dp
                    else ->R.drawable.ic_home_black_24dp
                }
            home.setImageDrawable(getDrawable(state))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("home",state)
    }
}