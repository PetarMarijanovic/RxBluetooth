package com.petarmarijanovic.rxbluetooth

import android.app.Activity
import rx.Observable

/** Created by petar on 08/06/2017. */
class RxBluetooth(activity: Activity) {
  
  companion object {
    private val TAG = "RxBluetooth"
  }
  
  private val rxBluetoothFragment: RxBluetoothFragment
  
  init {
    var rxBluetoothFragment: RxBluetoothFragment? = findRxBluetoothFragment(activity)
    val isNewInstance = rxBluetoothFragment == null
    if (isNewInstance) {
      rxBluetoothFragment = RxBluetoothFragment()
      val fragmentManager = activity.fragmentManager
      fragmentManager.beginTransaction().add(rxBluetoothFragment, TAG).commitAllowingStateLoss()
      fragmentManager.executePendingTransactions()
    }
    this.rxBluetoothFragment = rxBluetoothFragment!!
  }
  
  fun enableBluetooth(): Observable<Int> {
    return rxBluetoothFragment.enableBluetooth()
  }
  
  private fun findRxBluetoothFragment(activity: Activity): RxBluetoothFragment? {
    return activity.fragmentManager.findFragmentByTag(TAG) as RxBluetoothFragment?
  }
}
