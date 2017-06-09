package com.petarmarijanovic.rxbluetooth

import android.app.Activity.RESULT_OK
import android.app.Fragment
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import rx.Observable
import rx.subjects.PublishSubject

/** Created by petar on 08/06/2017. */
class RxBluetoothFragment : Fragment() {
  
  companion object {
    private val REQUEST_CODE = 42
  }
  
  private val bleEnableResultSubject = PublishSubject.create<Int>()
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true
  }
  
  fun enableBluetooth(): Observable<Int> {
    if (isBluetoothEnabled()) return Observable.just(RESULT_OK)
    
    startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQUEST_CODE)
    return bleEnableResultSubject.first()
  }
  
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode != REQUEST_CODE) return
    bleEnableResultSubject.onNext(resultCode)
  }
  
  private fun isBluetoothEnabled(): Boolean {
    val bluetoothManager = activity.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val bluetoothAdapter = bluetoothManager.adapter
    
    return bluetoothAdapter != null && bluetoothAdapter.isEnabled
  }
}
