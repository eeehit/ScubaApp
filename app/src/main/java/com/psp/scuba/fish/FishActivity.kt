package com.psp.scuba.fish

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.psp.scuba.R
import kotlinx.android.synthetic.main.activity_fish.*

class FishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)

        //DB데이터
        val db = FishDBHandler(this)
        val fishList = db.readData()

        //물고기 리스트
        val fishAdapter = FishAdapter(this, fishList as ArrayList<Fish>) { fish ->
            val nextIntent = Intent(this, FishDetailActivity::class.java)
            nextIntent.putExtra("fish_id", fish.id)
            startActivity(nextIntent)
        }
        fishListView.adapter = fishAdapter
        val lm = LinearLayoutManager(this)
        fishListView.layoutManager = lm
        fishListView.setHasFixedSize(true)
    }
}
