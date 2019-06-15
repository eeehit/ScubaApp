package com.psp.scuba.site

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.psp.scuba.BaseActivity
import com.psp.scuba.R
import kotlinx.android.synthetic.main.activity_site.*

class SiteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site)

        //DB데이터
        val db = SiteDBHandler(this)
        val siteList = db.readData()

        //다이빙 포인트 리스트 메인페이지
        val siteAdapter = SiteAdapter(this, siteList as ArrayList<Site>) { site ->
            //Toast.makeText(this, "역시  ${site.name} 은 짱이야!!", Toast.LENGTH_SHORT).show()
            val nextIntent = Intent(this, SiteDetailActivity::class.java)
            nextIntent.putExtra("site_id", site.id)
            startActivity(nextIntent)
        }
        siteListView.adapter = siteAdapter
        val lm = LinearLayoutManager(this)
        siteListView.layoutManager = lm
        siteListView.setHasFixedSize(true)
    }
}
