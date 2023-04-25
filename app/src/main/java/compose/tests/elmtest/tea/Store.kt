package compose.tests.elmtest.tea

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class AbstractStore<State : Any, Event : Any, Effect : Any, Command : Any>(
    initialState: State,
    initialEvent: Event? = null,
    private val reducers: List<Reducer<State, Event, Set<Effect>, Set<Command>>>,
    private val actors: List<Actor<Command, out Event>>
) {
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    private val _effects: MutableStateFlow<Effect?> = MutableStateFlow(null)
    val effects: StateFlow<Effect?> = _effects

    init {
        if (initialEvent != null) {
            dispatch(initialEvent)
        }
    }

    fun dispatch(event: Event) {
        reducers.forEach { reducer ->
            val result = reducer.reduce(state.value, event)
            _state.value = result.state

            result.command.forEach { command ->
                actors.forEach { actor ->
                    actor.execute(
                        command = command,
                        onComplete = { event -> dispatch(event) }
                    )
                }
            }

            result.effect.forEach { effect ->
                _effects.value = effect
            }
        }
    }
}