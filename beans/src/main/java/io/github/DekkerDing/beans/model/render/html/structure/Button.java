package io.github.DekkerDing.beans.model.render.html.structure;

import io.github.DekkerDing.beans.model.render.html.property.general.Property;
import lombok.Data;

@Data
public class Button extends Property {

    /**
     * formaction 属性覆盖 form 元素的 action 属性。
     *
     */
    private String formaction;

}
