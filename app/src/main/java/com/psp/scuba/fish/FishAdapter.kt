package com.psp.scuba.fish

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.psp.scuba.R

class FishAdapter(val context: Context, val fishList: ArrayList<Fish>, val itemClick: (Fish) -> Unit) :
    RecyclerView.Adapter<FishAdapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_fish_item, p0, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return fishList.size
    }

    override fun onBindViewHolder(p0: Holder, position: Int) {
        p0.bind(fishList[position], context)
    }

    inner class Holder(itemView: View?, itemClick: (Fish) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
        val fishPhoto = itemView?.findViewById<ImageView>(R.id.fishPhoto)
        val fishName = itemView?.findViewById<TextView>(R.id.fishName)
        //val fishExplan = itemView?.findViewById<TextView>(R.id.fishExplan)

        fun bind(fish: Fish, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (fish.photo != "") {
                val resourceId = context.resources.getIdentifier(fish.photo, "drawable", context.packageName)
                fishPhoto?.setImageResource(resourceId)
            } else {
                fishPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            fishName?.text = fish.name
            //fishExplan?.text = fish.explan

            itemView.setOnClickListener { itemClick(fish) }
        }
    }
}
