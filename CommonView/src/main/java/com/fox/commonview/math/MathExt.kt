package com.fox.commonview.math

import java.util.*
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * @Author fox
 * @Date 2020/4/4 17:45
 */

/**
 * 检查一个点（由currentX和currentY坐标表示）是否在一个以(centerX,centerY)为中心，半径为radius的圆内
 * @param centerX 圆心的X坐标
 * @param centerY 圆心的Y坐标
 * @param currentX 当前点的X坐标
 * @param currentY 当前点的Y坐标
 * @param radius 圆的半径
 */
fun checkInRound(
    centerX: Float,
    centerY: Float,
    currentX: Float,
    currentY: Float,
    radius: Float
): Boolean {
    return sqrt((currentX - centerX) * (currentX - centerX) + (currentY - centerY) * (currentY - centerY)) < radius
}

/**
 * 计算两点之间的距离
 * @param startX 起始点X坐标
 * @param startY 起始点Y坐标
 * @param endX 结束点X坐标
 * @param endY 结束点Y坐标
 */
fun distance(startX: Double, startY: Double, endX: Double, endY: Double): Double {
    return sqrt(abs(startX - endX) * abs(startX - endX) + abs(startY - endY) * abs(startY - endY))
}

var Int.random: Int
    get() = Random().nextInt(this)
    set(value) {}
