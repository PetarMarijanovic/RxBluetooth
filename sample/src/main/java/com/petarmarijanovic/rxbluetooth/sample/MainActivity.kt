package com.petarmarijanovic.rxbluetooth.sample

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.petarmarijanovic.rxbluetooth.RxBluetooth
import com.petarmarijanovic.rxbluetooth.toast

class MainActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    findViewById(R.id.enable_bluetooth).setOnClickListener {
      RxBluetooth(this).enableBluetooth()
          .subscribe({ toast(if (it == Activity.RESULT_OK) "Allowed" else "Not Allowed") })
    }
  }
}
