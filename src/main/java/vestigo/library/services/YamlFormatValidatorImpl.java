package vestigo.library.services;

import org.yaml.snakeyaml.Yaml;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Implementation of {@link FormatValidator} as Yaml format validator.
 * Validates input string with {@link Yaml}.
 */
class YamlFormatValidatorImpl implements FormatValidator {

    /**
     * Implementation of {@link FormatValidator} as Yaml format validator.
     * Validates input string with {@link Yaml}.
     */
    public boolean isValid(String value) {
        try {
            InputStream targetStream = new ByteArrayInputStream(value.getBytes());
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(targetStream);
            return !data.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
