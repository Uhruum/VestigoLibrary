package vestigo.library.services;
/**
 * Thrown when could not resolve {@link FormatReader} in
 * {@link FormatReaderProvider}.
 */
class FormatReaderProviderException extends Exception{
    public FormatReaderProviderException(String message) {
        super(message);
    }
}
