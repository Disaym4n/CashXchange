package com.david.cashxchange.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.david.cashxchange.R
import com.david.cashxchange.helper.EndPoints
import com.david.cashxchange.helper.Utility.isNetworkAvailable
import com.david.cashxchange.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ViewModel
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_CashXchange)

        setContent {
            CashXchangeApp()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CashXchangeApp() {
        val context = LocalContext.current

        // Initialize selected items
        var selectedItem1 by remember { mutableStateOf("USD") }
        var selectedItem2 by remember { mutableStateOf("NG") }
        var amountText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Initialize both Spinners
            OutlinedTextField(
                value = selectedItem1,
                onValueChange = { selectedItem1 = it },
                label = { Text("Select Item 1") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = selectedItem2,
                onValueChange = { selectedItem2 = it },
                label = { Text("Select Item 2") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // EditText for entering the amount
            OutlinedTextField(
                value = amountText,
                onValueChange = { amountText = it },
                label = { Text("Enter Amount") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Check for empty string and internet connectivity, then do the conversion
                        val numberToConvert = amountText.toDoubleOrNull()
                        if (numberToConvert == null || numberToConvert == 0.0) {
                            // Show error message
                            Toast.makeText(context, "Input a valid amount", Toast.LENGTH_LONG).show()
                        } else if (isNetworkAvailable(context)) {
                            // Show no internet message
                            Toast.makeText(
                                context,
                                "You are not connected to the internet",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            // Perform the conversion
                            mainViewModel.getConvertedData(
                                EndPoints.API_KEY,
                                selectedItem1,
                                selectedItem2,
                                numberToConvert
                            )
                        }
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button for conversion
            Button(
                onClick = {
                    // Check for empty string and internet connectivity, then do the conversion
                    val numberToConvert = amountText.toDoubleOrNull()
                    if (numberToConvert == null || numberToConvert == 0.0) {
                        // Show error message
                        Toast.makeText(context, "Input a valid amount", Toast.LENGTH_LONG).show()
                    } else if (isNetworkAvailable(context)) {
                        // Show no internet message
                        Toast.makeText(
                            context,
                            "You are not connected to the internet",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        // Perform the conversion
                        mainViewModel.getConvertedData(
                            EndPoints.API_KEY,
                            selectedItem1,
                            selectedItem2,
                            numberToConvert
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Convert")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Other UI elements
            // ...
        }
    }
}