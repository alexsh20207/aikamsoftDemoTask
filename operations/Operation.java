package rus.aikamsoft.demotask.shtang.operations;

import com.google.gson.JsonElement;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class Operation {
    protected JsonElement jsonInput;
    public abstract String execute(JsonElement jsonElement) throws ClassNotFoundException, ParseException, SQLException, IOException;
    public void setJsonInput(JsonElement jsonElement) {
        this.jsonInput = jsonElement;
    }
}
