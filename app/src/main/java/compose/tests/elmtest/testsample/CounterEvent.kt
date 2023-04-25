package compose.tests.elmtest.testsample

sealed class CounterEvent {
    sealed class UI : CounterEvent() {
        object Inc : UI()
        object Dec : UI()
    }

    sealed class Inner : CounterEvent() {
        object Initial : Inner()
        class InitialResult(val count: Int) : Inner()
    }
}