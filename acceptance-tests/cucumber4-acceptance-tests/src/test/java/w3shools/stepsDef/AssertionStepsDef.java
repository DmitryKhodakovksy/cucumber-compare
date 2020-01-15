package w3shools.stepsDef;

import com.epam.cucumber.compare.qa.common.gui.enums.CustomersTable;
import com.epam.cucumber.compare.qa.common.gui.model.Customers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class AssertionStepsDef extends AbstractStepsDef {

    @Then("I should see table with columns")
    public void iShouldSeeTableWithColumns(List<String> expectedColumnNames) {
        List<String> actualNames = homePage.getColumnNames();

        assertThat("Column names are not equal",
                actualNames,
                equalTo(expectedColumnNames));
    }

    @Then("I should see values in column '{}'")
    public void iShouldSeeValuesInColumnCountry(CustomersTable columnName, List<String> expectedValues) {
        List<String> actualValues = homePage.getColumnValues(columnName.getName());

        assertThat("Column values are not equal",
                actualValues,
                equalTo(expectedValues));
    }

    @Then("I have {int} record(s) in customers table")
    public void iHaveRecordsInCustomersTable(int expectedCount) {
        int actualCount = homePage.getRowCount();

        assertThat("Count of rows in the table is not as expected",
                actualCount,
                equalTo(expectedCount));
    }

    @And("I should see table with parameters")
    public void iShouldSeeTableWithParameters(List<Customers> expectedCustomers) {
        List<Customers> actualCustomers = homePage.getCustomers();

        assertThat("Records are not as expected",
                compare(actualCustomers, expectedCustomers));
    }

    @Then("table should contain records with values")
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

    private static boolean compare(List<?> l1, List<?> l2) {
        ArrayList<?> cp = new ArrayList<>(l1);
        for (Object o : l2) {
            if (!cp.remove(o)) {
                return false;
            }
        }
        return cp.isEmpty();
    }

    @Then("I should see {string} header")
    public void iShouldSeeHeader(String expectedHeader) {
        assertThat("Header is not as expected",
                driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText(),
                equalTo(expectedHeader));
    }
}
