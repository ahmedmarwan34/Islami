package com.route.islamiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.route.islamiapplication.fragments.ProfileFragment
import com.route.islamiapplication.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    lateinit var profileTextView : TextView
    lateinit var settingsTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileTextView = findViewById(R.id.profile_tv)
        settingsTextView = findViewById(R.id.settings_tv)

        pushFragment(ProfileFragment())
        profileTextView.setOnClickListener {
            pushFragment(ProfileFragment())
        }
        settingsTextView.setOnClickListener {
            pushFragment(SettingsFragment())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(supportFragmentManager.fragments.last() is SettingsFragment) {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            finish()
        }
    }

    fun pushFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}