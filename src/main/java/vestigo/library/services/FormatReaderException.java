package vestigo.library.services;
/**
 * Thrown when any error occurred in {@link FormatReader}.
 */
class FormatReaderException extends Exception {

    public FormatReaderException(String message, Throwable  e) {
            super(message,e);
    }

    public FormatReaderException(String message) {
        super(message);
    }
}
