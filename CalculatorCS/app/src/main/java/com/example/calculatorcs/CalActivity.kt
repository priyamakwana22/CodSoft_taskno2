package com.example.calculatorcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorcs.databinding.ActivityCalBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAC.setOnClickListener {
            binding.txtInput.text = ""
            binding.txtResult.text = ""
        }
        binding.btn0.setOnClickListener {
            binding.txtInput.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.txtInput.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.txtInput.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.txtInput.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.txtInput.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.txtInput.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.txtInput.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.txtInput.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.txtInput.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.txtInput.append("9")
        }
        binding.btnPlus.setOnClickListener {
            binding.txtInput.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.txtInput.append("-")
        }
        binding.btnDivide.setOnClickListener {
            binding.txtInput.append("÷")
        }
        binding.btnMul.setOnClickListener {
            binding.txtInput.append("×")
        }
        binding.btnDot.setOnClickListener {
            binding.txtInput.append(".")
        }
        binding.btnBack.setOnClickListener {
            val currentText = binding.txtInput.text.toString()
            if (currentText.isNotEmpty()) {
                val newText = currentText.substring(0, currentText.length - 1)
                binding.txtInput.text = newText
            }
        }
        binding.btnEqual.setOnClickListener {
            val expression = ExpressionBuilder(binding.txtInput.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result==longResult.toDouble())
            {
                binding.txtResult.text = longResult.toString()
            }else{
                binding.txtResult.text = result.toString()
            }
        }
    }
}