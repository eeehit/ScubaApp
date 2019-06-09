package com.psp.scuba.fish

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FishDBHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object {
        val DATABASE_NAME = "fish.db"

        //테이블
        val TABLE_NAME = "depcGuide"
        val COL_ID = "_id"
        val COL_NAME = "fish_nomen_kor_name"
        val COL_EXPLAN = "fish_explan"
        val COL_PHOTO = "fish_img_file_name"
    }

    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun readData(): MutableList<Fish> {
        val list: MutableList<Fish> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME where fish_gubun='s'"
        val result: Cursor = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val fish = Fish()
                fish.id = result.getInt(result.getColumnIndex(COL_ID))
                fish.name = result.getString(result.getColumnIndex(COL_NAME))
                fish.explan = result.getString(result.getColumnIndex(COL_EXPLAN))
                fish.photo = result.getString(result.getColumnIndex(COL_PHOTO))
                list.add(fish)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun getFishByName(fish_id: Int): MutableList<Fish> {
        val list: MutableList<Fish> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME where fish_gubun='s' and $COL_ID=$fish_id"
        val result: Cursor = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val fish = Fish()
                fish.id = result.getInt(result.getColumnIndex(COL_ID))
                fish.name = result.getString(result.getColumnIndex(COL_NAME))
                fish.explan = result.getString(result.getColumnIndex(COL_EXPLAN))
                fish.photo = result.getString(result.getColumnIndex(COL_PHOTO))
                list.add(fish)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
}