package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;
import lombok.Data;

@Data
public class Input extends Property {

    /**
     *  规定通过文件上传来提交的文件的类型
     */
    private String accept;

    /**
     * 规定输入字段在页面加载时是否获得焦点。
     *
     * （不适用于 type="hidden"）
     *  0 = 自动获得焦点
     *  1 = 不自动获得焦点
     */
    private Byte autofocus;

    /**
     *  规定此 input 元素首次加载时应当被选中
     *  0 = 自动被选中
     *  1 = 不自动被选中
     */
    private Byte checked;

    /**
     *  规定帮助用户填写输入字段的提示
     */
    private String placeholder;

    /**
     * 规定输入字段为只读
     *
     *  0 = 为只读
     *  1 = 不为只读
     */
    private Byte readonly;

    /**
     *  指示输入字段的值是必需的
     *  0 = 为必需的
     *  1 = 不必需的
     */
    private Byte required;
}
