package com.example.halalcheck.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.halalcheck.R
import dagger.hilt.android.qualifiers.ApplicationContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    val viewModel: ProductViewModel = hiltViewModel()

    val products by viewModel.allProducts.collectAsState(initial = emptyList())



    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "Powered by Halal Check",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    ) { paddingValues ->
       Box (modifier = Modifier
           .fillMaxSize()
           .background(
               brush = Brush.verticalGradient(
                   colors = listOf(
                       Color(0xFF2F9369),
                       Color(0xFF6BDDA0)
                   )
               )
           )
       ){
           Column(
               modifier = Modifier.fillMaxSize().padding(paddingValues),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Row (modifier = Modifier.padding(top = 100.dp)
               ){
                   Text(text = "Halal Check",
                       style = MaterialTheme.typography.headlineLarge,
                       fontWeight = FontWeight.Bold,
                       fontSize = 50.sp,
                       color = Color.White
                   )
               }

               Spacer(modifier = Modifier.height(10.dp))

               Row(modifier = Modifier.padding(top = 25.dp)
               ){
                   Image(
                       painter = painterResource(id = R.drawable.shopping_cart_icon),
                       contentDescription = null,
                       modifier = Modifier.size(300.dp)
                   )
               }
               Row (
                   modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                   horizontalArrangement = Arrangement.Center

               ){
                   Button(
                       onClick = { navController.navigate("ocr") },
                       modifier = Modifier.width(320.dp).height(80.dp),
                       colors = ButtonColors(
                           containerColor = Color(0xFFB7E4C7),
                           contentColor = Color(0xFF1D2C05),
                           disabledContainerColor = Color.Unspecified,
                           disabledContentColor = Color.Unspecified
                       ),
                       shape = MaterialTheme.shapes.extraLarge
                       ) {
                       Icon(painterResource(id = R.drawable.outline_barcode_scanner_24),
                           contentDescription = null,
                           modifier = Modifier.size(70.dp))
                       Spacer(modifier = Modifier.width(10.dp))
                       Text(text = "Scan Barcode",
                           fontSize = 30.sp,
                           fontWeight = FontWeight.Bold
                       )
                   }
               }
               Spacer(modifier = Modifier.height(10.dp))
               Row (modifier = Modifier
                   .fillMaxWidth()
                   .padding(top = 10.dp),
                   horizontalArrangement = Arrangement.Center

               ){
                   Button(
                       onClick = { /*TODO*/ },
                       modifier = Modifier.width(320.dp).height(80.dp),
                       colors = ButtonColors(
                           containerColor = Color(0xFFB7E4C7),
                           contentColor = Color(0xFF1D2C05),
                           disabledContainerColor = Color.Unspecified,
                           disabledContentColor = Color.Unspecified
                       ),
                       shape = MaterialTheme.shapes.extraLarge
                   ) {
                       Icon(painterResource(id = R.drawable.outline_image_24),
                           contentDescription = null,
                           modifier = Modifier.size(70.dp))
                       Spacer(modifier = Modifier.width(10.dp))
                       Text(text = "Pick an Image",
                           fontSize = 30.sp,
                           fontWeight = FontWeight.Bold
                       )
                   }
               }
           }
       }
    }
}