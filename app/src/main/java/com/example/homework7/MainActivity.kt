package com.example.homework7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.homework7.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            if (binding.input.text.toString() == "") {
                Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (binding.numericCheck.isChecked) {
                if (isNumeric(binding.input.text.toString())) {
                    val newEditText = EditText(this)
                    newEditText.hint = binding.input.text

                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    newEditText.layoutParams = layoutParams
                    binding.layoutOne.addView(newEditText)

                    binding.input.text?.clear()
                } else {
                    Toast.makeText(this, "Please un-tick numeric checkbox", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                if (!isNumeric(binding.input.text.toString())) {
                    val newEditText = EditText(this)
                    newEditText.hint = binding.input.text

                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    newEditText.layoutParams = layoutParams
                    binding.layoutTwo.addView(newEditText)
                    binding.input.text?.clear()
                } else {
                    Toast.makeText(this, "Please tick numeric checkbox", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isNumeric(input: String): Boolean {
        return try {
            input.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}