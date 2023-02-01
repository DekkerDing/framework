package io.github.DekkerDing.beans.model.render.html.property.general;

import lombok.Data;

import java.io.Serializable;

@Data
public class Property implements Serializable {

    /**
     *  用来给标签取一个唯一的名称
     */
    private String id;

    /**
     * 用来给标签取一个类名
     */
    private String classProperty;

    /**
     *  当鼠标移动到该标签，显示的提示内容
     */
    private String title;

    /**
     * 设置标签的行内样式
     */
    private String style;

    /**
     *  规定元素内容是否可编辑。
     *  true = 0 可编辑
     *  false = 1 不可编辑
     */
    private Byte contenteditable;

    /**
     *  规定元素中内容的文本方向。
     *  ltr 默认。从左向右的文本方向
     *  rtl 从右向左的文本方向。
     */
    private String dir;

    /**
     *  规定元素是否可拖动
     *  true = 0 可拖动
     *  false = 1 不可拖动
     */
    private Byte draggable;

    /**
     *  规定元素是否被隐藏
     *  true = 0 被隐藏
     *  false = 1 不被隐藏
     */
    private Byte hidden;

    /**
     *  链接属性
     *  如果不使用 href 属性，则不可以使用如下属性：download, hreflang, media, rel, target 以及 type 属性如果不使用 href 属性，则不可以使用如下属性：download, hreflang, media, rel, target 以及 type 属性
     */
    private String href;

    /**
     *  资源路径 URL
     */
    private String src;

    /**
     *  标签名称
     */
    private String name;

    /**
     *  标签控件初始值
     */
    private String value;

    /**
     *  标签控件宽度
     */
    private String width;

    /**
     *  标签控件高度
     */
    private String height;

    /**
     *  文本描述
     */
    private String alt;

    /**
     *  标签控件属性的类型
     *  button
     *  reset
     *  submit
     */
    private String type;

    /**
     *  校验 盐 值
     */
    private String salt;
}
