package id.kotlin.sample.ktx.htmlencode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import id.kotlin.sample.ktx.R
import kotlinx.android.synthetic.main.activity_htmlencode.*

class HtmlEncodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_htmlencode)
        setSupportActionBar(toolbar_htmlencode)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}