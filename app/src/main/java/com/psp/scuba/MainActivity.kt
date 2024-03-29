package com.psp.scuba

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.psp.scuba.fish.FishActivity
import com.psp.scuba.site.SiteActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager = resources.assets
        val file = File("/data/data/com.psp.scuba/databases/scuba.db")
        try {
            val inputStream = assetManager.open("scuba.db", 3)
            val l = inputStream.available()
            if (file.length() <= 0L) {
                val arrayOfByte = ByteArray(l)
                inputStream.read(arrayOfByte)
                inputStream.close()
                file.createNewFile()
                val fileOutputStream = FileOutputStream(file)
                try {
                    fileOutputStream.write(arrayOfByte)
                    fileOutputStream.close()
                    return
                } catch (fileOutputStream: IOException) {
                    Log.e("DB", "scuba.db 쓰기")
                }
            }
        } catch (file: IOException) {
            Log.e("DB", "scuba.db 이동")
        }
        val file2 = File("/data/data/com.psp.scuba/databases/fish.db")
        try {
            val inputStream = assetManager.open("fish.db", 3)
            val l = inputStream.available()
            if (file2.length() <= 0L) {
                val arrayOfByte = ByteArray(l)
                inputStream.read(arrayOfByte)
                inputStream.close()
                file2.createNewFile()
                val fileOutputStream = FileOutputStream(file2)
                try {
                    fileOutputStream.write(arrayOfByte)
                    fileOutputStream.close()
                    return
                } catch (fileOutputStream: IOException) {
                    Log.e("DB", "fish.db 쓰기")
                }
            }
        } catch (file: IOException) {
            Log.e("DB", "fish.db 이동")
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_site -> {
                val nextIntent = Intent(this, SiteActivity::class.java)
                startActivity(nextIntent)
            }
            R.id.nav_fish -> {
                val nextIntent = Intent(this, FishActivity::class.java)
                startActivity(nextIntent)
            }
            R.id.nav_coral -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
