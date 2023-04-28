package vestigo.library.services;

/**
 * Concatenates string values
 */
interface StringConcatenation {
    /**
     * Concatenates string values
     * @param value new value fot concatenation
     * @param concatenatedValue target for concatenation
     * @return {@link String} in this case is that param concatenatedValue
     */
    String concatenate(String value, String concatenatedValue);
}
