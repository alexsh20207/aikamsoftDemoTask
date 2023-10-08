package rus.aikamsoft.demotask.shtang.fileHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class Reader {
    private final String fileName;
    public Reader(String fileName) {
        this.fileName = fileName;
    }
    public JsonElement read() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, JsonElement.class);
    }


}
