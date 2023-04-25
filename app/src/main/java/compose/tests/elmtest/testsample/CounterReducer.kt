package compose.tests.elmtest.testsample

import compose.tests.elmtest.tea.Reducer
import compose.tests.elmtest.tea.TeaResult

class CounterReducer :
    Reducer<CounterState, CounterEvent, Set<CounterEffect>, Set<CounterCommand>> {
    override fun reduce(
        state: CounterState,
        event: CounterEvent
    ): TeaResult<CounterState, Set<CounterEffect>, Set<CounterCommand>> {
        return when (event) {
            CounterEvent.Inner.Initial -> TeaResult(
                state = state,
                setOf(),
                setOf(CounterCommand.InitCommand)
            )
            is CounterEvent.Inner.InitialResult -> TeaResult(
                state = state.copy(count = event.count),
                setOf(),
                setOf()
            )
            CounterEvent.UI.Dec -> {
                val currentCount = state.count - 1
                if (currentCount == 150) {
                    TeaResult(
                        state = state.copy(count = currentCount),
                        setOf(CounterEffect.ShowGracia),
                        setOf()
                    )
                } else {
                    TeaResult(
                        state = state.copy(count = currentCount),
                        setOf(CounterEffect.HideGracia),
                        setOf()
                    )
                }
            }
            CounterEvent.UI.Inc -> {
                val currentCount = state.count + 1
                if (currentCount == 150) {
                    TeaResult(
                        state = state.copy(count = currentCount),
                        setOf(CounterEffect.ShowGracia),
                        setOf()
                    )
                } else {
                    TeaResult(
                        state = state.copy(count = currentCount),
                        setOf(CounterEffect.HideGracia),
                        setOf()
                    )
                }
            }
        }
    }
}