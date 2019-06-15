package com.psp.scuba.site.ui.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.psp.scuba.BaseFragment
import com.psp.scuba.R
import com.psp.scuba.site.Site
import com.psp.scuba.site.SiteDetailActivity
import kotlinx.android.synthetic.main.activity_site_detail_picture.*

/**
 * A placeholder fragment containing a simple view.
 */
class InfoFragment : BaseFragment() {
    companion object {
        fun newInstance(site: Site): Fragment {
            val fp = InfoFragment()
            val args = Bundle()
            args.putSerializable("site", site)
            fp.setArguments(args)
            return fp
        }
    }

    @SuppressLint("NewApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //스쿠버 정보
        val site = arguments?.getSerializable("site") as Site
        Log.e("param", site.id.toString())
        val root = inflater.inflate(R.layout.activity_site_detail_info, container, false)
        return root
    }
}

