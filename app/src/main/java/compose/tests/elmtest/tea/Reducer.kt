package compose.tests.elmtest.tea

interface Reducer<State : Any, Event : Any, Effect : Any, Command : Any> {

    fun reduce(
        state: State,
        event: Event
    ): TeaResult<State, Effect, Command>
}