package vestigo.library.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class JsonFormatReaderTests {

    private final FormatReader _jsonFormatReader;

    public JsonFormatReaderTests() {
        _jsonFormatReader = new JsonFormatReaderImpl();
    }

    @Test
    void givenJsonWhenJsonFormatReaderReadFormatInvokedThenResultIsNotNull() throws FormatReaderException {
        String json= "{\"employees\": {\"employee\": [{\"id\": \"1\",\"firstName\": \"Tom\",\"lastName\": \"Cruise\" }]}}";
        LetterCounterReadDto format = _jsonFormatReader.readFormat(json);
        assertNotNull(format);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Director:name: Spielberg\\r\\n  Movies:\\r\\n    - Movie:\\r\\n        title: E.T.\\r\\n        year: 1975\\r\\n    - Movie:\\r\\n        title: Jaws\\r\\n        year: 1982",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "  ",
            ".",
            ",",
            " ",
            "1258247851477",
            "Director:\r\n  name: Spielberg\r\n  Movies:\r\n    - Movie:\r\n        title: E.T.\r\n        year: 1975\r\n    - Movie:\r\n        title: Jaws\r\n        year: 1982",
            "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><employees><employee><id>1</id><firstName>Tom</firstName><lastName>Cruise</lastName><photo>https://jsonformatter.org/img/tom-cruise.jpg</photo></employee><employee><id>2</id><firstName>Maria</firstName><lastName>Sharapova</lastName><photo>https://jsonformatter.org/img/Maria-Sharapova.jpg</photo></employee><employee><id>3</id><firstName>Robert</firstName><lastName>Downey Jr.</lastName><photo>https://jsonformatter.org/img/Robert-Downey-Jr.jpg</photo></employee></employees>",
    })
    void givenInvalidJsonStringWhenJsonFormatReaderReadFormatInvokedThenThrewFormatReaderException(String value) {
        assertThrows(FormatReaderException.class,() -> _jsonFormatReader.readFormat(value));
    }

    @Test
    void givenJsonStringStringWhenJsonFormatReaderReadFormatInvokedThenVowelCountConsonantCountIsCorrect() throws FormatReaderException{
        String json= "{\"employees\": {\"employee\": [{\"id\": \"1\",\"firstName\": \"Tom\",\"lastName\": \"Cruise\" }]}}";
        LetterCounterReadDto format = _jsonFormatReader.readFormat(json);
        assertEquals(4, format.getVowelCount());
        assertEquals(26, format.getConsonantCount());
    }

}
