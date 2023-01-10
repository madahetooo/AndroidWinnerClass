package com.bamboogeeks.winnerclass.nav_drawer_app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.bamboogeeks.winnerclass.R
import com.bamboogeeks.winnerclass.auth_system.LoginActivity
import com.bamboogeeks.winnerclass.databinding.ActivityNavigationDrawerAppBinding
import com.bamboogeeks.winnerclass.nav_drawer_app.fragments.ArchiveFragment
import com.bamboogeeks.winnerclass.nav_drawer_app.fragments.InboxFragment
import com.bamboogeeks.winnerclass.nav_drawer_app.fragments.SendFragment

class NavigationDrawerAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationDrawerAppBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationDrawerAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.miInbox ->{
                   val inboxFragment = InboxFragment()
                    setCurrentFragment(inboxFragment)
                    binding.drawerLayout.close()
                }
                R.id.miSent ->{
                    val sendFragment = SendFragment()
                    setCurrentFragment(sendFragment)
                    binding.drawerLayout.close()
                }
                R.id.miArchive ->{
                    val archiveFragment = ArchiveFragment()
                    setCurrentFragment(archiveFragment)
                    binding.drawerLayout.close()
                }
                R.id.miLogout ->{
                   val exitAlertDialog = AlertDialog.Builder(this)
                       .setIcon(R.drawable.ic_logout)
                       .setTitle("Exit")
                       .setMessage("Are you sure ?")
                       .setCancelable(false)
                       .setPositiveButton("Yes"){
                           dialogInterface:DialogInterface,
                               listner:Int ->
                           val intent = Intent(this,LoginActivity::class.java)
                           startActivity(intent)
                           finish()
                       }
                       .setNegativeButton("No"){
                               dialogInterface:DialogInterface,
                               listner:Int ->
                          dialogInterface.cancel()
                       }
                   val alertDialog =  exitAlertDialog.create()
                    alertDialog.show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.clContent,fragment)
            commit()
        }
}