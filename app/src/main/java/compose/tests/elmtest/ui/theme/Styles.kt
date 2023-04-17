package compose.tests.elmtest.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import compose.tests.elmtest.R

class AppStyles(
    coefficientStyle: CoefficientStyle,
    isLight: Boolean
) {
    var coefficientStyles by mutableStateOf(coefficientStyle)
        private set

    var isLight by mutableStateOf(isLight)
        internal set
}

val lightAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.light,
    isLight = true
)

val darkAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.dark,
    isLight = false
)

data class CoefficientStyle(
    val increaseColor: Color,
    val decreaseColor: Color,
    val defaultColor: Color,
    @DrawableRes val increaseIcon: Int,
    @DrawableRes val decreaseIcon: Int,
) {
    companion object {
        val light = CoefficientStyle(
            increaseColor = LightPalette.green_700,
            decreaseColor = LightPalette.red_700,
            defaultColor = LightPalette.blue_700,
            increaseIcon = R.drawable.ic_coefficient_increase,
            decreaseIcon = R.drawable.ic_coefficient_decrease,
        )

        val dark = CoefficientStyle(
            increaseColor = DarkPalette.green_700,
            decreaseColor = DarkPalette.red_500,
            defaultColor = DarkPalette.blue_600,
            increaseIcon = R.drawable.ic_coefficient_increase,
            decreaseIcon = R.drawable.ic_coefficient_decrease,
        )
    }
}