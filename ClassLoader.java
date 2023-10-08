package rus.aikamsoft.demotask.shtang;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ClassLoader {
    private Properties commandsConfig;
    String fileName;
    public ClassLoader(String fileName) throws IOException {
        commandsConfig = new Properties();
        this.fileName = fileName;
        commandsConfig.load(ClassLoader.class.getResourceAsStream(fileName));
    }

    public Object getClassInstance(String key) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!commandsConfig.containsKey(key)) {
            throw new ClassNotFoundException(Const.ERR_PROPERTIES_CLASS_NOT_FOUND +key);
        }
        return Class.forName(commandsConfig.getProperty(key)).getDeclaredConstructor().newInstance();
    }

    public String getClassName(String key) throws ClassNotFoundException {
        if (!commandsConfig.containsKey(key)) {
            throw new ClassNotFoundException(Const.ERR_PROPERTIES_CLASS_NOT_FOUND + key);
        }
        return commandsConfig.getProperty(key);

    }
}
