package com.psp.scuba

import android.content.Context
import android.support.v4.app.Fragment


abstract class BaseFragment : Fragment(), BaseActivity.OnBackPressedListener {
    protected lateinit var baseActivity: BaseActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity !is BaseActivity) throw RuntimeException("Activity holding this fragment should extend BaseActivity")
        this.baseActivity = activity as BaseActivity
        this.baseActivity.onBackListener = this
    }

    override fun onBackPressedCaptured(): Boolean = false

}
