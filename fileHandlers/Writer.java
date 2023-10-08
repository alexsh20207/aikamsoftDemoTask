package rus.aikamsoft.demotask.shtang.fileHandlers;

import rus.aikamsoft.demotask.shtang.Const;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }
    public void createFile() {
        try {
            File file = new File(fileName);
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        try {
            FileOutputStream writer = new FileOutputStream(fileName);
            writer.write((Const.EMPTY_STRING).getBytes());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String text) {
        createFile();
        clearFile();
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
