package compose.tests.elmtest.ui.components.minibetslip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.tests.elmtest.R

@Composable
fun MiniBetslipLogo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color(0xFFF4F4F4))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            tint = Color(0xFF5A82CF),
            contentDescription = "Logo icon",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun MiniBetslipLogoPreview() {
    Box(modifier = Modifier) {
        MiniBetslipLogo()
    }
}