package vestigo.library.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;

import java.io.IOException;

/**
 * Implementation of {@link FormatValidator} as JSON format validator.
 * Validates input string with {@link Gson}.
 */
class JsonFormatValidatorImpl implements FormatValidator {
    /**
     * Implementation of {@link FormatValidator} as JSON format validator.
     * Validates input string with {@link Gson}.
     */
    public boolean isValid(String value) {
        TypeAdapter<JsonElement> strictAdapter = new Gson().getAdapter(JsonElement.class);
        try {
            JsonElement jsonElement = strictAdapter.fromJson(value);

            if (jsonElement.isJsonPrimitive())
                return false;

            return !jsonElement.isJsonNull();
        } catch (JsonSyntaxException | IOException e) {
            return false;
        }
    }
}
