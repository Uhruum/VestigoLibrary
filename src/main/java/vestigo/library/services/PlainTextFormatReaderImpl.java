package vestigo.library.services;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link FormatReader} as PlainText format reader.
 * Reads and parses string value as PlainText.
 * Rules applied when parsing for counting are:
 * <ul>
 *   <li>whole text is considered for counting both vowels and consonants</li>
 * </ul>
 */

class PlainTextFormatReaderImpl implements FormatReader {

    private final static Logger _logger = Logger.getLogger(PlainTextFormatReaderImpl.class);
    private final LetterCounter _vowelsLetterCounter;
    private final LetterCounter _consonantLetterCounter;

    public PlainTextFormatReaderImpl() {
        _vowelsLetterCounter = new VowelsLetterCounterImpl();
        _consonantLetterCounter = new ConsonantLetterCounterImpl();
    }
    /**
     * Implementation of {@link FormatReader} as PlainText format reader.
     * Reads and parses string value as PlainText.
     * Rules applied when parsing for counting are:
     * <ul>
     *   <li>whole text is considered for counting both vowels and consonants</li>
     * </ul>
     * @param value Source for counting vowels and consonants
     * @return {@link LetterCounterReadDto}
     */
    public LetterCounterReadDto readFormat(String value) throws FormatReaderException {
        try {
            long consonantCount = _consonantLetterCounter.countLetters(value);
            long vowelsCount = _vowelsLetterCounter.countLetters(value);

            return new LetterCounterReadDto(vowelsCount,consonantCount);

        } catch (Exception e) {
            _logger.error(e.getMessage(), e);
            throw new FormatReaderException("Error occurred when PlainTextFormatReaderImpl was invoked, error parsing document!", e);
        }
    }
}
