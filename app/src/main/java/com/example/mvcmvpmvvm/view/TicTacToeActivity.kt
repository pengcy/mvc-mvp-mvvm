package com.example.mvcmvpmvvm.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.mvcmvpmvvm.R
import android.view.View
import android.widget.Button
import com.example.mvcmvpmvvm.presenter.TicTacToePresenter
import kotlinx.android.synthetic.main.tictactoe.*


class TicTacToeActivity : AppCompatActivity(), TicTacToeView {

    internal var presenter = TicTacToePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictactoe)
        presenter.onCreate()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_reset -> {
                presenter.onResetSelected()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun onCellClicked(v: View) {

        val button = v as Button
        val tag = button.getTag().toString()
        val row = Integer.valueOf(tag.substring(0, 1))!!
        val col = Integer.valueOf(tag.substring(1, 2))!!
        Log.i(TAG, "Click Row: [" + row!! + "," + col!! + "]")

        presenter.onButtonSelected(row!!, col!!)

    }

    override fun setButtonText(row: Int, col: Int, text: String) {
        val btn = buttonGrid!!.findViewWithTag<View>("" + row + col) as Button
        if (btn != null) {
            btn!!.setText(text)
        }
    }

    override fun clearButtons() {
        for (i in 0 until buttonGrid!!.childCount) {
            (buttonGrid!!.getChildAt(i) as Button).setText("")
        }
    }

    override fun showWinner(winningPlayerDisplayLabel: String) {
        winnerPlayerLabel!!.text = winningPlayerDisplayLabel
        winnerPlayerViewGroup!!.setVisibility(View.VISIBLE)
    }

    override fun clearWinnerDisplay() {
        winnerPlayerViewGroup!!.setVisibility(View.GONE)
        winnerPlayerLabel!!.text = ""
    }

    companion object {

        private val TAG = TicTacToeActivity::class.java.name
    }
}
