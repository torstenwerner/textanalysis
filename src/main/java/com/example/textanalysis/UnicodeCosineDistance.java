package com.example.textanalysis;

import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.Map;

/**
 * Unicode version of {@link org.apache.commons.text.similarity.CosineDistance}.
 */
public class UnicodeCosineDistance {
    private final UnicodeRegexTokenizer tokenizer = new UnicodeRegexTokenizer();
    /**
     * Cosine similarity.
     */
    private final CosineSimilarity cosineSimilarity = new CosineSimilarity();

    public Double apply(final CharSequence left, final CharSequence right) {
        final CharSequence[] leftTokens = tokenizer.tokenize(left);
        final CharSequence[] rightTokens = tokenizer.tokenize(right);

        final Map<CharSequence, Integer> leftVector = Counter.of(leftTokens);
        final Map<CharSequence, Integer> rightVector = Counter.of(rightTokens);
        final double similarity = cosineSimilarity.cosineSimilarity(leftVector, rightVector);
        return 1.0 - similarity;
    }
}
