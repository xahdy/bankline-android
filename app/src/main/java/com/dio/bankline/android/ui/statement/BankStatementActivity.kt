package com.dio.bankline.android.ui.statement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dio.bankline.android.R
import com.dio.bankline.android.databinding.ActivityBankStatementBinding
import com.dio.bankline.android.databinding.ActivityWelcomeBinding
import com.dio.bankline.android.domain.Correntista

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

        Log.d("teste", "Chegou o ID: ${accountHolder.id}")
    }
}