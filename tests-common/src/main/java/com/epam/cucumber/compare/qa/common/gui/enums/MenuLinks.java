package com.epam.cucumber.compare.qa.common.gui.enums;

public enum MenuLinks {

    BASIC("Basic"),
    ELEMENTS("Elements"),
    ATTRIBUTES("Attributes");

    private String name;

    MenuLinks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MenuLinks fromName(String name) {

        for (MenuLinks link : values()) {
            if (name.equals(link.getName())) {
                return link;
            }

        }
        throw new RuntimeException("Link was not found.");
    }
}
