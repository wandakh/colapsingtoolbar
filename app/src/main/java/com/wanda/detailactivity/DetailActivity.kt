package com.wanda.detailactivity

import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.wanda.detailactivity.databinding.ActivityDetailBinding
import kotlin.math.abs

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Wanda Khoirunnisa"
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val myName = "Wanda khoirunnisa"
        val myRole = "Android Developer"
        val avatar = R.drawable.walpaper4

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.iv1.setImageDrawable(ContextCompat.getDrawable(this, avatar))
        binding.tvName.text = myName
        binding.tvRole.text = myRole


        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange==0){
                /// COLLAPSED
                Log.e("AppbarLayout","collapsed")
                binding.toolbarLayout.title = myName
                } else{
                    /// EXPANDED
                Log.e("AppBarLayout ","expanded")
                binding.toolbarLayout.title = ""

            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()


    }
}