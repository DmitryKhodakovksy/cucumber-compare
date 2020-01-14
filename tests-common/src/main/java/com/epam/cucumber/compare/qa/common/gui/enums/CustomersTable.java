package com.epam.cucumber.compare.qa.common.gui.enums;

public enum CustomersTable {

    COMPANY(1, "Company"),
    CONTACT(2, "Contact"),
    COUNTRY(3, "Country");

    private int index;
    private String name;

    CustomersTable(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static CustomersTable fromName(String name) {

        for (CustomersTable column : values()) {
            if (name.equals(column.getName())) {
                return column;
            }
        }
        throw new RuntimeException("Column was not found.");
    }
}
