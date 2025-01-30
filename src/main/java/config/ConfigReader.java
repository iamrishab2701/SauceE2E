package config;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigReader {

    private static Map<String, Object> config;

    static {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config/environment.yaml")) {
            if (inputStream == null) {
                throw new RuntimeException("Configuration file not found: config/environment.yaml");
            }
            Yaml yaml = new Yaml();
            config = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file : " + e.getMessage());
        }
    }

    public static String getBrowser() {
        return config.get("browser").toString();
    }

    public static String getBaseUrl() {
        return config.get("baseUrl").toString();
    }

    public static String getUsername() {
        return ((Map<String, String>) config.get("credentials")).get("username");
    }

    public static String getPassword() {
        return ((Map<String, String>) config.get("credentials")).get("password");
    }
}
