package com.fox.commonview.custom

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fox.commonview.custom.view.ColorTrackTextView
import com.fox.commonview.R
import kotlinx.android.synthetic.main.view_activity_test.*

class SimpleViewTestActivity : AppCompatActivity() {

    @Volatile
    var changeShape = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_test)
        step_view.stepMax = 4000
        val animator = ObjectAnimator.ofInt(0, 3000)
        animator.duration = 1000
        animator.addUpdateListener {
            step_view.currentStep = it.animatedValue as Int
        }
        animator.start()
    }

    fun leftToRight(view: View) {
        sideToSide(ColorTrackTextView.Direction.LEFT_TO_RIGHT)
    }

    fun rightToLeft(view: View) {
        sideToSide(ColorTrackTextView.Direction.RIGHT_TO_LEFT)
    }

    private fun sideToSide(direction: ColorTrackTextView.Direction) {
        colorTrackTextView.direction = direction
        val animator = ObjectAnimator.ofFloat(0f, 1f)
        animator.duration = 2000
        animator.addUpdateListener {
            colorTrackTextView.currentProgress = it.animatedValue as Float
        }
        animator.start()
    }

    fun exchange(view: View) {
        Thread {
            while (changeShape) {
                runOnUiThread {
                    shape_view.exchange()
                }
                Thread.sleep(1000)
            }
        }.start()
    }

    fun stopExchange(view: View) {
        changeShape = false
    }
}
