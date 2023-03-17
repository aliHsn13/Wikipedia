package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.ExploreFragment
import com.example.wikipedia.fragments.ProfileFragment
import com.example.wikipedia.fragments.TrendFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.MainToolbar)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.MainDrawer,
            binding.MainToolbar,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.MainDrawer.addDrawerListener(actionBarDrawerToggle)
        firstRun()
        actionBarDrawerToggle.syncState()
        navSelectItems()
        bottomnavSelectItem()




    }

    /***************************************************************
     this function close drawer after an item selected */
    fun closeDrawer(){
        binding.MainDrawer.closeDrawer(GravityCompat.START)
    }

    /*******************************************************************/
    fun firstRun() {

        replaceFragments(ExploreFragment())
        binding.bottomNavigation.selectedItemId = R.id.menu_explore

    }

    /****************************************************************
     this function select an item from navigation drawer after user clicked */
    fun navSelectItems() {

        binding.MainNavigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {closeDrawer()}
                R.id.menu_photograph -> {closeDrawer()}
                R.id.menu_video -> {closeDrawer()}
                R.id.menu_translator -> {closeDrawer()}
                R.id.menu_open_wikimedia -> {closeDrawer()}
                R.id.menu_open_wikipedia -> {closeDrawer()}
            }
            true
        }
    }
    /*****************************************************************
     * this function replace a fragment*/
    fun replaceFragments(fragment:Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }
    /***************************************************************
     * this function loads fragment after an item selected in bottom navigation menu*/

    fun bottomnavSelectItem(){
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_explore -> {replaceFragments(ExploreFragment())}
                R.id.menu_trend -> {replaceFragments(TrendFragment())}
                R.id.menu_profile -> {replaceFragments(ProfileFragment())}
            }
            true
        }
        //this line prevent fragment to load again
        binding.bottomNavigation.setOnItemReselectedListener {

        }
    }

}