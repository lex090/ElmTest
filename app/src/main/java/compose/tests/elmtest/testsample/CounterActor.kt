package compose.tests.elmtest.testsample

import compose.tests.elmtest.tea.Actor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterActor : Actor<CounterCommand, CounterEvent.Inner> {
    override fun execute(
        command: CounterCommand,
        onComplete: (CounterEvent.Inner) -> Unit
    ) {
        GlobalScope.launch {
            delay(3000)
            onComplete.invoke(CounterEvent.Inner.InitialResult(count = 144))
        }
    }
}