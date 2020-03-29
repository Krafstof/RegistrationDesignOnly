package com.example.registrationdesignonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val animationFromLeftToRight = TranslateAnimation(0F, 3200F, 0F, 0F)
        animationFromLeftToRight.duration = 3000
        val animationFromRightToLeft = TranslateAnimation(1200F, -2200F, 0F, 0F)
        animationFromRightToLeft.duration = 4000
        car1st.startAnimation(animationFromRightToLeft)
        car2nd.startAnimation(animationFromLeftToRight)
    }
}
