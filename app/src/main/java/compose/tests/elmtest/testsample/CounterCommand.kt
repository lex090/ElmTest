package compose.tests.elmtest.testsample

sealed class CounterCommand {
    object InitCommand : CounterCommand()
}