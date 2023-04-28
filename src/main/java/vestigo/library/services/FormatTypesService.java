package vestigo.library.services;



/**
 * Manage validation of input string and resolve by validation {@link FormatTypes} of input string
 */
interface FormatTypesService {
    /**
     * Manage validation of input string and resolve by validation {@link FormatTypes} of input string.
     * @param value input string
     * @return {@link FormatTypes}
     */
    FormatTypes resolveFormatTypeByValidation(String value);
}
