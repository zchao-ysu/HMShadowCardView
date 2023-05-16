# HMShadowCardView

Fix android CardView can't modify shadow color. 

## How to use:
``` java

<com.yuan.hmcardview.HMShadowCardView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:padding="20dp"
    app:hm_card_color="#FF9800"
    app:hm_card_corner="30dp"
    app:hm_dx="3dp"
    app:hm_dy="5dp"
    app:hm_shadowColor="#80000000"
    app:hm_shadowEffect="10dp"
    app:hm_shadow_inset="3dp">
    <TextView
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:gravity="center"
        android:text="Button"
        android:textColor="#fff"
        android:textSize="17dp"
        android:textStyle="bold" />
</com.yuan.hmcardview.HMShadowCardView>
```