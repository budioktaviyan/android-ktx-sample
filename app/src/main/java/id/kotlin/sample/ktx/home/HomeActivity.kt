package id.kotlin.sample.ktx.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.core.widget.toast
import id.kotlin.sample.ktx.R
import id.kotlin.sample.ktx.home.HomeAdapter.MenuListener
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
                    0 -> toast(menuItem[0])
                    1 -> toast(menuItem[1])
                    2 -> toast(menuItem[2])
                }
            }
        })
    }
}