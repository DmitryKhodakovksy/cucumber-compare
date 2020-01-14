package com.epam.cucumber.compare.qa.common.gui.enums;

public enum Table {

    COMPANY(1, "Company"),
    CONTACT(2, "Contact"),
    COUNTRY(3, "Country");

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
