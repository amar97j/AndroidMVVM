package com.joincoded.islamicmvvm.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoanViewModel : ViewModel() {
        private val _monthlyInstallment = mutableStateOf(0.0)
        val monthlyInstallment: State<Double> = _monthlyInstallment

        private val _loanPeriod = mutableStateOf(0)
        val loanPeriod: State<Int> = _loanPeriod

        fun calculateInstallment(amount: Double, period: Int, maxInstallment: Double) {
            _monthlyInstallment.value = if (maxInstallment > 0) {
                maxInstallment
            } else {
                amount / period
            }

            _loanPeriod.value = if (maxInstallment > 0) {
                (amount / maxInstallment).toInt()
            } else {
                period
            }
        }
    }

