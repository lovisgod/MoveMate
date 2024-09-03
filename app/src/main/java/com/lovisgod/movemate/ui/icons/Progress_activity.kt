package com.lovisgod.movemate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Progress_activity: ImageVector
	get() {
		if (_Progress_activity != null) {
			return _Progress_activity!!
		}
		_Progress_activity = ImageVector.Builder(
            name = "Progress_activity",
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
				moveTo(480f, 880f)
				quadToRelative(-82f, 0f, -155f, -31.5f)
				reflectiveQuadToRelative(-127.5f, -86f)
				reflectiveQuadToRelative(-86f, -127.5f)
				reflectiveQuadTo(80f, 480f)
				quadToRelative(0f, -83f, 31.5f, -155.5f)
				reflectiveQuadToRelative(86f, -127f)
				reflectiveQuadToRelative(127.5f, -86f)
				reflectiveQuadTo(480f, 80f)
				quadToRelative(17f, 0f, 28.5f, 11.5f)
				reflectiveQuadTo(520f, 120f)
				reflectiveQuadToRelative(-11.5f, 28.5f)
				reflectiveQuadTo(480f, 160f)
				quadToRelative(-133f, 0f, -226.5f, 93.5f)
				reflectiveQuadTo(160f, 480f)
				reflectiveQuadToRelative(93.5f, 226.5f)
				reflectiveQuadTo(480f, 800f)
				reflectiveQuadToRelative(226.5f, -93.5f)
				reflectiveQuadTo(800f, 480f)
				quadToRelative(0f, -17f, 11.5f, -28.5f)
				reflectiveQuadTo(840f, 440f)
				reflectiveQuadToRelative(28.5f, 11.5f)
				reflectiveQuadTo(880f, 480f)
				quadToRelative(0f, 82f, -31.5f, 155f)
				reflectiveQuadToRelative(-86f, 127.5f)
				reflectiveQuadToRelative(-127f, 86f)
				reflectiveQuadTo(480f, 880f)
			}
		}.build()
		return _Progress_activity!!
	}

private var _Progress_activity: ImageVector? = null
