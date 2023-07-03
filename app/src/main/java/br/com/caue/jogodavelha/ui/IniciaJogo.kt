package br.com.caue.jogodavelha.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import br.com.caue.jogodavelha.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class IniciaJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicia_jogo)
        botaoJogar()
        botaoInfJogo()
    }
    private fun botaoJogar(){
        val botao = findViewById<Button>(R.id.BotaoJogar)
        botao.setOnClickListener {
            jogar()
        }
    }

    private fun jogar() {
        val intent = Intent(this, RodaJogo::class.java)
        startActivity(intent)
    }

    private fun botaoInfJogo(){
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
         exibeInfo()
        }
    }

    private fun exibeInfo(){
        val intent = Intent(this, InfoDoJogo ::class.java)
        startActivity(intent)
    }
}