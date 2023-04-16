package compose.tests.elmtest.ui.components.minibetslip

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.tests.elmtest.ui.components.events.Coefficient
import compose.tests.elmtest.ui.states.CoefficientState
import compose.tests.elmtest.ui.states.MiniBetslipTitleState
import compose.tests.elmtest.ui.states.MiniBetslipVisibilityState

@SuppressLint("UnusedTransitionTargetStateParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MiniBetslip(
    visibilityState: MiniBetslipVisibilityState,
    titleState: MiniBetslipTitleState,
    coefficientState: CoefficientState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visibilityState.isVisible,
        enter = fadeIn() + scaleIn(),
        exit = fadeOut() + scaleOut(),
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = 16.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .clickable(onClick = onClick)

            ) {
                MiniBetslipLogo(modifier = Modifier.size(48.dp))
                MiniBetslipTitle(
                    state = titleState,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(start = 16.dp)
                )
                Coefficient(
                    state = coefficientState,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp)
                )
            }

        }
    }
}