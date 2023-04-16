package compose.tests.elmtest.ui.reducers

import compose.tests.elmtest.ui.events.MiniBetslipDataLayerEvents
import compose.tests.elmtest.ui.states.CoefficientState
import compose.tests.elmtest.ui.states.MiniBetslipTitleState

//fun miniBetslipReducer(
//    states: MiniBetslipState,
//    events: MiniBetslipDataLayerEvents
//): Pair<MiniBetslipState, Unit> {
//    when(states) {
//        MiniBetslipState.Invisible -> {
//            when (events) {
//                is MiniBetslipDataLayerEvents.Init -> {
//                    val countItems = events.countBetslipItems
//                    when {
//                        countItems == 1 -> {
//                            MiniBetslipState.Visible(
//                                content = MiniBetslipTitleState.Single(
//                                    title = events.title,
//                                    subtitle = events.subtitle.orEmpty()
//                                ),
//                                kf = CoefficientState.Default(
//                                    kf = events.kf.toString()
//                                )
//                            )
//                        }
//                        countItems > 1 -> {
//                            MiniBetslipState.Visible(
//                                content = MiniBetslipTitleState.Multiple(
//                                    title = events.title,
//                                ),
//                                kf = CoefficientState.Default(
//                                    kf = events.kf.toString()
//                                )
//                            )
//                        }
//                        else -> {
//                            MiniBetslipState.Invisible
//                        }
//                    }
//                }
//                is MiniBetslipDataLayerEvents.OnUpdateReceive -> {
//
//                }
//            }
//        }
//        is MiniBetslipState.Visible -> {
//            when (events) {
//                is MiniBetslipDataLayerEvents.Init -> {
//                    if (events.countBetslipItems > 0) {
//                        MiniBetslipState.Visible(
//                            content = miniBetslipTitleReducer(states.content, events),
//                            kf = miniBetslipKfReducer(states.kf, events)
//                        )
//                    } else {
//                        MiniBetslipState.Invisible
//                    }
//                }
//                is MiniBetslipDataLayerEvents.OnUpdateReceive -> {
//                    if (events.countBetslipItems > 0) {
//                        MiniBetslipState.Visible(
//                            content = miniBetslipTitleReducer(states.content, events),
//                            kf = miniBetslipKfReducer(states.kf, events)
//                        )
//                    } else {
//                        MiniBetslipState.Invisible
//                    }
//                }
//            }
//        }
//    }
//    return TODO()
//}

fun miniBetslipTitleReducer(
    states: MiniBetslipTitleState, events: MiniBetslipDataLayerEvents
): MiniBetslipTitleState {
    return TODO()
}

fun miniBetslipKfReducer(
    states: CoefficientState, events: MiniBetslipDataLayerEvents
): CoefficientState {
    return TODO()
}