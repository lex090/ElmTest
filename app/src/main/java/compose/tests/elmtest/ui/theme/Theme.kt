package compose.tests.elmtest.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object MyCustomTheme {

    val styles: AppStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalAppStyles.current
}

internal val LocalAppStyles: ProvidableCompositionLocal<AppStyles> =
    staticCompositionLocalOf { lightAppStyles }

@Composable
fun MyCustomTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val styles = if (isDarkTheme) darkAppStyles else lightAppStyles
    CompositionLocalProvider(LocalAppStyles provides styles) {
        MaterialTheme(content = content)
    }
}