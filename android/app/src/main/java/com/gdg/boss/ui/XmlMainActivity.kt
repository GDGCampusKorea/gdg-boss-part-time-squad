package com.gdg.boss.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.gdg.boss.FragmentAdapter
import com.gdg.boss.R
import com.gdg.boss.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlMainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<XmlMainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFragmentAdapter()
        setupBottomNavigationView()

        if (savedInstanceState == null) {
            binding.bottomNavMain.selectedItemId = R.id.menu_home
        }
    }

    private fun setupFragmentAdapter() {
        val fragmentAdapter = FragmentAdapter(this)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.commit()
//        fragmentTransaction.add(binding.mainFcv.id, recordFragment, binding.mainFcv.tag)

    }

    private fun setupBottomNavigationView() {
        binding.bottomNavMain.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val prevFragment = supportFragmentManager.fragments.find {
            it.isVisible
        }

        if (prevFragment != null) {
            supportFragmentManager.beginTransaction().hide(prevFragment).commitNow()
        }

        when (item.itemId) {
            R.id.menu_write -> {
            }
            R.id.menu_home -> {
                val homeFragment = supportFragmentManager.fragments.find { it is HomeFragment }
                if (homeFragment != null) {
                    supportFragmentManager.beginTransaction().show(homeFragment).commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, HomeFragment.newInstance())
                        .commit()
                }
            }
            R.id.menu_find_job -> {
            }
        }

        return true
    }
}
