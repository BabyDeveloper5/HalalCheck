package com.example.halalcheck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.halalcheck.BuildConfig
import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.ui.viewmodel.ProductViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    val coroutineScope = rememberCoroutineScope()

    val viewModel: ProductViewModel = hiltViewModel()

    val products by viewModel.allProducts.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Halal Check") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*
            Button(
                onClick = { navController.navigate("ocr") }
            ) {
                Text(text = "Start Ingredient Scan")
            }
            if (BuildConfig.SHOW_DEV_CONTROLS) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        val sample = ProductEntity(
                            barcode = "1234567890",
                            name = "Sweetened Water",
                            ingredients = "Sugar, Water",
                            isHalal = true
                        )
                        coroutineScope.launch {
                            viewModel.insertProduct(sample)
                        }
                    }) {
                        Text("Add Test Product")
                    }

                    Button(onClick = {
                        val sample = ProductEntity(
                            barcode = "1234567890",
                            name = "Sweetened Water",
                            ingredients = "Sugar, Water",
                            isHalal = true
                        )
                        coroutineScope.launch {
                            viewModel.deleteProduct(sample)
                        }
                    }) {
                        Text("Delete Test Product")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show the current products
            for (product in products) {
                Text(text = "${product.name} (${product.barcode})\n" +
                        "ingredients: ${ product.ingredients}\n" +
                        if (product.isHalal)"Halal" else "Haram"
                )
            }
            */
            Spacer(modifier = Modifier.height(16.dp))

            // Branding / Short instructions
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Check if your product is Halal", style = MaterialTheme.typography.headlineSmall)
                Text("Scan barcode or pick an image of ingredients", style = MaterialTheme.typography.bodyMedium)
            }

            // Action Buttons
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth().wrapContentSize(),
                    onClick = { navController.navigate("barcode") }  // TODO: Set proper destination
                ) {
                    Text("Scan Barcode")
                }

                Button(
                    modifier = Modifier.fillMaxWidth().wrapContentSize(),
                    onClick = { navController.navigate("ocr") }  // TODO: Set proper destination
                ) {
                    Text("Pick Ingredient Image")
                }
            }

            // Dev-only controls
            if (BuildConfig.SHOW_DEV_CONTROLS) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(onClick = {
                            val sample = ProductEntity(
                                barcode = "1234567890",
                                name = "Dev Test Product",
                                ingredients = "Sugar, Water",
                                isHalal = true
                            )
                            coroutineScope.launch { viewModel.insertProduct(sample) }
                        }) {
                            Text("Add Test Product")
                        }

                        Button(onClick = {
                            val sample = ProductEntity(
                                barcode = "1234567890",
                                name = "Dev Test Product",
                                ingredients = "Sugar, Water",
                                isHalal = true
                            )
                            coroutineScope.launch { viewModel.deleteProduct(sample) }
                        }) {
                            Text("Delete Test Product")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}