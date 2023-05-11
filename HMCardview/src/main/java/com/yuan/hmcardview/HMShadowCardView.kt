package com.yuan.hmcardview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.PaintDrawable
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.DrawableRes

/**
 * @author zc
 * @desc 专门用于绘制阴影的一个容器
 * 解决CardView无法调整颜色问题
 * 解决市面常见实现方案无法满足异形背景的要求
 * 使用方法：
 *     <com.yuan.hmcardview.HMShadowCardView
 *          android:layout_width="wrap_content"
 *          android:layout_height="wrap_content"
 *          android:padding="20dp"
 *          app:hm_card_color="#FF9800"
 *          app:hm_card_corner="30dp"
 *          app:hm_dx="3dp"
 *          app:hm_dy="5dp"
 *          app:hm_shadowColor="#80000000"
 *          app:hm_shadowEffect="10dp"
 *          app:hm_shadow_inset="3dp">
 *
 *          <TextView
 *          android:layout_width="200dp"
 *          android:layout_height="50dp"
 *          android:gravity="center"
 *          android:text="Button"
 *          android:textColor="#fff"
 *          android:textSize="17dp"
 *          android:textStyle="bold" />
 *     </com.yuan.hmcardview.HMShadowCardView>
 * @see HMShadowCardView
 * 注意一点，这儿为了解决阴影边界对齐问题，如果不对HMShadowCardView设置padding，
 * 并且HMShadowCardView的父布局没有设置 android:clipChildren="false"那么是看不到阴影的
 *
 * @time 2023/3/24 16:00
 **/
class HMShadowCardView : FrameLayout {

    private val mShadowDrawable by lazy {
        ShadowDrawable().apply {
            callback = object : Drawable.Callback {
                override fun invalidateDrawable(who: Drawable) {
                    this@HMShadowCardView.invalidate()
                }

                override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {

                }

                override fun unscheduleDrawable(who: Drawable, what: Runnable) {

                }
            }
        }
    }

    private var mCardBackground: Drawable? = null
    private var mSolidColor = Color.WHITE

    fun shadowStyleConfig(block: ShadowDrawable.() -> Unit) {
        mShadowDrawable?.apply { block.invoke(this) }
        invalidate()
    }

    fun setCardBackground(@DrawableRes drawableRes: Int) {
        mCardBackground = context.resources.getDrawable(drawableRes)
    }


    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        initView(context, attrs)
    }

    override fun getSuggestedMinimumWidth(): Int {
        return 0
    }

    override fun getSuggestedMinimumHeight(): Int {
        return 0
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        mShadowDrawable.state = drawableState
        mCardBackground?.state = drawableState
    }

    override fun dispatchDraw(canvas: Canvas) {
        mShadowDrawable.setBounds(
            paddingLeft,
            paddingTop,
            width - paddingRight,
            height - paddingBottom
        )
        mShadowDrawable.draw(canvas)
        mCardBackground?.setBounds(
            paddingLeft,
            paddingTop,
            width - paddingRight,
            height - paddingBottom
        )
        mCardBackground?.draw(canvas)
        super.dispatchDraw(canvas)
    }


    private fun initView(context: Context, attrs: AttributeSet?) {
        initAttributes(context, attrs)
    }

    val mShapeCorner = FloatArray(8)
    private fun initAttributes(context: Context, attrs: AttributeSet?) {
        val attr = getTypedArray(context, attrs, R.styleable.HMShadowCardView)
        try {
            mCardBackground =
                attr.getDrawable(R.styleable.HMShadowCardView_hm_card_drawable)
            val mShadowEffect =
                attr.getDimension(R.styleable.HMShadowCardView_hm_shadowEffect, 0f)
            val mOffsetX = attr.getDimensionPixelSize(R.styleable.HMShadowCardView_hm_dx, 0)
            val mOffsetY = attr.getDimensionPixelSize(R.styleable.HMShadowCardView_hm_dy, 0)

            val mCorners =
                attr.getDimension(R.styleable.HMShadowCardView_hm_card_corner, 0f)
            mShapeCorner[0] =
                attr.getDimension(R.styleable.HMShadowCardView_hm_card_corner_lt, mCorners)
            mShapeCorner[1] = mShapeCorner[0]
            mShapeCorner[2] =
                attr.getDimension(R.styleable.HMShadowCardView_hm_card_corner_rt, mCorners)
            mShapeCorner[3] = mShapeCorner[2]
            mShapeCorner[4] =
                attr.getDimension(R.styleable.HMShadowCardView_hm_card_corner_rb, mCorners)
            mShapeCorner[5] = mShapeCorner[4]
            mShapeCorner[6] =
                attr.getDimension(R.styleable.HMShadowCardView_hm_card_corner_lb, mCorners)
            mShapeCorner[7] = mShapeCorner[6]
            val inset =
                attr.getDimensionPixelSize(R.styleable.HMShadowCardView_hm_shadow_inset, 0)
            mSolidColor = attr.getColor(
                R.styleable.HMShadowCardView_hm_card_color, Color.WHITE
            )
            val mShadowColor = attr.getColor(
                R.styleable.HMShadowCardView_hm_shadowColor,
                resources.getColor(R.color.default_shadow_color)
            )

            mShadowDrawable.mShadowColor = mShadowColor
            mShadowDrawable.mShadowEffect = mShadowEffect
            mShadowDrawable.mOffsetX = mOffsetX
            mShadowDrawable.mOffsetY = mOffsetY
            mShadowDrawable.setCornerRadii(mShapeCorner)
            mShadowDrawable.mShadowInset = inset
            if (mCardBackground == null) {
                mCardBackground = selfCreateBg()
            }
        } finally {
            attr.recycle()
        }
    }

    private fun selfCreateBg(): PaintDrawable {
        return PaintDrawable(mSolidColor).apply {
            setCornerRadii(mShapeCorner)
        }
    }

    private fun getTypedArray(
        context: Context, attributeSet: AttributeSet?, attr: IntArray
    ): TypedArray {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0)
    }
}