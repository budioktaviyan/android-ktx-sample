package id.kotlin.sample.ktx.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.content.edit
import androidx.core.widget.toast
import id.kotlin.sample.ktx.R
import kotlinx.android.synthetic.main.activity_sharedprefs.*

class SharedPrefsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedprefs)
        setSupportActionBar(toolbar_sharedprefs)
        load()
        btn_save.setOnClickListener { if (edit_name.text.isNotBlank()) save() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun load() {
        sharedPreferences = getSharedPreferences("android_ktx_sample", Context.MODE_PRIVATE)

        val text = sharedPreferences.getString("NAME", "")
        text_name.text = text
    }

    private fun save() {
        val text = edit_name.text

        sharedPreferences.edit {
            putString("NAME", text.toString())
        }
        toast("Name has been save!")
    }
}