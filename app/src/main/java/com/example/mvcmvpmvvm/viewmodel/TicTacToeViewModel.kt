package com.example.mvcmvpmvvm.viewmodel

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import com.example.mvcmvpmvvm.model.Board


class TicTacToeViewModel : ViewModel {

    private val model: Board

    val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    val winner: ObservableField<String> = ObservableField()

    init {
        model = Board()
    }

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onResetSelected() {
        model.restart()
        winner.set(null)
        cells.clear()
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        cells.put("" + row + col, playerThatMoved?.toString())
        winner.set(if (model.winner == null) null else model.winner!!.toString())
    }

}