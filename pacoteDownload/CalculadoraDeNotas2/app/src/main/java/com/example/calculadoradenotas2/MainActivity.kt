package com.example.calculadoradenotas2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradenotas2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btCalcular.setOnClickListener {

            val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val faltas = binding.faltas
            val resultado = binding.txtResultado // recuperar o texto para exibir na hora do término do cálculo.

            val nota1 = Integer.parseInt(num1.text.toString()) /* Aqui acontece a conversão dos
            numeros recebidos pelas variáveis do edit text para números inteiros. O algoritmo primeiro
            transforma em string depois transforma para numeros inteiros ( Integer)*/
            val nota2= Integer.parseInt(num2.text.toString())
            val nota3 = Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numeroFaltas = Integer.parseInt(faltas.text.toString())

            val media = (nota1 + nota2 + nota3 + nota4) /4 // Objetivo do APP

            if (media>=5 && numeroFaltas <= 20 ) {  // operador lógico && precisa dar verdadeiro nos 2 lados
                resultado.setText("Aluno foi Aprovado \n Média final $media") // definindo o texto para o aprovado
                resultado.setTextColor(getColor(R.color.green)) //definindo uma cor para o aprovado
            }else if(numeroFaltas>20){ // Defininfo reprovação
                resultado.setText(" Aluno foi reprovado por faltas \n Média final $media") //\n pula a linha 
                resultado.setTextColor(getColor(R.color.Red))

            }else if(media<5){ // definindo reprovação 2
                resultado.setText(" O aluno foi reprovado por nota \n Média final $media")
                resultado.setTextColor(getColor(R.color.Red))

            }






        }

    }
}