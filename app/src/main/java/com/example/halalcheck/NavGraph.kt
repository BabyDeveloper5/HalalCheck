package com.example.halalcheck

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.halalcheck.ui.screen.HomeScreen
import com.example.halalcheck.ui.screen.OcrScreen
import com.example.halalcheck.ui.screen.ResultScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController)
        }
        composable("ocr"){
            OcrScreen(navController)
        }
        composable("result"){
            ResultScreen(navController)
        }
    }
}