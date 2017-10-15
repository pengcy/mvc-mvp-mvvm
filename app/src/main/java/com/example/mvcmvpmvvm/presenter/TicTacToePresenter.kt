package com.example.mvcmvpmvvm.presenter

import com.example.mvcmvpmvvm.model.Board
import com.example.mvcmvpmvvm.view.TicTacToeView


class TicTacToePresenter(private val view: TicTacToeView) : Presenter {
    private var model: Board? = null

    init {
        this.model = Board()
    }

    override fun onCreate() {
        model = Board()
    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onButtonSelected(row: Int, col: Int) {
        val playerThatMoved = model!!.mark(row, col)

        if (playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString())

            if (model!!.winner != null) {
                view.showWinner(playerThatMoved.toString())
            }
        }
    }

    fun onResetSelected() {
        view.clearWinnerDisplay()
        view.clearButtons()
        model!!.restart()
    }


}