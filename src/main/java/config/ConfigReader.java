package config;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigReader {

    private static Map<String, Object> config;
    private static String environment;

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

        environment = System.getProperty("env", "staging");
    }

    private static Map<String, Object> getCurrentEnvConfig() {
        Map<String, Object> environments = (Map<String, Object>) config.get("environments");
        if (environments == null) {
            throw new RuntimeException("No 'environments' key found in environment.yaml");
        }

        Map<String, Object> currentEnv = (Map<String, Object>) environments.get(environment);
        if (currentEnv == null) {
            throw new RuntimeException("Environment '" + environment + "' not found in environment.yaml");
        }

        return currentEnv;
    }

    public static String getBrowser() {
        // Check if browser is provided via system property (Jenkins/Maven)
        String browserFromSystem = System.getProperty("browser");
    
        if (browserFromSystem != null && !browserFromSystem.isEmpty()) {
            return browserFromSystem.toLowerCase();  // Use system-provided browser
        }
    
        // ✅ Fetch browser from the selected environment (staging/integration/production)
        return getCurrentEnvConfig().get("browser").toString().toLowerCase();
    }    

    public static String getBaseUrl() {
        return getCurrentEnvConfig().get("baseUrl").toString();
    }

    public static String getUsername() {
        return ((Map<String, String>) getCurrentEnvConfig().get("credentials")).get("username");
    }

    public static String getPassword() {
        return ((Map<String, String>) getCurrentEnvConfig().get("credentials")).get("password");
    }
}
