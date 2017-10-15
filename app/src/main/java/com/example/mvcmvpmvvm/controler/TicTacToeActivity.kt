package com.example.mvcmvpmvvm.controler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.mvcmvpmvvm.R
import com.example.mvcmvpmvvm.model.Board
import android.widget.Button
import kotlinx.android.synthetic.main.tictactoe.*


class TicTacToeActivity : AppCompatActivity() {

    private lateinit var model: Board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictactoe)

        model = Board()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_reset -> {
                reset()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun onCellClicked(v: View) {
        val button = v as Button
        val tag = button.getTag().toString()
        val row = Integer.valueOf(tag.substring(0, 1))
        val col = Integer.valueOf(tag.substring(1, 2))
        Log.i(TAG, "Click Row: [$row,$col]")

        val playerThatMoved = model.mark(row, col)

        if (playerThatMoved != null) {
            button.setText(playerThatMoved.toString())
            if (model.winner != null) {
                winnerPlayerLabel.text = playerThatMoved.toString()
                winnerPlayerViewGroup.setVisibility(View.VISIBLE)
            }
        }
    }

    private fun reset() {
        winnerPlayerViewGroup.setVisibility(View.GONE)
        winnerPlayerLabel.text = ""

        model.restart()

        for (i in 0 until buttonGrid.childCount) {
            (buttonGrid.getChildAt(i) as Button).setText("")
        }
    }

    companion object {
        private val TAG = TicTacToeActivity::class.java.name
    }

}
