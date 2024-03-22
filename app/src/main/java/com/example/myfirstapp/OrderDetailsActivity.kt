package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    var order =Order()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)

        order.productName = intent.getStringExtra("order").toString()

        binding.tv3.text = order.productName

        when(order.productName){
            "Soy Latte" ->binding.imageView.setImageResource(R.drawable.sb1)
            "Chocco Frapp" ->binding.imageView.setImageResource(R.drawable.sb2)
            "Bottled Americano" ->binding.imageView.setImageResource(R.drawable.sb3)
            "Rainbow Frapp" ->binding.imageView.setImageResource(R.drawable.sb4)
            "Caramel Frapp" ->binding.imageView.setImageResource(R.drawable.sb5)
            "Black Forest Frapp" ->binding.imageView.setImageResource(R.drawable.sb6)
        }

        binding.fab.setOnClickListener(){
            shareIntent(applicationContext,order.productName)
        }
        setContentView(R.layout.activity_order_details)
    }


}