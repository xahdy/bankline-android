package com.dio.bankline.android.ui.statement

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.bankline.android.R
import com.dio.bankline.android.data.State
import com.dio.bankline.android.databinding.ActivityBankStatementBinding
import com.dio.bankline.android.databinding.ActivityWelcomeBinding
import com.dio.bankline.android.domain.Correntista
import com.dio.bankline.android.domain.Movimentacao
import com.dio.bankline.android.domain.TipoMovimentacao
import com.google.android.material.snackbar.Snackbar

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ACCOUNT_HOLDER = "com.dio.bankline.android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy { ActivityBankStatementBinding.inflate(layoutInflater) }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    private val  viewModel by viewModels<BankStatementViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
        binding.srlBankStatement.setOnRefreshListener { findBankStatement() }
    }

    private fun findBankStatement() {
        viewModel.findBankStatement(accountHolder.id).observe(this){ state ->
            when(state){
                is State.Success -> {
                binding.rvBankStatement.adapter = state.data?.let {BankStatementAdapter(it)}
                    binding.srlBankStatement.isRefreshing = false
                }
                is State.Error -> {
                    state.message?.let { Snackbar.make(binding.rvBankStatement, it, Snackbar.LENGTH_LONG).show() }
                    binding.srlBankStatement.isRefreshing = false
                }
                State.Wait -> binding.srlBankStatement.isRefreshing = true
            }

        }
    }


}