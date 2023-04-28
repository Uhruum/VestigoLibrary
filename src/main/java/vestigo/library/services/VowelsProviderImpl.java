package vestigo.library.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Default implementation of {@link VowelsProvider}
 */
class VowelsProviderImpl implements VowelsProvider {
    public Set<Character> getVowels() {
        return new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    }
}
