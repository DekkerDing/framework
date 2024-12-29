package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;

//@Data
public class Img extends Property {

    /**
     *  规定浏览器是应该立即加载图像还是推迟加载屏幕外图像
     *  eager
     *  lazy
     */
    private String loading;
}
