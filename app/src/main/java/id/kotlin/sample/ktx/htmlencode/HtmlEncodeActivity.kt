package id.kotlin.sample.ktx.htmlencode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.text.htmlEncode
import id.kotlin.sample.ktx.R
import kotlinx.android.synthetic.main.activity_htmlencode.*

class HtmlEncodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_htmlencode)
        setSupportActionBar(toolbar_htmlencode)
        btn_encode.setOnClickListener { encode() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun encode() {
        val src = text_html.text
        val dest = src.toString().htmlEncode()

        text_encode.text = dest
    }
}