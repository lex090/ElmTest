package compose.tests.elmtest.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import compose.tests.elmtest.R
import compose.tests.elmtest.ui.components.events.CoefficientStyle
import compose.tests.elmtest.ui.components.minibetslip.MiniBetslipLogoStyle

class AppStyles(
    coefficientStyle: CoefficientStyle,
    miniBetslipLogoStyle: MiniBetslipLogoStyle,
    isLight: Boolean
) {
    var coefficientStyle by mutableStateOf(coefficientStyle)
        private set

    var miniBetslipLogoStyle by mutableStateOf(miniBetslipLogoStyle)
        private set

    var isLight by mutableStateOf(isLight)
        internal set
}

val lightAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.light,
    miniBetslipLogoStyle = MiniBetslipLogoStyle.light,
    isLight = true
)

val darkAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.dark,
    miniBetslipLogoStyle = MiniBetslipLogoStyle.dark,
    isLight = false
)