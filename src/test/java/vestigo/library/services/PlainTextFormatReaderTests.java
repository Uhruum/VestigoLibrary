package vestigo.library.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlainTextFormatReaderTests {

    private final FormatReader _plainTextFormatReader;

    public PlainTextFormatReaderTests() {
        _plainTextFormatReader = new PlainTextFormatReaderImpl();
    }

    @Test
    void givenStringWhenPlainTextFormatReaderReadFormatInvokedThenResultIsNotNull() throws FormatReaderException {
        String xml= "Lorem ipsum dolor sit amet.";
        LetterCounterReadDto format = _plainTextFormatReader.readFormat(xml);
        assertNotNull(format);
    }

    @Test
    void givenStringStringPlainTextXmlFormatReaderReadFormatInvokedThenVowelCountConsonantCountIsCorrect() throws FormatReaderException{
        String xml= "Lorem ipsum dolor sit amet.";
        LetterCounterReadDto format = _plainTextFormatReader.readFormat(xml);
        assertEquals(9, format.getVowelCount());
        assertEquals(13, format.getConsonantCount());
    }
}
