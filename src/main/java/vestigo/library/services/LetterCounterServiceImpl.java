package vestigo.library.services;

/**
 * Default implementation of {@link LetterCounterService }
 */
public class LetterCounterServiceImpl implements LetterCounterService {

    private final FormatTypesService _formatTypesService;
    private final FormatReaderProvider _formatReaderProvider;

    public LetterCounterServiceImpl() {
        _formatTypesService = new FormatTypesServiceImpl();
        _formatReaderProvider = new FormatReaderProviderImpl();
    }

    public LetterCounterReadDto count(String text) throws FormatReaderProviderException, FormatReaderException {
        return _formatReaderProvider.provideFormatReader(
                        _formatTypesService.resolveFormatTypeByValidation(text))
                .readFormat(text);
    }
}
