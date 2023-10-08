package rus.aikamsoft.demotask.shtang.operations;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import rus.aikamsoft.demotask.shtang.entities.Customer;
import rus.aikamsoft.demotask.shtang.db.DBHandler;
import rus.aikamsoft.demotask.shtang.criterias.Criteria;
import rus.aikamsoft.demotask.shtang.inputs.InputSearch;
import rus.aikamsoft.demotask.shtang.outputs.OutputSearch;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Searcher extends Operation {
    private InputSearch inputSearch;
    private OutputSearch outputSearch;

    public Searcher() {
        inputSearch = new InputSearch();
        outputSearch = new OutputSearch();
    }

    public String execute(JsonElement jsonElement) throws ClassNotFoundException, IOException, SQLException, NullPointerException {
        setJsonInput(jsonElement);
        inputSearch.loadCriterias(jsonInput);
        for (Criteria criterion: inputSearch.getCriterias()) {
            List<Customer> customers = DBHandler.getCustomers(criterion.getSQLQuery());
            outputSearch.add(criterion, customers);
        }
        return new Gson().toJson(outputSearch);
    }
}
