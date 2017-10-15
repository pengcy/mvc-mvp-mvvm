package com.example.mvcmvpmvvm.presenter

import org.junit.Before
import com.example.mvcmvpmvvm.view.TicTacToeView
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Matchers.anyString
import org.mockito.Mockito.never

/**
 * There are a lot more tests we can and should write but for now, just a few smoke tests.
 */
@RunWith(MockitoJUnitRunner::class)
class TicTacToePresenterTests {

    private var presenter: TicTacToePresenter? = null

    @Mock
    private val view: TicTacToeView? = null

    @Before
    fun setup() {
        presenter = TicTacToePresenter(view!!)
    }

    private fun clickAndAssertValueAt(row: Int, col: Int, expectedValue: String) {
        presenter!!.onButtonSelected(row, col)
        verify(view)!!.setButtonText(row, col, expectedValue)
    }

    /**
     * This test will simulate and verify o is the winner.
     *
     * X | X | X
     * O |   |
     * | O |
     */
    @Test
    fun test3inRowAcrossTopForX() {

        clickAndAssertValueAt(0, 0, "X")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(1, 0, "O")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(0, 1, "X")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(2, 1, "O")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(0, 2, "X")
        verify(view)!!.showWinner("X")

    }


    /**
     * This test will simulate and verify x is the winner.
     *
     * O | X | X
     * | O |
     * | X | O
     */
    @Test
    fun test3inRowDiagonalFromTopLeftToBottomForO() {

        clickAndAssertValueAt(0, 1, "X")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(0, 0, "O")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(2, 1, "X")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(1, 1, "O")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(0, 2, "X")
        verify(view, never())!!.showWinner(anyString())

        clickAndAssertValueAt(2, 2, "O")
        verify(view)!!.showWinner("O")

    }


}