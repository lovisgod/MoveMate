package com.lovisgod.movemate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Package_2: ImageVector
	get() {
		if (_Package_2 != null) {
			return _Package_2!!
		}
		_Package_2 = ImageVector.Builder(
            name = "Package_2",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
			path(
    			fill = SolidColor(Color.Gray),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.NonZero
			) {
				moveTo(440f, 777f)
				verticalLineToRelative(-274f)
				lineTo(200f, 364f)
				verticalLineToRelative(274f)
				close()
				moveToRelative(80f, 0f)
				lineToRelative(240f, -139f)
				verticalLineToRelative(-274f)
				lineTo(520f, 503f)
				close()
				moveToRelative(-80f, 92f)
				lineTo(160f, 708f)
				quadToRelative(-19f, -11f, -29.5f, -29f)
				reflectiveQuadTo(120f, 639f)
				verticalLineToRelative(-318f)
				quadToRelative(0f, -22f, 10.5f, -40f)
				reflectiveQuadToRelative(29.5f, -29f)
				lineToRelative(280f, -161f)
				quadToRelative(19f, -11f, 40f, -11f)
				reflectiveQuadToRelative(40f, 11f)
				lineToRelative(280f, 161f)
				quadToRelative(19f, 11f, 29.5f, 29f)
				reflectiveQuadToRelative(10.5f, 40f)
				verticalLineToRelative(318f)
				quadToRelative(0f, 22f, -10.5f, 40f)
				reflectiveQuadTo(800f, 708f)
				lineTo(520f, 869f)
				quadToRelative(-19f, 11f, -40f, 11f)
				reflectiveQuadToRelative(-40f, -11f)
				moveToRelative(200f, -528f)
				lineToRelative(77f, -44f)
				lineToRelative(-237f, -137f)
				lineToRelative(-78f, 45f)
				close()
				moveToRelative(-160f, 93f)
				lineToRelative(78f, -45f)
				lineToRelative(-237f, -137f)
				lineToRelative(-78f, 45f)
				close()
			}
		}.build()
		return _Package_2!!
	}

private var _Package_2: ImageVector? = null
