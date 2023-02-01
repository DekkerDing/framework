package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;
import lombok.Data;

@Data
public class Form extends Property {

    /**
     * 规定服务器用哪种字符集处理表单数据
     * UTF-8 - Unicode 字符编码
     * ISO-8859-1 - 拉丁字母表的字符编码
     * gb2312 - 简体中文字符集
     */
    private String acceptCharset;

    /**
     *  规定当提交表单时向何处发送表单数据
     */
    private String action;

    /**
     *  规定用于发送 form-data 的 HTTP 方法
     */
    private String method;
}
