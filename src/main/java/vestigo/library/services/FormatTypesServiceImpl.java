package vestigo.library.services;

/**
 * Default implementation of {@link FormatTypesService }
 */

class FormatTypesServiceImpl implements FormatTypesService {

    private final FormatValidator _jsonFormatValidator;
    private final FormatValidator _xmlFormatValidator;
    private final FormatValidator _yamlFormatValidator;

    public FormatTypesServiceImpl() {
        _jsonFormatValidator = new JsonFormatValidatorImpl();
        _xmlFormatValidator = new XmlFormatValidatorImpl();
        _yamlFormatValidator = new YamlFormatValidatorImpl();
    }

    public FormatTypes resolveFormatTypeByValidation(String value) {

        if (_xmlFormatValidator.isValid(value))
            return FormatTypes.XML;

        if(_jsonFormatValidator.isValid(value))
            return FormatTypes.JSON;

        if(_yamlFormatValidator.isValid(value))
            return FormatTypes.YAML;

        return FormatTypes.PLAIN_TEXT;
    }
}
