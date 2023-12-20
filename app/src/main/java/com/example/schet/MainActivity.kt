package com.example.schet

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.schet.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    var r = 0
    var ct = 0
    var cr = 0
    var cw = 0

    fun start(view: View){
        var a = (10..99).random()
        var b = (10..99).random()
        var c = (0..3).random()
        when (c){
            0 -> {
                binding.operator.text = "+"
                r = a + b
            }
            1 -> {
                binding.operator.text = "-"
                while(a - b < 0)
                {
                    a = (10..99).random()
                    b = (10..99).random()
                }
                r = a - b
            }
            2 -> {
                binding.operator.text = "*"
                r = a * b
            }
            3 -> {
                binding.operator.text = "/"
                while(a % b != 0)
                {
                    a = (10..99).random()
                    b = (10..99).random()
                }
                r = a / b
            }
        }
        binding.number1.text = a.toString()
        binding.number2.text = b.toString()
        binding.checkButton.isEnabled = true
        binding.startButton.isEnabled = false
        binding.result.isEnabled = true
        binding.result.text.clear()
        binding.linearLayout.setBackgroundColor(Color.TRANSPARENT)
    }
    fun check(view: View){
        if (binding.result.text.toString() == "")
        {
            return;
        }
        ct++
        var ans = binding.result.text.toString().toInt()
        if (ans == r){
            cr++
            binding.linearLayout.setBackgroundColor(Color.GREEN)
        }
        else{
            cw++
            binding.linearLayout.setBackgroundColor(Color.RED)
        }
        binding.tasksNumber.text = ct.toString()
        binding.rightAnswersNum.text = cr.toString()
        binding.wrongAnswersNum.text = cw.toString()
        var p: Double = Math.round(cr.toDouble() / ct * 10000) / 100.0
        binding.percentNum.text = p.toString() + "%"
        binding.checkButton.isEnabled = false
        binding.startButton.isEnabled = true
        binding.result.isEnabled = false
    }
}
