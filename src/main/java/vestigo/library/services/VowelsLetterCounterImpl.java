package vestigo.library.services;

import java.util.Set;
/**
 * Implementation of {@link LetterCounter} as Vowels counter.
 * Count vowels in input string.
 */
class VowelsLetterCounterImpl extends AbstractLetterCounter implements LetterCounter {

    private final VowelsProvider _vowelsProvider;

    public VowelsLetterCounterImpl() {
        _vowelsProvider = new VowelsProviderImpl();
    }

    @Override
    protected boolean getMapKey() {
        return true;
    }

    @Override
    protected Set<Character> getVowels() {
        return _vowelsProvider.getVowels();
    }
}
