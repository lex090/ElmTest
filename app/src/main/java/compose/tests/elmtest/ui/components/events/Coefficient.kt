package compose.tests.elmtest.ui.components.events


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.tests.elmtest.ui.states.CoefficientChangingState
import compose.tests.elmtest.ui.states.CoefficientState
import compose.tests.elmtest.ui.theme.CoefficientStyle
import compose.tests.elmtest.ui.theme.MyCustomTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Coefficient(
    state: CoefficientState,
    modifier: Modifier = Modifier,
    coefficientStyle: CoefficientStyle = MyCustomTheme.styles.coefficientStyle
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        val color by animateColorAsState(
            targetValue = when (state.coefficientChangingState) {
                CoefficientChangingState.Decrease -> coefficientStyle.decreaseColor
                CoefficientChangingState.Default -> coefficientStyle.defaultColor
                CoefficientChangingState.Increase -> coefficientStyle.increaseColor
            }
        )

        AnimatedContent(
            targetState = state.coefficientChangingState,
            transitionSpec = {
                when (targetState) {
                    CoefficientChangingState.Decrease ->
                        fadeIn() + scaleIn() + slideInVertically() { height -> -height } with
                                fadeOut() + scaleOut() + slideOutVertically { height -> height }
                    CoefficientChangingState.Default -> fadeIn() with fadeOut()
                    CoefficientChangingState.Increase ->
                        fadeIn() + scaleIn() + slideInVertically() { height -> height } with
                                fadeOut() + scaleOut() + slideOutVertically { height -> -height }
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) { targetState ->
            when (targetState) {
                is CoefficientChangingState.Decrease -> {
                    Icon(
                        painter = painterResource(
                            id = coefficientStyle.decreaseIcon
                        ),
                        contentDescription = "Coefficient decrease",
                        tint = color,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(10.dp)
                    )
                }

                is CoefficientChangingState.Increase -> {
                    Icon(
                        painter = painterResource(
                            id = coefficientStyle.increaseIcon
                        ),
                        contentDescription = "Coefficient increase",
                        tint = color,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(10.dp)
                    )
                }
                else -> {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(10.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(4.dp))
        AnimatedContent(
            targetState = state.coefficient,
            transitionSpec = {
                (fadeIn() + scaleIn() with fadeOut() + scaleOut()).using(
                    SizeTransform(clip = false)
                )
            }
        ) { stateCh ->
            Text(
                text = stateCh,
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

@Preview
@Composable
fun CoefficientDefaultStatePreview() {
    Box {
        Coefficient(
            state = CoefficientState(
                coefficientChangingState = CoefficientChangingState.Default,
                coefficient = "15.26"
            )
        )
    }
}

@Preview
@Composable
fun CoefficientIncreaseStatePreview() {
    Box {
        Coefficient(
            state = CoefficientState(
                coefficientChangingState = CoefficientChangingState.Increase,
                coefficient = "15.26"
            )
        )
    }
}

@Preview
@Composable
fun CoefficientDecreaseStatePreview() {
    Box {
        Coefficient(
            state = CoefficientState(
                coefficientChangingState = CoefficientChangingState.Decrease,
                coefficient = "15.26"
            )
        )
    }
}