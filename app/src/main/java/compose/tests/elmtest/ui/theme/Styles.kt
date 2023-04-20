package compose.tests.elmtest.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import compose.tests.elmtest.ui.components.events.CoefficientStyle
import compose.tests.elmtest.ui.components.minibetslip.MiniBetslipLogoStyle
import compose.tests.elmtest.ui.components.minibetslip.MiniBetslipStyle
import compose.tests.elmtest.ui.components.minibetslip.MiniBetslipTitleStyle

class AppStyles(
    coefficientStyle: CoefficientStyle,
    miniBetslipLogoStyle: MiniBetslipLogoStyle,
    miniBetslipStyle: MiniBetslipStyle,
    miniBetslipTitleStyle: MiniBetslipTitleStyle,
    isLight: Boolean
) {
    var coefficientStyle by mutableStateOf(coefficientStyle)
        private set

    var miniBetslipLogoStyle by mutableStateOf(miniBetslipLogoStyle)
        private set

    var miniBetslipStyle by mutableStateOf(miniBetslipStyle)
        private set

    var miniBetslipTitleStyle by mutableStateOf(miniBetslipTitleStyle)
        private set

    var isLight by mutableStateOf(isLight)
        internal set
}

val lightAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.light,
    miniBetslipLogoStyle = MiniBetslipLogoStyle.light,
    miniBetslipStyle = MiniBetslipStyle.light,
    miniBetslipTitleStyle = MiniBetslipTitleStyle.light,
    isLight = true
)

val darkAppStyles = AppStyles(
    coefficientStyle = CoefficientStyle.dark,
    miniBetslipLogoStyle = MiniBetslipLogoStyle.dark,
    miniBetslipStyle = MiniBetslipStyle.dark,
    miniBetslipTitleStyle = MiniBetslipTitleStyle.dark,
    isLight = false
)