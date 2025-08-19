package com.example.offlinefacedetect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.google.mlkit.vision.face.Face
import kotlin.math.max
import kotlin.math.min

class FaceOverlay(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private var faces: List<Face> = emptyList()
    private var imageWidth: Int = 0
    private var imageHeight: Int = 0
    private var rotationDegrees: Int = 0

    private val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    fun setFaces(faces: List<Face>, imgWidth: Int, imgHeight: Int, rotation: Int) {
        this.faces = faces
        this.imageWidth = imgWidth
        this.imageHeight = imgHeight
        this.rotationDegrees = rotation
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (imageWidth == 0 || imageHeight == 0) return

        val scaleX = width.toFloat() / imageWidth
        val scaleY = height.toFloat() / imageHeight
        val scale = min(scaleX, scaleY)

        for (face in faces) {
            val bounds = face.boundingBox

            val left = bounds.left * scale
            val top = bounds.top * scale
            val right = bounds.right * scale
            val bottom = bounds.bottom * scale

            canvas.drawRect(left, top, right, bottom, paint)
        }
    }
}

