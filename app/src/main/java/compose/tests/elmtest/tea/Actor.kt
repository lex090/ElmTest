package compose.tests.elmtest.tea

interface Actor<Command : Any, InnerEvent : Any> {
    fun execute(
        command: Command,
        onComplete: (InnerEvent) -> Unit
    )
}