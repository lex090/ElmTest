package compose.tests.elmtest.ui.components.minibetslip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.tests.elmtest.R
import compose.tests.elmtest.ui.theme.DarkPalette
import compose.tests.elmtest.ui.theme.LightPalette
import compose.tests.elmtest.ui.theme.MyCustomTheme

data class MiniBetslipLogoStyle(
    val backgroundColor: Color,
    val iconColor: Color,
    @DrawableRes val logoIcon: Int
) {
    companion object {
        val light = MiniBetslipLogoStyle(
            backgroundColor = LightPalette.gray_100,
            iconColor = LightPalette.blue_700,
            logoIcon = R.drawable.ic_logo
        )

        val dark = MiniBetslipLogoStyle(
            backgroundColor = DarkPalette.gray_650,
            iconColor = DarkPalette.blue_600,
            logoIcon = R.drawable.ic_logo
        )
    }
}

@Composable
fun MiniBetslipLogo(
    modifier: Modifier = Modifier,
    style: MiniBetslipLogoStyle = MyCustomTheme.styles.miniBetslipLogoStyle
) {
    Box(modifier = modifier.background(style.backgroundColor)) {
        Icon(
            painter = painterResource(id = style.logoIcon),
            tint = style.iconColor,
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