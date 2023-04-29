package vestigo.library.services;


/**
 * Data transfer object used for returning final count of vowels and consonants.
 */

public class LetterCounterReadDto {
    private final long vowelCount;
    private final long consonantCount;

    public LetterCounterReadDto(long vowelCount, long consonantCount) {
        this.vowelCount = vowelCount;
        this.consonantCount = consonantCount;
    }

    public long getVowelCount() {
        return vowelCount;
    }

    public long getConsonantCount() {
        return consonantCount;
    }

}
