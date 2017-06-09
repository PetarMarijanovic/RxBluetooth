package com.petarmarijanovic.rxbluetooth

import android.app.Activity
import android.app.Fragment

/** Created by petar on 09/06/2017. */
fun Activity.findFragmentByTag(tag: String): Fragment? = fragmentManager.findFragmentByTag(tag)

fun Activity.commitFragment(fragment: Fragment, tag: String) {
  fragmentManager.beginTransaction().add(fragment, tag).commitAllowingStateLoss()
  fragmentManager.executePendingTransactions()
}
