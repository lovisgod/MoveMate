package com.lovisgod.movemate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Downloading: ImageVector
	get() {
		if (_Downloading != null) {
			return _Downloading!!
		}
		_Downloading = ImageVector.Builder(
            name = "Downloading",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
			path(
    			fill = SolidColor(Color.Black),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.NonZero
			) {
				moveTo(439f, 878f)
				quadToRelative(-76f, -8f, -141.5f, -42.5f)
				reflectiveQuadToRelative(-113.5f, -88f)
				reflectiveQuadTo(108.5f, 625f)
				reflectiveQuadTo(81f, 479f)
				quadToRelative(0f, -155f, 102.5f, -268.5f)
				reflectiveQuadTo(440f, 80f)
				verticalLineToRelative(80f)
				quadToRelative(-121f, 17f, -200f, 107.5f)
				reflectiveQuadTo(161f, 479f)
				reflectiveQuadToRelative(79f, 211.5f)
				reflectiveQuadTo(439f, 798f)
				close()
				moveToRelative(40f, -198f)
				lineTo(278f, 478f)
				lineToRelative(57f, -57f)
				lineToRelative(104f, 104f)
				verticalLineToRelative(-245f)
				horizontalLineToRelative(80f)
				verticalLineToRelative(245f)
				lineToRelative(103f, -103f)
				lineToRelative(57f, 58f)
				close()
				moveToRelative(40f, 198f)
				verticalLineToRelative(-80f)
				quadToRelative(43f, -6f, 82.5f, -23f)
				reflectiveQuadToRelative(73.5f, -43f)
				lineToRelative(58f, 58f)
				quadToRelative(-47f, 37f, -101f, 59.5f)
				reflectiveQuadTo(519f, 878f)
				moveToRelative(158f, -652f)
				quadToRelative(-35f, -26f, -74.5f, -43f)
				reflectiveQuadTo(520f, 160f)
				verticalLineToRelative(-80f)
				quadToRelative(59f, 6f, 113f, 28.5f)
				reflectiveQuadTo(733f, 168f)
				close()
				moveToRelative(112f, 506f)
				lineToRelative(-56f, -57f)
				quadToRelative(26f, -34f, 42f, -73.5f)
				reflectiveQuadToRelative(22f, -82.5f)
				horizontalLineToRelative(82f)
				quadToRelative(-8f, 59f, -30f, 113.5f)
				reflectiveQuadTo(789f, 732f)
				moveToRelative(8f, -293f)
				quadToRelative(-6f, -43f, -22f, -82.5f)
				reflectiveQuadTo(733f, 283f)
				lineToRelative(56f, -57f)
				quadToRelative(38f, 45f, 61f, 99.5f)
				reflectiveQuadTo(879f, 439f)
				close()
			}
		}.build()
		return _Downloading!!
	}

private var _Downloading: ImageVector? = null
