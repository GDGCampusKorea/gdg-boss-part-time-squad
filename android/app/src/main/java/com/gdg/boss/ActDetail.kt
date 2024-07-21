package com.gdg.boss

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.gdg.boss.databinding.ActDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActDetail : AppCompatActivity() {

    /** onBackPressed Callback */
    private var backPressedCallback: OnBackPressedCallback? = null
    private lateinit var binding: ActDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
        setOnClickListener()
    }

    /**
     * Init Data
     */
    private fun initData() {

        with(binding) {

        }
    }

    /**
     * Init View
     */
    private fun initView() {

        with(binding) {

            /** onBackPressed Callback */
            backPressedCallback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    finish()
                }
            }
        }
    }

    /**
     * Init SetOnClickListener
     */
    private fun setOnClickListener() {

        with(binding) {

            // 뒤로가기
            ivBack.setOnClickListener {

                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
