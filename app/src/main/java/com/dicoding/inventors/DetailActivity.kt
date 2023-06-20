package com.dicoding.inventors

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val backIcon : ImageView = findViewById(R.id.iv_back_icon)
        val profileIcon : ImageView = findViewById(R.id.iv_profile_icon)
        val barTitle : TextView = findViewById(R.id.tv_title)

        val dataInventor = intent.getParcelableExtra<Inventor>("key_inventor")!!

        val tvDetailName : TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription : TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto : ImageView = findViewById(R.id.iv_detail_photo)
        val ivDetailPenemuan : ImageView = findViewById(R.id.iv_detail_photo_penemuan)

        tvDetailName.text = dataInventor.name
        tvDetailDescription.text = dataInventor.description
        ivDetailPhoto.setImageResource(dataInventor.photo)
        ivDetailPenemuan.setImageResource(dataInventor.photoPenemuan)

        profileIcon.visibility = View.INVISIBLE
        barTitle.text = dataInventor.name

        backIcon.setOnClickListener {
            finish() // Finish the current activity and return to the previous activity
        }

    }
}