package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.databinding.ActivityMainWithNavDrawerBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener,
NavigationView.OnNavigationItemSelectedListener{

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Navigate to photo activity")
        //when(item.itemId){
        //           R.id.nav_photo -> openIntent(applicationContext,"",CoffeeSnapsActivity::class.java)
        //}
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        //return true marks the item as selected
        return true
    }

    var order =Order()
    private lateinit var binding: ActivityMainWithNavDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        val binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView2.setOnClickListener(this)
        binding.imageView3.setOnClickListener(this)
        binding.imageView4.setOnClickListener(this)
        binding.imageView5.setOnClickListener(this)
        binding.imageView6.setOnClickListener(this)
        binding.imageView7.setOnClickListener(this)

        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var toggleOnOff = ActionBarDrawerToggle(this,binding.drawerLayout,
            binding.navToolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()

        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener (this)

        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
//Change
        when (v?.id){
            R.id.imageView2 -> order.productName = "Soy Latte"
            R.id.imageView3 -> order.productName = "Chocco Frapp"
            R.id.imageView4 -> order.productName = "Bottled Americano"
            R.id.imageView5 -> order.productName = "Rainbow Frapp"
            R.id.imageView6 -> order.productName = "Caramel Frapp"
            R.id.imageView7 -> order.productName = "Black Forest Frapp"
        }

        Toast.makeText(this@MainActivity, "MMMb " + order.productName,
            Toast.LENGTH_SHORT).show()

        openIntent(this, order.productName, OrderDetailsActivity::class.java)
    }

    fun onBackPresed(){
        //if the drawer is open, close it
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            //otherwise, 1st the super class handle it
            super.onBackPressed()
        }
    }


}