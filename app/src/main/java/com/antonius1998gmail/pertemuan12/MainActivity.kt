package com.antonius1998gmail.pertemuan12

import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        verticalLayout {
            topPadding = 20
            gravity = Gravity.CENTER_HORIZONTAL

            var resultAge = textView {
                text = "0"
                textSize = 150F
                typeface = Typeface.DEFAULT_BOLD
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                width = matchParent
            }

            val birthYear = editText {
                hint = "Enter year"
            }.lparams {
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
                leftMargin = 10
                rightMargin = 10
            }

            val btnFind = button {
                text = "Find My Age !"

                onClick {

                    val year = birthYear.text.toString().toInt()

                    val age = Calendar.getInstance().get(Calendar.YEAR) - year;

                    resultAge.text = age.toString()
                }
            }.lparams {
                topMargin = 10
                width = wrapContent
            }
        }
    }
}
