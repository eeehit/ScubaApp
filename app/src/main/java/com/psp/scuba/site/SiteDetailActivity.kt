package com.psp.scuba.site

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.psp.scuba.BaseActivity
import com.psp.scuba.R
import com.psp.scuba.site.ui.main.SectionsPagerAdapter


class SiteDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_detail)

        //DB데이터
        val site_id = 0
        val db = SiteDBHandler(this)
        val site = db.getSiteByName(intent.getIntExtra("site_id", site_id))[0]

        //페이지 로드
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, site)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(com.psp.scuba.R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}