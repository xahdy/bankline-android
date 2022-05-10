package com.dio.bankline.android.ui.statement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.bankline.android.R
import com.dio.bankline.android.databinding.ActivityBankStatementBinding
import com.dio.bankline.android.databinding.ActivityWelcomeBinding
import com.dio.bankline.android.domain.Correntista
import com.dio.bankline.android.domain.Movimentacao
import com.dio.bankline.android.domain.TipoMovimentacao

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ACCOUNT_HOLDER = "com.dio.bankline.android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy { ActivityBankStatementBinding.inflate(layoutInflater) }
    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 1000.0, TipoMovimentacao.RECEITA,1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 4000.0, TipoMovimentacao.RECEITA,1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 3000.0, TipoMovimentacao.DESPESA,1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 2000.0, TipoMovimentacao.RECEITA,1))
        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }


}