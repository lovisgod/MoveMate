package com.lovisgod.movemate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Scan: ImageVector
	get() {
		if (_Scan != null) {
			return _Scan!!
		}
		_Scan = ImageVector.Builder(
            name = "Scan",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
			path(
    			fill = SolidColor(Color.White),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.NonZero
			) {
				moveTo(240f, 880f)
				quadToRelative(-33f, 0f, -56.5f, -23.5f)
				reflectiveQuadTo(160f, 800f)
				verticalLineToRelative(-120f)
				horizontalLineToRelative(80f)
				verticalLineToRelative(120f)
				horizontalLineToRelative(480f)
				verticalLineToRelative(-120f)
				horizontalLineToRelative(80f)
				verticalLineToRelative(120f)
				quadToRelative(0f, 33f, -23.5f, 56.5f)
				reflectiveQuadTo(720f, 880f)
				close()
				moveToRelative(-80f, -440f)
				verticalLineToRelative(-280f)
				quadToRelative(0f, -33f, 23.5f, -56.5f)
				reflectiveQuadTo(240f, 80f)
				horizontalLineToRelative(320f)
				lineToRelative(240f, 240f)
				verticalLineToRelative(120f)
				horizontalLineToRelative(-80f)
				verticalLineToRelative(-80f)
				horizontalLineTo(520f)
				verticalLineToRelative(-200f)
				horizontalLineTo(240f)
				verticalLineToRelative(280f)
				close()
				moveTo(40f, 600f)
				verticalLineToRelative(-80f)
				horizontalLineToRelative(880f)
				verticalLineToRelative(80f)
				close()
				moveToRelative(440f, 80f)
			}
		}.build()
		return _Scan!!
	}

private var _Scan: ImageVector? = null
