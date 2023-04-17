package compose.tests.elmtest.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.tests.elmtest.ui.components.minibetslip.MiniBetslip
import compose.tests.elmtest.ui.states.CoefficientChangingState
import compose.tests.elmtest.ui.states.CoefficientState
import compose.tests.elmtest.ui.states.MiniBetslipTitleState
import compose.tests.elmtest.ui.states.MiniBetslipVisibilityState

@Composable
fun MainScreen(
    isDark: Boolean,
    onChangeColor: (Boolean) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        var visibilitySate: MiniBetslipVisibilityState by remember {
            mutableStateOf(
                MiniBetslipVisibilityState(isVisible = true)
            )
        }
        var titleState: MiniBetslipTitleState by remember {
            mutableStateOf(
                MiniBetslipTitleState(
                    isMultiple = false,
                    title = "Test title",
                    subtitle = "Test subtitle"
                )
            )
        }
        var coefficientSate: CoefficientState by remember {
            mutableStateOf(
                CoefficientState(
                    coefficientChangingState = CoefficientChangingState.Default,
                    coefficient = "14.6"

                )
            )
        }

        Column {
            Checkbox(
                checked = isDark,
                onCheckedChange = onChangeColor
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Button(onClick = { visibilitySate = visibilitySate.copy(isVisible = false) }) {
                    Text("Hide")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = { visibilitySate = visibilitySate.copy(isVisible = true) }) {
                    Text("Add")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Button(onClick = { titleState = titleState.copy(isMultiple = true) }) {
                    Text("Single")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = { titleState = titleState.copy(isMultiple = false) }) {
                    Text("Multiple")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Button(onClick = {
                    coefficientSate =
                        coefficientSate.copy(
                            coefficientChangingState = CoefficientChangingState.Decrease,
                            coefficient = "5.1"
                        )
                }) {
                    Text("Decrease")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = {
                    coefficientSate =
                        coefficientSate.copy(
                            coefficientChangingState = CoefficientChangingState.Increase,
                            coefficient = "32.89"
                        )
                }) {
                    Text("Increase")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = {
                    coefficientSate =
                        coefficientSate.copy(coefficientChangingState = CoefficientChangingState.Default)
                }) {
                    Text("Default")
                }
            }
        }

        MiniBetslip(
            visibilityState = visibilitySate,
            titleState = titleState,
            coefficientState = coefficientSate,
            onClick = {},
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .align(alignment = Alignment.BottomCenter),
        )
    }
}