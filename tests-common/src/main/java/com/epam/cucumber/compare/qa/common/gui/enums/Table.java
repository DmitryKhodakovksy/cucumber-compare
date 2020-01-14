package com.epam.cucumber.compare.qa.common.gui.enums;

public enum Table {

    COMPANY(0, "Company"),
    CONTACT(1, "Contact"),
    COUNTRY(2, "Country");

    private int index;
    private String name;

    Table(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Table fromName(String name) {

        for (Table column : values()) {
            if (name.equals(column.getName())) {
                return column;
            }
        }
        throw new RuntimeException("Column was not found.");
    }
}
