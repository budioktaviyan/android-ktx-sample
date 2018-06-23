package id.kotlin.sample.ktx.uri

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.net.toUri
import id.kotlin.sample.ktx.R
import kotlinx.android.synthetic.main.activity_uri.*

class UriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uri)
        setSupportActionBar(toolbar_uri)
        btn_call.setOnClickListener { if (edit_phone.text.isNotBlank()) call() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun call() {
        val phone = edit_phone.text
        val uri = "tel:$phone".toUri()

        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = uri
        })
    }
}