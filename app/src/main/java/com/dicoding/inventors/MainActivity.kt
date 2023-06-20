package com.dicoding.inventors

import android.content.Intent
import android.net.ipsec.ike.exceptions.InvalidMajorVersionException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvInventors: RecyclerView
    private val list = ArrayList<Inventor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backIcon : ImageView = findViewById(R.id.iv_back_icon)
        val profileIcon : ImageView = findViewById(R.id.iv_profile_icon)
        val barTitle : TextView = findViewById(R.id.tv_title)

        backIcon.visibility = View.INVISIBLE

        val layoutParams = barTitle.layoutParams as RelativeLayout.LayoutParams
        layoutParams.removeRule(RelativeLayout.END_OF) // Remove the layout_toEndOf property
        barTitle.layoutParams = layoutParams

        val params = barTitle.layoutParams as ViewGroup.MarginLayoutParams
        params.marginStart = 0 // Set marginStart to 0 (or any other desired value)
        barTitle.layoutParams = params // Apply the modified layout parameters to the view

        profileIcon.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(moveIntent)
        }

        rvInventors = findViewById(R.id.rv_inventors)
        rvInventors.setHasFixedSize(true)

        list.addAll(getListInventors())
        showRecyclerList()
    }

    private fun getListInventors(): ArrayList<Inventor> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPenemuan = resources.obtainTypedArray(R.array.data_penemuan)
        val listInventor = ArrayList<Inventor>()
        for (i in dataName.indices) {
            val inventor = Inventor(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPenemuan.getResourceId(i, -1))
            listInventor.add(inventor)
        }
        return listInventor
    }

    private fun showRecyclerList() {
        rvInventors.layoutManager = LinearLayoutManager(this)
        val listInventorAdapter = ListInventorAdapter(list)
        rvInventors.adapter = listInventorAdapter
    }
}