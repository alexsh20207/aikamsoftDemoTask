package rus.aikamsoft.demotask.shtang.inputs;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import rus.aikamsoft.demotask.shtang.ClassLoader;
import rus.aikamsoft.demotask.shtang.Const;
import rus.aikamsoft.demotask.shtang.criterias.Criteria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputSearch {
    private List<Criteria> criterias;

    public InputSearch() {
        criterias = new ArrayList<>();
    }

    public void loadCriterias(JsonElement jsonInput) throws ClassNotFoundException, IOException, NullPointerException {
        ClassLoader classLoader = new ClassLoader(Const.CRITERIAS_PROPERTIES_FILEPATH);
        JsonArray jsonArray = jsonInput.getAsJsonObject().get(Const.CRITERIAS_KEYNAME).getAsJsonArray();
        for (JsonElement jsonElement: jsonArray) {
            String className = classLoader.getClassName(jsonElement.getAsJsonObject().keySet().toString());
            Criteria criteria = (Criteria) new Gson().fromJson(
                    jsonElement.toString(),
                    Class.forName(className));
            criterias.add(criteria);
        }
    }

    public List<Criteria> getCriterias() {
        return criterias;
    }
}
