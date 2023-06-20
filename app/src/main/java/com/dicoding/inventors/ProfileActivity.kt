package com.dicoding.inventors

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backIcon : ImageView = findViewById(R.id.iv_back_icon)
        val profileIcon : ImageView = findViewById(R.id.iv_profile_icon)
        val barTitle : TextView = findViewById(R.id.tv_title)

        val tvProfileName : TextView = findViewById(R.id.tv_profile_name)
        val tvProfileEmail : TextView = findViewById(R.id.tv_profile_email)
        val tvProfilePhoto : ImageView = findViewById(R.id.iv_profile_photo)

        profileIcon.visibility = View.INVISIBLE
        barTitle.text = getString(R.string.profile_title)

        backIcon.setOnClickListener {
            finish() // Finish the current activity and return to the previous activity
        }

    }
}