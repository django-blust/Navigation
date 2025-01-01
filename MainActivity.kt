package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AppScaffold()
            }
        }
    }
}

@Composable
fun AppScaffold() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("details") { DetailsScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("details") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Go to Details", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("profile") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Go to Profile", color = Color.White)
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Details Screen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Go to Home", color = Color.White)
        }
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Screen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Go to Home", color = Color.White)
        }
    }
}
