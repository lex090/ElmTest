package compose.tests.elmtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import compose.tests.elmtest.ui.screens.MainScreen
import compose.tests.elmtest.ui.theme.MyCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            MyCustomTheme(
                isDarkTheme = isDarkTheme
            ) {
                MainScreen(
                    isDark = isDarkTheme,
                    onChangeColor = { isDarkTheme = it }
                )
            }
        }
    }
}
