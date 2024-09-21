package com.example.recordatoriosyalarmasux

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recordatoriosyalarmasux.ui.theme.RecordatoriosYAlarmasUXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        /*setContent {
            RecordatoriosYAlarmasUXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/

        val btnGuest: Button = findViewById(R.id.btnSignGuest)
        btnGuest.setOnClickListener{
            val intent = Intent(this, listado_alarmas::class.java)
            startActivity(intent)
            //setContentView(R.layout.activity_listado_alarmas)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecordatoriosYAlarmasUXTheme {
        Greeting("Android")
    }
}