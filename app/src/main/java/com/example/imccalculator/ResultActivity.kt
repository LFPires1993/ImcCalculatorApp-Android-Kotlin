package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.imccalculator.resources.Constants

class ResultActivity : AppCompatActivity() {
    lateinit var txtShowWeight: TextView
    lateinit var txtShowHeight: TextView

    lateinit var txtResult: TextView
    lateinit var txtClassification: TextView
    lateinit var btnReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bundle = intent.extras

        txtShowWeight = findViewById(R.id.txt_show_weight)
        txtShowHeight = findViewById(R.id.txt_show_height)

        txtResult = findViewById(R.id.txt_result)
        txtClassification = findViewById(R.id.txt_classification)
        btnReturn = findViewById(R.id.btn_back)


        println("Acima --------------------------")
        val weight = bundle?.getDouble("weight")
        val height = bundle?.getDouble("height")

        if (weight != null && height != null) {
            txtShowWeight.text = Constants.WEIGHT_SHOW(weight.toString())
            txtShowHeight.text = Constants.HEIGHT_SHOW(height.toString())

            val result = weight / ( height * height )

            txtResult.text = Constants.IMC_SHOW(String.format("%.2f", result))

            if (result < 18.5) {
                txtClassification.text = Constants.LOW
            } else if (result < 24.9) {
                txtClassification.text = Constants.NORMAL
            } else if (result < 29.9) {
                txtClassification.text = Constants.OVERWEIGHT
            } else {
                txtClassification.text = Constants.OBISITY
            }
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}