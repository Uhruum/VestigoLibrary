package vestigo.library.services;

/**
 * Validates input string.
 */
interface FormatValidator {
    /**
     * Validates input string.
     * @param value input string
     * @return {@link Boolean}
     */
    boolean isValid(String value);
}
