package id.kotlin.sample.ktx.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.core.widget.toast
import id.kotlin.sample.ktx.R
import id.kotlin.sample.ktx.home.HomeAdapter.MenuListener
import id.kotlin.sample.ktx.htmlencode.HtmlEncodeActivity
import id.kotlin.sample.ktx.sharedprefs.SharedPrefsActivity
import id.kotlin.sample.ktx.uri.UriActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar_home)

        val menuItem = resources.getStringArray(R.array.menu)
        menu.adapter = HomeAdapter(menuItem.toList(), object : MenuListener {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> {
                        toast(menuItem[0])
                        startActivity(Intent(this@HomeActivity, SharedPrefsActivity::class.java))
                    }
                    1 -> {
                        toast(menuItem[1])
                        startActivity(Intent(this@HomeActivity, UriActivity::class.java))
                    }
                    2 -> {
                        toast(menuItem[2])
                        startActivity(Intent(this@HomeActivity, HtmlEncodeActivity::class.java))
                    }
                }
            }
        })
    }
}