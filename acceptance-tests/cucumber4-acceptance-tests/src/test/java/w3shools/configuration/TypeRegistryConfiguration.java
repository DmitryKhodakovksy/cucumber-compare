package w3shools.configuration;

import com.epam.cucumber.compare.qa.common.gui.enums.MenuLinks;
import com.epam.cucumber.compare.qa.common.gui.model.Customers;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;


public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Customers.class,
                (Map<String, String> entry) -> Customers.builder().company(entry.get("Company")).contact(entry.get("Contact")).country(entry.get("Country")).build()));

        registry.defineParameterType(new ParameterType<>(
                "link",           // name
                "Basic|Element|Attributes", // regexp
                MenuLinks.class,
                MenuLinks::fromName// type
        ));
    }
}
