package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;
import lombok.Data;

@Data
public class Audio extends Property {

    /**
     * 如果出现该属性，则音频在就绪后马上播放
     *  0 = 就绪后马上播放
     *  1 = 不马上播放
     */
    private Byte autoplay;

    /**
     * 如果出现该属性，则向用户显示控件，比如播放按钮
     * 0 = 显示控件
     * 1 = 不显示控件
     */
    private Byte controls;


    /**
     *  如果出现该属性，则每当音频结束时重新开始播放
     *  0 = 重复播放
     *  1 = 不重复播放
     */
    private Byte loop;

    /**
     *  如果出现该属性，则音频在页面加载时进行加载，并预备播放。
     *  如果使用 "autoplay"，则忽略该属性
     *  0 = 进行加载
     *  1 = 不进行加载
     *
     */
    private Byte preload;

}
