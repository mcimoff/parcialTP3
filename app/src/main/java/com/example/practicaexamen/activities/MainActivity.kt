package com.example.practicaexamen.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practicaexamen.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment

        nav_view.setupWithNavController(navController.navController)


        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(),
            /*topLevelDestinationIds = setOf(
                R.id.fragment1,
                R.id.fragment2,

                R.id.fragment3
            ),*/
            fallbackOnNavigateUpListener = ::onSupportNavigateUp

        )


        setupActionBarWithNavController(navController.navController, appBarConfiguration)
        navController.navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        if (drawer_layout_id.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_id.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout_id.openDrawer(GravityCompat.START)
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }
}