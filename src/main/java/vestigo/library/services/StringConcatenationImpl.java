package vestigo.library.services;

/**
 * Default implementation of {@link StringConcatenation}
 */

class StringConcatenationImpl implements StringConcatenation {

    public String concatenate(String value, String concatenatedValue) {
        return value == null ? concatenatedValue.concat("") : concatenatedValue.concat(value);
    }
}
