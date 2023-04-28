package vestigo.library.services;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of {@link FormatReader} as YAML format reader.
 * Reads and parses string value as YAML.
 * Rules applied when parsing for counting are:
 * <ul>
 *    <li>for counting consonants whole text is taken</li>
 *    <li>for counting vowels only values of properties are taken in consideration</li>
 * </ul>
 */

class YamlFormatReaderImpl implements FormatReader {

    private final static Logger _logger = Logger.getLogger(YamlFormatReaderImpl.class);
    private final LetterCounter _vowelsLetterCounter;
    private final LetterCounter _consonantLetterCounter;
    private final StringConcatenation _stringConcatenation;

    public YamlFormatReaderImpl() {
        _vowelsLetterCounter = new VowelsLetterCounterImpl();
        _consonantLetterCounter = new ConsonantLetterCounterImpl();
        _stringConcatenation = new StringConcatenationImpl();
    }
    /**
     * Implementation of {@link FormatReader} as YAML format reader.
     * Reads and parses string value as YAML.
     * Rules applied when parsing for counting are:
     * <ul>
     *    <li>for counting consonants whole text is taken</li>
     *    <li>for counting vowels only values of properties are taken in consideration</li>
     * </ul>
     * @param value Source for counting vowels and consonants
     * @return {@link LetterCounterReadDto}
     */
    public LetterCounterReadDto readFormat(String value) throws FormatReaderException {
        try {
            long consonantCount = _consonantLetterCounter.countLetters(value);
            String mandatoryValues ="";
            InputStream targetStream = new ByteArrayInputStream(value.getBytes());
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(targetStream);
            if(data.isEmpty())
                throw new FormatReaderException("Error occurred when YamlFormatReaderImpl was invoked, invalid format!");

            for (String key : data.keySet()) {
                Object obj = data.get(key);
               mandatoryValues = parseObject(obj, mandatoryValues);
            }

            long vowelsCount = _vowelsLetterCounter.countLetters(mandatoryValues);

            return new LetterCounterReadDto(vowelsCount,consonantCount);

        } catch (Exception e) {
            _logger.error(e.getMessage(), e);
            throw new FormatReaderException("Error occurred when YamlFormatReaderImpl was invoked, error parsing document!", e);
        }
    }

    private String parseObject(Object obj, String mandatoryValues){

        if(obj instanceof ArrayList )
            mandatoryValues = parseArrayList((ArrayList<Object>) obj, mandatoryValues);

        if(obj instanceof LinkedHashMap)
            mandatoryValues = parseLinkedHashMap((LinkedHashMap<String, Object>)obj, mandatoryValues);

        if(!(obj instanceof LinkedHashMap) && !(obj instanceof ArrayList) && obj != null)
            mandatoryValues = _stringConcatenation.concatenate(obj.toString(), mandatoryValues);

        return mandatoryValues;
    }

    private String parseArrayList(ArrayList<Object> arrayList, String mandatoryValues){
        for (Object obj : arrayList){
           mandatoryValues = parseObject(obj, mandatoryValues);
        }
        return mandatoryValues;
    }

    private String parseLinkedHashMap(LinkedHashMap<String, Object> map, String mandatoryValues){
        for (String key : map.keySet()){
            mandatoryValues = parseObject(map.get(key), mandatoryValues);
        }
        return mandatoryValues;
    }
}
