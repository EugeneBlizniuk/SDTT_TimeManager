package by.bsuir.manager.dao.db;

import java.util.Properties;

public class DataBase {
    private Properties properties = new Properties();
    private String url = "jdbc:postgresql://localhost:5432/java_ee_db";

    {
        properties.put("user", "postgres");
        properties.put("password", "09102014Qm");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "true");
    }


}
