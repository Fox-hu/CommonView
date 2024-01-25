package com.fox.commonview.custom.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 用于演示 各种Path.FillType的demo 3秒变化一次
 * @Author fox.hu
 * @Date 2020/12/10 13:51
 */
class PathFillTypeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val paint = Paint().apply { color = Color.RED }
    var fillType = Path.FillType.WINDING

    override fun onFinishInflate() {
        super.onFinishInflate()
        periodTask()
    }

    private fun periodTask() {
        postDelayed(changeFillType, 3000)
    }

    private val changeFillType = {
        Path.FillType.values().forEach {
            fillType = it
            invalidate()
        }
        periodTask()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(Color.LTGRAY)
//        drawPath(canvas, Path.FillType.WINDING, 50f, 50f)
//        drawPath(canvas, Path.FillType.INVERSE_WINDING, 50f, 300f)
//        drawPath(canvas, Path.FillType.EVEN_ODD, 450f, 50f)
//        drawPath(canvas, Path.FillType.INVERSE_EVEN_ODD, 450f, 300f)
        drawPath(canvas, fillType, 50f, 50f)
    }

    private fun drawPath(canvas: Canvas?, type: Path.FillType, left: Float, top: Float) {
        canvas?.drawPath(Path().apply {
            //添加矩形
            addRect(left, top, left + 150f, top + 150f, Path.Direction.CW)
            //添加圆形
            addCircle(left + 150f, top + 150f, 100f, Path.Direction.CW)
            fillType = type
        }, paint)
    }
}