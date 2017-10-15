package com.example.mvcmvpmvvm.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.mvcmvpmvvm.R
import android.view.MenuItem
import com.example.mvcmvpmvvm.databinding.TictactoeBinding
import com.example.mvcmvpmvvm.viewmodel.TicTacToeViewModel


class TicTacToeActivity : AppCompatActivity() {

    internal var viewModel = TicTacToeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : TictactoeBinding = DataBindingUtil.setContentView(this, R.layout.tictactoe)
        binding.setViewModel(viewModel)
        viewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_reset -> {
                viewModel.onResetSelected()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
