package common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonActions {
        private static final Logger logger = LogManager.getLogger(CommonActions.class);
        public static String readConfig(String propName, String configName) {
            String value = null;
            Properties prop = new Properties();
            InputStream input = null;
            String configPath = null;

            if (configName.equals("user")) {
                configPath = "src/test/resources/properties/user.properties";
            } else {
                configPath = "src/test/resources/properties/general.properties";
            }

            try {
                input = Files.newInputStream(Paths.get(configPath));
                prop.load(input);

                value = prop.getProperty(propName);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return value;
        }
    }

