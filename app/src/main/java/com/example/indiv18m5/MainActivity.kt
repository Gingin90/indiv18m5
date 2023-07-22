 package com.example.indiv18m5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.indiv18m5.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var msharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        msharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)
        binding.btGuardar.setOnClickListener {
            val texto = binding.etTexto.text.toString()
            val entero = binding.etTexto.text.toString().toInt()
            val decimal = binding.etDecimal.text.toString().toFloat()
            val boleano = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal, boleano)


        }
        binding.btMostrar.setOnClickListener {
            mostrarDatos()
        }
        binding.btBorrar.setOnClickListener {
            borrarDatos()
        }


    }
 private fun guardarDatos(texto:String,entero:Int,decimal:Float,boleano:Boolean){
  msharedPreferences.edit().putString("mi texto",texto).apply()
  msharedPreferences.edit().putInt("mi Entero",entero).apply()
  msharedPreferences.edit().putFloat("mi Decimal", decimal ).apply()
  msharedPreferences.edit().putBoolean("mi Boleano",boleano).apply()



 }

     private fun mostrarDatos() {
         val texto = msharedPreferences.getString( "mi Boleano","")
         val entero = msharedPreferences.getInt( "mi Entero",0)
         val decimal = msharedPreferences.getFloat( "mi Decimal",0.0f)
         val boleano =  msharedPreferences.getBoolean( "mi Boleano",false)

         binding.tvTexto.text=texto
         binding.tvEntero.text= entero.toString()
         binding.tvDecimal.text= decimal.toString()
         binding.tvSwitch.text= boleano.toString()

         binding.switch1.isChecked=boleano

     }

     private fun borrarDatos(){
         binding.tvTexto.text=""
         binding.tvEntero.text= ""
         binding.tvDecimal.text= ""
         binding.tvSwitch.text= ""

       binding.etTexto.text.clear()
       binding.etEntero.text.clear()
       binding.etDecimal.text.clear()
         binding.switch1.isChecked= false

         msharedPreferences.edit().clear().apply()




     }


 }

