package com.dio.bankline.android.ui.statement

import androidx.lifecycle.ViewModel
import com.dio.bankline.android.data.BanklineRepository

class BankStatementViewModel : ViewModel() {

    fun findBankStatement(accountHolderId: Int) =
        BanklineRepository.findBankStatement(accountHolderId)
}