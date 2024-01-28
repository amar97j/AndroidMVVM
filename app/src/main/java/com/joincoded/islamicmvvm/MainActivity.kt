package com.joincoded.islamicmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joincoded.islamicmvvm.composable.CalculationScreenComposable
import com.joincoded.islamicmvvm.ui.theme.IslamicMVVMTheme
import com.joincoded.islamicmvvm.viewModel.LoanViewModel

class MainActivity : ComponentActivity() {


        private val viewModel: LoanViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                CalculationScreenComposable(viewModel = viewModel)
            }
        }
    }
