package compose.tests.elmtest.ui.events

interface Events

sealed class MiniBetslipUIEvents: Events {
    object OnMiniBetslipClick: MiniBetslipUIEvents()
}

sealed class MiniBetslipDataLayerEvents: Events {
    data class Init(
        val countBetslipItems: Int,
        val title: String,
        val subtitle: String?,
        val kf: Long
    ): MiniBetslipDataLayerEvents()

    data class OnUpdateReceive(
        val countBetslipItems: Int,
        val title: String,
        val subtitle: String?,
        val kf: Long
    ): MiniBetslipDataLayerEvents()
}