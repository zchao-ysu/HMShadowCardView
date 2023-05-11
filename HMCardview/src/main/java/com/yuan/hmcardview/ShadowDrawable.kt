package com.yuan.hmcardview

import android.graphics.BlurMaskFilter
import android.graphics.Rect
import android.graphics.drawable.PaintDrawable

class ShadowDrawable() : PaintDrawable() {
    var mShadowEffect: Float = 0f
        set(value) {
            if (field != value) {
                field = value
                paint.maskFilter = BlurMaskFilter(field, BlurMaskFilter.Blur.NORMAL)
            }
        }
    var mShadowColor: Int = 0x28000000
        set(value) {
            if (field != value) {
                field = value
                paint.setColor(field)
            }
        }

    /**
     * shadow offset with card background on x
     */
    var mOffsetX = 0


    /**
     * shadow offset with card background on y
     */
    var mOffsetY = 0

    /**
     * shadow inset with card background, unit is px
     */
    var mShadowInset = 0

    override fun onBoundsChange(bounds: Rect) {
        bounds.inset(mShadowInset, mShadowInset)
        bounds.offset(mOffsetX, mOffsetY)
        super.onBoundsChange(bounds)
    }


}