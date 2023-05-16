# HMShadowCardView

Fix android CardView can't modify shadow color.

---

## [中文README](https://github.com/zchao-ysu/HMShadowCardView/blob/main/README_CN.md)

## Example

<img src="https://github.com/zchao-ysu/HMShadowCardView/blob/main/screenShot/example.png" width="300"/>

## How to use:

``` java
 api project(path: ':HMCardview')
```

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

## Attribute Description

| Attr name         | Description                                                                                                       |
|:------------------|:------------------------------------------------------------------------------------------------------------------|
| hm_card_color     | Card background, just valid when hm_card_drawable is null.                                                        |
| hm_dx             | The shadow offset on x axle.                                                                                      |
| hm_dy             | The shadow offset on y axle.                                                                                      |
| hm_shadowColor    | Card shadow color.                                                                                                |
| hm_shadowEffect   | Card shadow diffusion range.                                                                                      |
| hm_shadow_inset   | Card shadow inset size.                                                                                           |
| hm_card_drawable  | Card background, The view well create a rectangle background by hm_card_color and hm_card_corner when it is null. |
| hm_card_corner    | Card background corner.                                                                                           |
| hm_card_corner_lt | Card background corner of top-left.                                                                               |
| hm_card_corner_rt | Card background corner of top-right.                                                                              |
| hm_card_corner_lb | Card background corner of bottom-left.                                                                            |
| hm_card_corner_rb | Card background corner of bottom-right.                                                                           |