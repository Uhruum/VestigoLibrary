package vestigo.library.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of {@link FormatReaderProvider}
 */
class FormatReaderProviderImpl implements FormatReaderProvider {

    private final Map<FormatTypes, FormatReader> _map;

    public FormatReaderProviderImpl(){
        Map<FormatTypes, FormatReader> map = new HashMap<>();
        map.put(FormatTypes.PLAIN_TEXT, new PlainTextFormatReaderImpl());
        map.put(FormatTypes.XML, new XmlFormatReaderImpl());
        map.put(FormatTypes.JSON, new JsonFormatReaderImpl());
        map.put(FormatTypes.YAML, new YamlFormatReaderImpl());
        _map = map;
    }


    public FormatReader provideFormatReader(FormatTypes formatType) throws FormatReaderProviderException {
        if(_map.containsKey(formatType))
            return _map.get(formatType);

        throw new FormatReaderProviderException("Could not provide requested FormatReader, mapping dose not exists!");
    }

}
