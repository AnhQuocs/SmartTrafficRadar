package com.example.smarttrafficradar.features.dashboard.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.smarttrafficradar.R
import com.example.smarttrafficradar.components.AppHeader
import com.example.smarttrafficradar.components.AppSubText
import com.example.smarttrafficradar.ui.dimens.AppShape
import com.example.smarttrafficradar.ui.dimens.AppSpacing
import com.example.smarttrafficradar.ui.dimens.Dimen
import com.example.smarttrafficradar.ui.theme.NeonGreen
import com.example.smarttrafficradar.utils.bold
import com.example.smarttrafficradar.utils.s16
import com.example.smarttrafficradar.utils.s20

@Composable
fun DashboardHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            AppHeader(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.s20.bold()
            )

            Spacer(modifier = Modifier.height(AppSpacing.S))

            AppSubText(
                text = stringResource(id = R.string.real_time_monitoring_active),
                style = MaterialTheme.typography.s16
            )
        }

        Box(
            modifier = Modifier
                .wrapContentWidth()
                .height(Dimen.HeightSmall)
                .clip(RoundedCornerShape(AppShape.ShapeXL))
                .border(
                    0.5.dp,
                    color = NeonGreen,
                    shape = RoundedCornerShape(AppShape.ShapeXL)
                )
                .background(color = NeonGreen.copy(alpha = 0.1f))
                .padding(Dimen.PaddingXSPlus),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = Dimen.PaddingXSPlus)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = null,
                        tint = NeonGreen,
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .blur(radius = 6.dp)
                            .alpha(0.6f)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = null,
                        tint = NeonGreen,
                        modifier = Modifier.size(10.dp)
                    )
                }

                Spacer(modifier = Modifier.width(AppSpacing.S))

                AppSubText(
                    text = "LIVE",
                    style = MaterialTheme.typography.s16.copy(
                        shadow = Shadow(
                            color = NeonGreen.copy(alpha = 0.6f),
                            blurRadius = 20f
                        )
                    ),
                    color = NeonGreen
                )
            }
        }
    }
}