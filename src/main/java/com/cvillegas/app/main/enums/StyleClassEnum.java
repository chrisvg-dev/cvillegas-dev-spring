package com.cvillegas.app.main.enums;

import lombok.Getter;

@Getter
public enum StyleClassEnum {
    RED("card l-bg-cherry"), GREEN("card l-bg-green-dark"), BLUE("card l-bg-blue-dark"), ORANGE("card l-bg-orange-dark");

    private final String styleClass;

    StyleClassEnum(String styleClass) {
        this.styleClass = styleClass;
    }
}
