package rus.aikamsoft.demotask.shtang;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import rus.aikamsoft.demotask.shtang.db.DBHandler;
import rus.aikamsoft.demotask.shtang.fileHandlers.Reader;
import rus.aikamsoft.demotask.shtang.fileHandlers.Writer;
import rus.aikamsoft.demotask.shtang.operations.Operation;
import rus.aikamsoft.demotask.shtang.outputs.OutputErr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

public class HandlerOperation {
    private String command;
    private String inputFileName;
    private String outputFileName;
    private ClassLoader classLoader;
    private String output;
    private Operation operation;
    private JsonElement json;
    private Writer writer;

    public HandlerOperation(String args[]) {
        this.command = args[0];
        this.inputFileName = args[1];
        this.outputFileName = args[2];
        writer = new Writer(outputFileName);
    }
    public void handle() {
        try {
            classLoader = new ClassLoader(Const.OPERATIONS_PROPERTIES_FILEPATH);
            operation = (Operation) classLoader.getClassInstance(command);
            json = new Reader(inputFileName).read();
            DBHandler.connect();
            output = operation.execute(json);
            DBHandler.close();
            writer.write(output);
        } catch (ClassNotFoundException | ParseException | SQLException
                 | IOException | InvocationTargetException | NoSuchMethodException
                 | InstantiationException | IllegalAccessException | NullPointerException
                 | JsonSyntaxException e) {
            handleErr(e);
        }
    }

    public void handleErr(Exception e) {
        writer.write(new Gson().toJson(new OutputErr(e.toString())));
    }
}
