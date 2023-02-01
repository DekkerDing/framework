package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;
import lombok.Data;

@Data
public class A extends Property {

    /**
     *  规定在何处打开链接文档
     *  _blank	在新窗口中打开被链接文档
     *  _self	默认。在相同的框架中打开被链接文档。
     * _parent	在父框架集中打开被链接文档。
     * _top	在整个窗口中打开被链接文档。
     * framename	在指定的框架中打开被链接文档
     */
    private String target;

}
