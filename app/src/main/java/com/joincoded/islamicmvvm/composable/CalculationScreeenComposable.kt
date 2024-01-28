package com.joincoded.islamicmvvm.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joincoded.islamicmvvm.viewModel.LoanViewModel


@Composable
fun CalculationScreenComposable(
    viewModel: LoanViewModel = viewModel()) {


    var amount by remember { mutableStateOf(0.0) }
    var period by remember { mutableStateOf(0) }
    var maxInstallment by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = amount.toString(),
            onValueChange = { amount = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Loan Amount") }
        )


        OutlinedTextField(
            value = period.toString(),
            onValueChange = { period = it.toIntOrNull() ?: 0 },
            label = { Text("Loan Period in (Months)") }
        )


        OutlinedTextField(
            value = maxInstallment.toString(),
            onValueChange = { maxInstallment = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Max Installment ") }
        )


        Button(
            onClick = { viewModel.calculateInstallment(amount, period, maxInstallment) }
        ) {
            Text("Calculate")
        }


        Text("Monthly Installment: ${viewModel.monthlyInstallment.value}")
        Text("Loan Period: ${viewModel.loanPeriod.value}")
    }
}
