package com.adamkoch.lrs;

import com.adamkoch.lrs.api.LanguageTag;

/**
 * Creates a non-validating LanguageTag.
 * TODO: Validate incoming string to see if it is valid.
 * TODO: Find the differences or similarities to Java Locale class.
 *
 * <p>Created by aakoch on 2017-05-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class LanguageTagFactory {
    public static LanguageTag of(String tag) {
        return new NonValidatingLanguageTag(tag);
    }

    private static class NonValidatingLanguageTag implements LanguageTag {
        private final String tag;

        NonValidatingLanguageTag(String tag) {
            this.tag = tag;
        }

        @Override
        public String toString() {
            return tag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NonValidatingLanguageTag that = (NonValidatingLanguageTag) o;

            // From https://tools.ietf.org/html/rfc5646:
            // "At all times, language tags and their subtags, including private use
            // and extensions, are to be treated as case insensitive: there exist
            // conventions for the capitalization of some of the subtags, but these
            // MUST NOT be taken to carry meaning."
            return tag == null ? that.tag == null : tag.equalsIgnoreCase(that.tag);
        }

        @Override
        public int hashCode() {
            return tag == null ? 0 : tag.hashCode();
        }
    }
}
