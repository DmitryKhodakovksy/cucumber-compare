/*
 * Copyright 2002 - 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package w3schools.stepsDef;

import com.epam.cucumber.compare.qa.common.gui.enums.CustomersTable;
import com.epam.cucumber.compare.qa.common.gui.model.Customers;
import cucumber.api.java.en.Then;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class AssertionStepsDef extends AbstractStepsDef {

    @Then("^I should see table with columns$")
    public void iShouldSeeTableWithColumns(List<String> expectedColumnNames) {
        List<String> actualColumnNames = homePage.getColumnNames();
        assertThat("Table columns does not matched", actualColumnNames, equalTo(expectedColumnNames));
    }

    @Then("^I should see values in column '([^\"]+)'$")
    public void iShouldSeeValuesInColumn(CustomersTable columnName, List<String> expectedColumnValues) {
        List<String> actualColumnValues = homePage.getColumnValues(columnName.getName());
        assertThat("Table column values does not matched", actualColumnValues, equalTo(expectedColumnValues));
    }

    @Then("^I have (\\d+) records? in customers table$")
    public void iHaveRecordsInCustomersTable(int numberOfRecords) {
        assertThat("Number of records in table does not match",
                numberOfRecords, equalTo(homePage.getRowCount()));
    }

    @Then("^I should see table with parameters$")
    public void iShouldSeeTableWithParameters(List<Customers> expectedCustomers) {
        List<Customers> actualCustomers = homePage.getCustomers();
        assertThat("Customer list does not matched", actualCustomers,
                equalTo(expectedCustomers));
    }

    @Then("^table should contain records with values$")
    public void tableShouldContainRecordsWithValues(List<Map<String, String>> expectedValues) {
        Map<CustomersTable, List<String>> expected = expectedValues.stream()
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(entry -> CustomersTable.fromName(entry.getKey()),
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        for (CustomersTable key : expected.keySet()) {
            assertThat("Table does not contain expected records",
                    homePage.getColumnValues(key.getName()), hasItems(expected.get(key).toArray(new String[expected.get(key).size()])));
        }
    }
}
