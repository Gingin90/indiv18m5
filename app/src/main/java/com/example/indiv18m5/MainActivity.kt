 package com.example.indiv18m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.indiv18m5.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGuardar.setOnClickListener{
            val texto = binding.etTexto.text.toString()
            val entero = binding.etTexto.text.toString().toInt()
            val decimal = binding.etDecimal.text.toString().toFloat()
            val switch = binding.switch1.isChecked

            guardarDatos(texto,entero,decimal ,switch)


        }
        binding.btMostrar.setOnClickListener{
            mostrarDatos()
        }
    }
}
 private fun guardarDatos(texto:String,entero:Int,decimal:Double,switch:Boolean){

 }