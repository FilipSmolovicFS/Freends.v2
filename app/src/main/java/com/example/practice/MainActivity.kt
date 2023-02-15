package com.example.practice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.overview.SettingsFragment

class MainActivity : AppCompatActivity(), LoginFragment.LoginFragmentInterface,
    PostsFragment.PostsFragmentInterface {

    private lateinit var binding : ActivityMainBinding

    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sp = getSharedPreferences("MySharedPreferences",Context.MODE_PRIVATE)

        /*Remove App name*/
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Dark Mode ON*/
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        replaceFragment(LoginFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.posts -> replaceFragment(PostsFragment())
                R.id.settings-> replaceFragment(SettingsFragment())

                else ->{
                }
            }
            true
        }



    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment,fragment)
        fragmentTransaction.commit()
    }

    /*OVERRIDE-am F-JU IZ INTERFACE-a IZ LOGINFRAGMENTA
    * I POZIVAM DA SE IZVRSI ZAMENA FRAGMENATA ZA BOTOM NAV*/
    override fun onLoginBtnClicked() {
        replaceFragment(PostsFragment())
    }

    override fun onNavigation(fragment: Fragment) {
        replaceFragment(fragment)
    }


}