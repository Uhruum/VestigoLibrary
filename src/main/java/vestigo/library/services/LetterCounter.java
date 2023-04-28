package vestigo.library.services;

/**
 * Counts characters in string
 */
interface LetterCounter {
    /**
     * Counts characters in string
     * @param value input string
     * @return {@link Long} count
     */
    long countLetters(String value);
}
