package com.psp.scuba.site.ui.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.psp.scuba.R
import com.psp.scuba.site.Site

private val TAB_TITLES = arrayOf(
    R.string.tab_info,
    R.string.tab_pic
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, private val site: Site) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        Log.e("param", site.id.toString())

        return when (position) {
            0 -> InfoFragment.newInstance(site)
            1 -> PictureFragment.newInstance(site)
            else -> InfoFragment.newInstance(site)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}