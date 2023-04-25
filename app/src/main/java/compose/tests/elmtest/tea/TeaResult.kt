package compose.tests.elmtest.tea

data class TeaResult<State: Any, Effect: Any, Command: Any>(
    val state: State,
    val effect: Effect,
    val command: Command
)