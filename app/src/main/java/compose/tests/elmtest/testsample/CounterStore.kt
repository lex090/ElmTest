package compose.tests.elmtest.testsample

import compose.tests.elmtest.tea.AbstractStore

class CounterStore : AbstractStore<CounterState, CounterEvent, CounterEffect, CounterCommand>(
    initialState = CounterState(count = 0),
    initialEvent = CounterEvent.Inner.Initial,
    reducers = listOf(CounterReducer()),
    actors = listOf(CounterActor())
)