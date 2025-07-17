package com.example.halalcheck.ui.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcrScreen(navController: NavController) {

    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var recognizedText by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        uri:Uri? ->
        imageUri = uri

        uri?.let {
            isProcessing = true
            val inputImage = InputImage.fromFilePath(context,it)
            val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

            recognizer.process(inputImage)
                .addOnSuccessListener { visionText->
                    recognizedText = visionText.text
                    isProcessing = false
                }
                .addOnFailureListener { e->
                    recognizedText = "Error: ${e.message}"
                    isProcessing = false
                }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("OCR Scan") })
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { launcher.launch("image/*") }) {
                Text(text = "Select an Image")
            }
            Spacer(modifier = Modifier.height(16.dp))
            imageUri?.let {uri->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (isProcessing){
                CircularProgressIndicator()
            }else if (recognizedText.isNotEmpty()){
                Text(
                    text = "Extracted text:",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = recognizedText)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("result") }
            ) {
                Text("Result")
            }
        }
    }
}
