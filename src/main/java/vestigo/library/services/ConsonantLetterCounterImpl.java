package vestigo.library.services;

import java.util.Set;

/**
 * Implementation of {@link LetterCounter} as Consonant counter.
 * Counts consonants in input string.
 */
class ConsonantLetterCounterImpl extends AbstractLetterCounter implements LetterCounter {

    private final VowelsProvider _vowelsProvider;

    public ConsonantLetterCounterImpl() {
        _vowelsProvider = new VowelsProviderImpl();
    }

    @Override
    protected boolean getMapKey() {
        return false;
    }

    @Override
    protected Set<Character> getVowels() {
        return _vowelsProvider.getVowels();
    }
}
