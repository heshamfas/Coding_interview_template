package com.heshamfas.ny_data

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

       setSupportActionBar(main_toolbar)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.schoolListFragment))
        val navController = findNavController(R.id.school_nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showToolbar(show:Boolean){
        main_toolbar.visibility = if(show) View.VISIBLE else View.GONE
    }

}
