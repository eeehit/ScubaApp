package com.psp.scuba.site

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SiteDBHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object {
        val DATABASE_NAME = "scuba.db"

        //테이블
        val TABLE_NAME = "site"
        val COL_ID = "id"
        val COL_NAME = "name"
        val COL_SUMMARY = "summary"
        val COL_PHOTO = "photo"
        val COL_PICTURE_URL = "instagram_url"
    }

    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun readData(): MutableList<Site> {
        val list: MutableList<Site> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result: Cursor = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val site = Site()
                site.id = result.getInt(result.getColumnIndex(COL_ID))
                site.name = result.getString(result.getColumnIndex(COL_NAME))
                site.summary = result.getString(result.getColumnIndex(COL_SUMMARY))
                site.photo = result.getString(result.getColumnIndex(COL_PHOTO))
                site.instagram_url = result.getString(result.getColumnIndex(COL_PICTURE_URL))
                list.add(site)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun getSiteByName(site_id: Int): MutableList<Site> {
        val list: MutableList<Site> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME where $COL_ID=$site_id"
        val result: Cursor = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val site = Site()
                site.id = result.getInt(result.getColumnIndex(COL_ID))
                site.name = result.getString(result.getColumnIndex(COL_NAME))
                site.photo = result.getString(result.getColumnIndex(COL_SUMMARY))
                site.photo = result.getString(result.getColumnIndex(COL_PHOTO))
                site.instagram_url = result.getString(result.getColumnIndex(COL_PICTURE_URL))
                list.add(site)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
}