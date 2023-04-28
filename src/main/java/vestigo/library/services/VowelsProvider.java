package vestigo.library.services;

import java.util.Set;

/**
 * Provides set of vowels characters
 */
interface VowelsProvider {
    /**
     * Provides set of vowels characters
     * @return {@link Set} of {@link Character}
     */
    Set<Character> getVowels();
}
