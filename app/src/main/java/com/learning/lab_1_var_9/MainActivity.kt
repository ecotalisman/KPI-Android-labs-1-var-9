package com.learning.lab_1_var_9

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.learning.lab9.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productTypeRadioGroup: RadioGroup = findViewById(R.id.productTypeRadioGroup)
        val brandRadioGroup: RadioGroup = findViewById(R.id.brandRadioGroup)
        val okButton: Button = findViewById(R.id.okButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        okButton.setOnClickListener {
            val selectedProductTypeId = productTypeRadioGroup.checkedRadioButtonId
            val selectedBrandId = brandRadioGroup.checkedRadioButtonId

            if (selectedProductTypeId != -1 && selectedBrandId != -1) {
                val selectedProductType: RadioButton = findViewById(selectedProductTypeId)
                val selectedBrand: RadioButton = findViewById(selectedBrandId)
                resultTextView.text = getString(R.string.result_format, selectedProductType.text, selectedBrand.text)
            } else {
                resultTextView.text = getString(R.string.error_message)
            }
        }

        cancelButton.setOnClickListener {
            productTypeRadioGroup.clearCheck()
            brandRadioGroup.clearCheck()
            resultTextView.text = ""
        }
    }
}
