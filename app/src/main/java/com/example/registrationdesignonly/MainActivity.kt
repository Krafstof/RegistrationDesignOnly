package com.example.registrationdesignonly

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView1)
        val formatWatcher = MaskFormatWatcher(MaskImpl.createNonTerminated(PredefinedSlots.RUS_PHONE_NUMBER))
        formatWatcher.installOn(editText)

        button.setOnClickListener{
            val inputMask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
            inputMask.insertFront(editText.text)
            inputMask.toUnformattedString().substring(2)
            if (inputMask.toUnformattedString().substring(2)=="9000000000"){
                editText.setText("+7")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Ошибка")
                builder.setMessage("Пользователь не найден")
                builder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
                }
                builder.show()
            }
            if (inputMask.toUnformattedString().substring(2)=="9111111111") {
                val intent = Intent(this, Main2Activity::class.java)
                val options = ViewCompat.getTransitionName(imageView)?.let { it1 ->
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this, imageView,
                        it1
                    )
                }
                if (options != null) {
                    startActivity(intent, options.toBundle())
                }
            }
        }
    }
}
