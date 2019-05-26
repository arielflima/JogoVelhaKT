package com.example.jogovelha

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val jogadorUm = arrayListOf<Int>()
    val jogadorDois = arrayListOf<Int>()
    var jogadorCorrente = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun play(posicao: Int, btnSelecionado: Button) {

        if (jogadorCorrente == 1) {
            btnSelecionado.text = "X"
            btnSelecionado.setBackgroundResource(R.color.corJogador1)
            jogadorUm.add(posicao)
            jogadorCorrente = 2
        } else {
            btnSelecionado.text = "O"
            btnSelecionado.setBackgroundResource(R.color.corJogador2)
            jogadorDois.add(posicao)
            jogadorCorrente = 1
        }

        btnSelecionado.isClickable = false
        checarResultado()

    }

    fun btnPosicao(view: View) = when (view.id) {
        R.id.btn1 -> play(1, view as Button)
        R.id.btn2 -> play(2, view as Button)
        R.id.btn3 -> play(3, view as Button)
        R.id.btn4 -> play(4, view as Button)
        R.id.btn5 -> play(5, view as Button)
        R.id.btn6 -> play(6, view as Button)
        R.id.btn7 -> play(7, view as Button)
        R.id.btn8 -> play(8, view as Button)
        R.id.btn9 -> play(9, view as Button)
        else -> play(0, view as Button)
    }

    fun checarResultado() {
        val linha1 = listOf(1, 2, 3)
        val linha2 = listOf(4, 5, 6)
        val linha3 = listOf(7, 8, 9)

        val coluna1 = listOf(1, 4, 7)
        val coluna2 = listOf(2, 5, 8)
        val coluna3 = listOf(3, 6, 9)

        val diagonal1 = listOf(1, 5, 9)
        val diagonal2 = listOf(3, 5, 7)

        var vencedor = -1

        if (jogadorUm.containsAll(linha1) || jogadorUm.containsAll(linha2) || jogadorUm.containsAll(linha3) ||
            jogadorUm.containsAll(coluna1) || jogadorUm.containsAll(coluna2) || jogadorUm.containsAll(coluna3) ||
            jogadorUm.containsAll(diagonal1) || jogadorUm.containsAll(diagonal2)
        ) {

            vencedor = 1
        } else if (jogadorDois.containsAll(linha1) || jogadorDois.containsAll(linha2) || jogadorDois.containsAll(linha3) ||
            jogadorDois.containsAll(coluna1) || jogadorDois.containsAll(coluna2) || jogadorDois.containsAll(coluna3) ||
            jogadorDois.containsAll(diagonal1) || jogadorDois.containsAll(diagonal2)
        ) {

            vencedor = 2
        }

        when (vencedor) {
            1 -> Toast.makeText(this, "Parabéns: Jogador 1 venceu!", Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, "Parabéns: Jogador 2 venceu!", Toast.LENGTH_LONG).show()

        }

    }

    fun reset(view: View){

        jogadorUm.clear()
        jogadorDois.clear()
        setContentView(R.layout.activity_main)

    }


}
