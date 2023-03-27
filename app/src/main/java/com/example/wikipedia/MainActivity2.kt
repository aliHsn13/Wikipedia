package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.PostItems
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAsli)
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataPost = intent.getParcelableExtra<PostItems>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null) {
            showData(dataPost)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun showData(postItems: PostItems) {

        Glide
            .with(this)
            .load( postItems.img_url )
            .into( binding.imgDetail )

        binding.txtDetailTitle.text = postItems.txtTile
        binding.txtDetailSubtitle.text = postItems.txtSubtitle
        binding.txtDetailText.text = postItems.txtDetails

        binding.fabDetailOpenWikipedia.setOnClickListener {

            // open wikipedia
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent( Intent.ACTION_VIEW , Uri.parse(url) )
            startActivity(intent)

        }

    }

}