package com.petarmarijanovic.rxbluetooth.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.petarmarijanovic.rxbluetooth.RxBluetooth

class MainActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    findViewById(R.id.text).setOnClickListener {
      RxBluetooth(this).enableBluetooth()
          .subscribe({ Log.d("Petarr", it.toString()) },
                     { Log.d("Petarr", it.message) })
    }
  }
}
