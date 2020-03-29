package com.example.registrationdesignonly

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.goodiebag.pinview.Pinview
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button2.setOnClickListener{
            val code = firstPinView.text.toString()
            if (code != null) {
                if (code.equals("000000")){
                    firstPinView.setText("")
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Ошибка")
                    builder.setMessage("Неверный код")
                    builder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
                    }
                    builder.show()
                }
            }
            if (code != null) {
                if (code.equals("111111")) {
                    val animation = TranslateAnimation(0F, 1200F, 0F, 0F)
                    animation.duration = 1000
                    val handler = Handler()
                    val runnable = Runnable { val intent = Intent(this, Main3Activity::class.java)
                        startActivity(intent) }
                    imageView2.startAnimation(animation)
                    handler.postDelayed(runnable, 900)
                    imageView2.visibility = View.INVISIBLE


                }
            }
        }
    }

}
