package vestigo.library.services;

/**
 * Provides specific {@link FormatReader} by {@link FormatTypes}
 */
interface FormatReaderProvider {
    /**
     * Provides specific {@link FormatReader} by {@link FormatTypes}
     * @param formatType
     * @return {@link FormatReader}
     */
    FormatReader provideFormatReader(FormatTypes formatType) throws FormatReaderProviderException;
}
