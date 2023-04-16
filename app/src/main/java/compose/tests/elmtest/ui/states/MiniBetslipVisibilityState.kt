package compose.tests.elmtest.ui.states


data class MiniBetslipVisibilityState(val isVisible: Boolean)

data class MiniBetslipTitleState(
    val isMultiple: Boolean,
    val title: String,
    val subtitle: String?
)

data class CoefficientState(
    val coefficientChangingState: CoefficientChangingState,
    val kf: String
)

sealed class CoefficientChangingState {
    object Default : CoefficientChangingState()
    object Increase : CoefficientChangingState()
    object Decrease : CoefficientChangingState()
}