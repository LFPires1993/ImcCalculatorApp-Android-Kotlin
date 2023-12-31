package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.imccalculator.resources.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var txtShowWeight: TextView
    private lateinit var txtShowHeight: TextView

    private lateinit var txtResult: TextView
    private lateinit var txtClassification: TextView
    private lateinit var btnReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bundle = intent.extras

        txtShowWeight = findViewById(R.id.txt_show_weight)
        txtShowHeight = findViewById(R.id.txt_show_height)

        txtResult = findViewById(R.id.txt_result)
        txtClassification = findViewById(R.id.txt_classification)
        btnReturn = findViewById(R.id.btn_back)

        val weight = bundle?.getDouble("weight")
        val height = bundle?.getDouble("height")

        if (weight != null && height != null) {
            txtShowWeight.text = Constants.WEIGHT_SHOW(weight.toString())
            txtShowHeight.text = Constants.HEIGHT_SHOW(height.toString())

            val result = weight / ( height * height )

            txtResult.text = Constants.IMC_SHOW(String.format("%.2f", result))

            txtClassification.text = if (result < 18.5) {
                Constants.LOW
            } else if (result < 24.9) {
                Constants.NORMAL
            } else if (result < 29.9) {
                Constants.OVERWEIGHT
            } else {
                Constants.OBISITY
            }
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}