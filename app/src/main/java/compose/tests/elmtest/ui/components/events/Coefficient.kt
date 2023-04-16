package compose.tests.elmtest.ui.components.events


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.tests.elmtest.R
import compose.tests.elmtest.ui.states.CoefficientChangingState
import compose.tests.elmtest.ui.states.CoefficientState

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Coefficient(
    state: CoefficientState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        val color by animateColorAsState(
            targetValue = when (state.coefficientChangingState) {
                CoefficientChangingState.Decrease -> Color(0xFFB72C2C)
                CoefficientChangingState.Default -> Color(0xFF3960AC)
                CoefficientChangingState.Increase -> Color(0xFF298E52)
            }
        )

        AnimatedContent(state.coefficientChangingState) { stateCh ->
            when (stateCh) {
                is CoefficientChangingState.Decrease -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coefficient_decrease),
                        contentDescription = "Coefficient decrease",
                        tint = color
                    )
                }

                is CoefficientChangingState.Increase -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coefficient_increase),
                        contentDescription = "Coefficient increase",
                        tint = color
                    )
                }
                else -> {}
            }
        }

        Spacer(modifier = Modifier.size(4.dp))
        AnimatedContent(state.kf) { kf ->
            Text(
                text = kf,
                maxLines = 1,
                style = TextStyle(
                    color = color,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W700
                )
            )
        }
    }
}