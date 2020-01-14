package com.epam.cucumber.compare.qa.common.gui.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customers {
    private String company;
    private String contact;
    private String country;
}
