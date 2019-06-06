package com.psp.scuba

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MainRvAdapter(val context: Context, val siteList: ArrayList<Site>, val itemClick: (Site) -> Unit) :
    RecyclerView.Adapter<MainRvAdapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, p0, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return siteList.size
    }

    override fun onBindViewHolder(p0: Holder, position: Int) {
        p0.bind(siteList[position], context)
    }

    inner class Holder(itemView: View?, itemClick: (Site) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
        val sitePhoto = itemView?.findViewById<ImageView>(R.id.sitePhoto)
        val siteName = itemView?.findViewById<TextView>(R.id.siteName)
        val siteSummary = itemView?.findViewById<TextView>(R.id.siteSummary)

        fun bind(site: Site, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (site.photo != "") {
                val resourceId = context.resources.getIdentifier(site.photo, "drawable", context.packageName)
                sitePhoto?.setImageResource(resourceId)
            } else {
                sitePhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            siteName?.text = site.name
            siteSummary?.text = site.summary

            itemView.setOnClickListener { itemClick(site) }
        }
    }
}
