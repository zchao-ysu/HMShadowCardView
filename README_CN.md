# HMShadowCardView

解决CardView无法调整颜色问题

## 示例

<img src="https://github.com/zchao-ysu/HMShadowCardView/blob/main/screenShot/example.png" width="300"/>

## 使用方法:

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

## 属性说明

| 名称                | 说明                                                            |
|:------------------|:--------------------------------------------------------------|
| hm_card_color     | 卡片背景色                                                         |
| hm_dx             | 卡片阴影在X轴上的偏离大小                                                 |
| hm_dy             | 卡片阴影在Y轴上的偏离大小                                                 |
| hm_shadowColor    | 卡片阴影颜色                                                        |
| hm_shadowEffect   | 卡片阴影扩散大小                                                      |
| hm_shadow_inset   | 卡片背景收缩大小                                                      |
| hm_card_drawable  | 卡片背景Drawable，如果不设置，那么会根据hm_card_color以及hm_card_corner创建圆角矩形背景 |
| hm_card_corner    | 卡片背景圆角                                                        |
| hm_card_corner_lt | 卡片背景左上圆角                                                      |
| hm_card_corner_rt | 卡片背景右上圆角                                                      |
| hm_card_corner_lb | 卡片背景左下圆角                                                      |
| hm_card_corner_rb | 卡片背景右下圆角                                                      |


