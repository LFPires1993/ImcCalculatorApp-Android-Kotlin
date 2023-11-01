package com.example.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.imccalculator.resources.Constants
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var txtInputLayoutWeight: TextInputLayout
    lateinit var txtInputWeight: TextInputEditText

    lateinit var txtInputLayoutHeight: TextInputLayout
    lateinit var txtInputHeight: TextInputEditText

    lateinit var btnResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInputLayoutWeight = findViewById(R.id.txt_input_layout_weight)
        txtInputWeight = findViewById(R.id.txt_input_weight)

        txtInputLayoutHeight = findViewById(R.id.txt_input_layout_height)
        txtInputHeight = findViewById(R.id.txt_input_height)

        btnResult = findViewById(R.id.btn_calculate)

        btnResult.setOnClickListener {
            txtInputLayoutWeight.error = null
            txtInputLayoutHeight.error = null

            val weight = txtInputWeight.text.toString()
            val height = txtInputHeight.text.toString()

            if (weight.isNullOrEmpty()) {
                txtInputLayoutWeight.error = Constants.WEIGHT_ERROR
            } else if (height.isNullOrEmpty()) {
                txtInputLayoutHeight.error = Constants.HEIGHT_ERROR
            } else {
                val i = Intent(this, ResultActivity::class.java)

                i.putExtra("weight", weight.toDouble())
                i.putExtra("height", height.toDouble())
                startActivity(i)
            }
        }
    }
}