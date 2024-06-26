package com.example.corrutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.corrutines.ui.theme.CorrutinesTheme
import com.example.corrutines.viewmodels.StudentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CorrutinesTheme {
                // A surface container using the 'background' color from the theme
                var studentViewModel = StudentViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RuletaView(studentViewModel)
                }
            }
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
    var studentViewModel = StudentViewModel()
    CorrutinesTheme {
        RuletaView(studentViewModel)
    }
}

@Composable
fun RuletaView(studentViewModel: StudentViewModel){
    Column(Modifier.fillMaxSize()){
        Text(text= studentViewModel.selectedStudent)
        Button(onClick={studentViewModel.getData() },
            enabled = studentViewModel.enabledButton) {
            Text(text="Tendre suerte")

        }
    }
}