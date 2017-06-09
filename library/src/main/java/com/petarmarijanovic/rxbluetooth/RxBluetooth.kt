package com.petarmarijanovic.rxbluetooth

import android.app.Activity

/** Created by petar on 08/06/2017. */
class RxBluetooth(activity: Activity) {
  
  companion object {
    private val TAG = "com.petarmarijanovic.rxbluetooth.RxBluetooth"
  }
  
  private val rxBluetoothFragment: RxBluetoothFragment
  
  init {
    var rxBluetoothFragment = findRxBluetoothFragment(activity)
    
    if (rxBluetoothFragment == null) {
      rxBluetoothFragment = RxBluetoothFragment()
      activity.commitFragment(rxBluetoothFragment, TAG)
    }
    
    this.rxBluetoothFragment = rxBluetoothFragment
  }
  
  fun enableBluetooth() = rxBluetoothFragment.enableBluetooth()
  
  private fun findRxBluetoothFragment(activity: Activity): RxBluetoothFragment? =
      activity.findFragmentByTag(TAG) as RxBluetoothFragment?
}
