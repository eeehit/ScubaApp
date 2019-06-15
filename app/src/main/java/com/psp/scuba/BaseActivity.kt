package com.psp.scuba

import android.support.v7.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    interface OnBackPressedListener {
        fun onBackPressedCaptured(): Boolean
    }

    var onBackListener: OnBackPressedListener? = null
    override fun onBackPressed() {
        onBackListener?.let {
            if (!it.onBackPressedCaptured())
                super.onBackPressed()
        } ?: super.onBackPressed()
    }

}