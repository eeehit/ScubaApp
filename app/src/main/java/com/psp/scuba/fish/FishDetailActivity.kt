package com.psp.scuba.fish

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.psp.scuba.R

class FishDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_detail)

        //DB데이터
        val db = FishDBHandler(this)
        val fish_id = 0
        val fish = db.getFishByName(intent.getIntExtra("fish_id", fish_id))[0]

        //페이지에 로드
        val fishDetailPhoto = findViewById<ImageView>(R.id.fishDetailPhoto)
        val fishDetailName = findViewById<TextView>(R.id.fishDetailName)
        val fishDetailExplan = findViewById<TextView>(R.id.fishDetailExplan)
        if (fish.photo != "") {
            val resourceId = this.resources.getIdentifier(fish.photo, "drawable", this.packageName)
            fishDetailPhoto?.setImageResource(resourceId)
        } else {
            fishDetailPhoto?.setImageResource(R.mipmap.ic_launcher)
        }
        fishDetailName?.text = fish.name
        fishDetailExplan?.text = fish.explan
    }
}


