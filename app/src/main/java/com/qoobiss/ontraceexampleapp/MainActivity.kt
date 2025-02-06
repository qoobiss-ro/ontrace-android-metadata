package com.qoobiss.ontraceexampleapp

import android.os.Bundle
import android.util.Log
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
import com.qoobiss.ontraceexampleapp.ui.theme.OntraceExampleAppTheme
import com.qoobiss.ontracesdk.OntraceSDK
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			OntraceExampleAppTheme {
				OntraceSDK.EntryPoint("API_KEY",
					{
					Log.d("tag message","onMessage from client $it")
				}, {
					Log.d("tag complete", "onComplete from client $it")
				}, this)
			}
		}
	}
}