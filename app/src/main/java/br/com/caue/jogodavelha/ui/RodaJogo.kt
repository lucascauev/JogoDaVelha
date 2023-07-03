package br.com.caue.jogodavelha.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import br.com.caue.jogodavelha.R

class RodaJogo : AppCompatActivity() {
    var isPlayer1 = true
    var gameEnd = false

    private lateinit var topCenter: ImageView
    private lateinit var topStart: ImageView
    private lateinit var topEnd: ImageView

    private lateinit var center: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerEnd: ImageView

    private lateinit var bottomCenter: ImageView
    private lateinit var bottomStart: ImageView
    private lateinit var bottomEnd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roda_jogo)

        Jogo()


    }

    private fun Jogo() {
        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.centerStart)
        centerEnd = findViewById(R.id.centerEnd)

        topCenter = findViewById(R.id.TopCenter)
        topStart = findViewById(R.id.TopStart)
        topEnd = findViewById(R.id.TopEnd)

        bottomCenter = findViewById(R.id.BottomCenter)
        bottomStart = findViewById(R.id.BottomStart)
        bottomEnd = findViewById(R.id.BottomEnd)

        val reset: Button = findViewById(R.id.buttonReset)
        reset.setOnClickListener {
            resetBox(center)
            resetBox(centerStart)
            resetBox(centerEnd)

            resetBox(topCenter)
            resetBox(topStart)
            resetBox(topEnd)

            resetBox(bottomCenter)
            resetBox(bottomStart)
            resetBox(bottomEnd)
        }

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(topCenter)
        configureBox(topStart)
        configureBox(topEnd)

        configureBox(bottomCenter)
        configureBox(bottomStart)
        configureBox(bottomEnd)
    }

    private fun resetBox(box: ImageView){
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }

    private fun configureBox(box: ImageView) {
        box.setOnClickListener {
            if (box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.baseline_remove_circle_24)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.baseline_close_24)
                    isPlayer1 = true
                    box.tag = 2
                }
                if (playerWin(1)){
                    Toast.makeText(this@RodaJogo, "Player 1 Venceu", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)){
                    Toast.makeText(this@RodaJogo, "Player 2 Venceu", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }
        }
    }

    private fun playerWin(value: Int): Boolean{
        if ( (topCenter.tag == value && center.tag == value && bottomCenter.tag == value) ||
            (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
            (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && topCenter.tag == value && topEnd.tag == value) ||
            (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
            (bottomStart.tag == value && bottomCenter.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && center.tag == value && bottomEnd.tag == value) ||
            (topEnd.tag == value && center.tag == value && bottomStart.tag == value)
        ){
            return true
        }
        return false
    }
}