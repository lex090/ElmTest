package compose.tests.elmtest.testsample

sealed class CounterEffect {
    object ShowGracia : CounterEffect()
    object HideGracia : CounterEffect()
}