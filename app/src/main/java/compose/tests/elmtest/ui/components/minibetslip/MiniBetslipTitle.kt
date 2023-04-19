package compose.tests.elmtest.ui.components.minibetslip

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.tests.elmtest.ui.states.MiniBetslipTitleState

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MiniBetslipTitle(
    state: MiniBetslipTitleState,
    modifier: Modifier = Modifier
) {
    // TODO: Не обработан кейс когда кф очень большой и он налезает на название
    Column(
        modifier = modifier
            .fillMaxWidth()
            .widthIn(min = 64.dp)
    ) {
        Column {
            val data = if (state.isMultiple) {
                DataAnimation(
                    color = Color(0xFF222222),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                )
            } else {
                DataAnimation(
                    color = Color(0xFF222222),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700
                )
            }
            AnimatedContent(
                targetState = data,
                transitionSpec = { fadeIn() + scaleIn() with fadeOut() + scaleOut() }
            ) { animationData ->
                Text(
                    text = state.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = animationData.color,
                        fontSize = animationData.fontSize,
                        fontWeight = animationData.fontWeight,
                        background = Color.Transparent
                    )
                )
            }

            AnimatedVisibility(
                visible = !state.isMultiple,
                enter = fadeIn() + scaleIn() + expandVertically(),
                exit = fadeOut() + scaleOut() + shrinkVertically()
            ) {
                requireNotNull(state.subtitle)
                Text(
                    text = state.subtitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Color(0xFF828282),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        background = Color.Transparent
                    )
                )
            }
        }
    }
}

data class DataAnimation(
    val color: Color,
    val fontSize: TextUnit,
    val fontWeight: FontWeight
)