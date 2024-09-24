package com.example.churraspar

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.verificadordeidade.R
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var editTextHomens: EditText
    private lateinit var editTextMulheres: EditText
    private lateinit var editTextCriancas: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var buttonLimpar: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHomens = findViewById(R.id.editTextHomens)
        editTextMulheres = findViewById(R.id.editTextMulheres)
        editTextCriancas = findViewById(R.id.editTextCriancas)
        buttonCalcular = findViewById(R.id.buttonCalcular)
        buttonLimpar = findViewById(R.id.buttonLimpar)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener {
            calcularChurrasco()
        }

        buttonLimpar.setOnClickListener {
            limparCampos()
        }
    }

    private fun calcularChurrasco() {
        val homens = editTextHomens.text.toString().toIntOrNull() ?: 0
        val mulheres = editTextMulheres.text.toString().toIntOrNull() ?: 0
        val criancas = editTextCriancas.text.toString().toIntOrNull() ?: 0

        val carneHomens = homens * 400
        val carneMulheres = mulheres * 300
        val carneCriancas = criancas * 200
        val carneTotal = ceil((carneHomens + carneMulheres + carneCriancas) * 1.1)

        val aperitivosHomens = homens * 150
        val aperitivosMulheres = mulheres * 100
        val aperitivosCriancas = criancas * 50
        val aperitivosTotal = ceil((aperitivosHomens + aperitivosMulheres + aperitivosCriancas) * 1.1)

        val bebidaAlcoolHomens = homens * 4.0
        val bebidaAlcoolMulheres = mulheres * 2.0
        val bebidaAlcoolTotal = ceil((bebidaAlcoolHomens + bebidaAlcoolMulheres) * 1.1)

        val aguaTotal = ceil((mulheres + criancas) * 2.0 * 1.1)
        val refrigeranteTotal = ceil((mulheres + criancas) * 1.5 * 1.1)
        
        textViewResultado.text = """
            Carne: ${carneTotal.toInt()}g
            Aperitivos: ${aperitivosTotal.toInt()}g
            Bebida Alcoólica: ${bebidaAlcoolTotal.toInt()}L
            Água: ${aguaTotal.toInt()}L
            Refrigerante: ${refrigeranteTotal.toInt()}L
        """.trimIndent()
    }

    private fun limparCampos() {
        editTextHomens.text.clear()
        editTextMulheres.text.clear()
        editTextCriancas.text.clear()
        textViewResultado.text = "Resultado será exibido aqui"
    }
}