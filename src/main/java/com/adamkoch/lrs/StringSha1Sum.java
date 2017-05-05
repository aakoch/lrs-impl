package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Sha1Sum;

/**
 * <p>Created by aakoch on 2017-05-05.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
class StringSha1Sum implements Sha1Sum {
    private final String str;

    private StringSha1Sum(final String str) {
        this.str = str;
    }

    public static StringSha1Sum of(final String str) {
        validateSha1Sum(str);
        return new StringSha1Sum(str);
    }

    private static void validateSha1Sum(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Null or empty sha-1 sum is not valid");
        }
        else {
            final byte[] bytes = str.getBytes();
            if (bytes.length != 40) {
                throw new IllegalArgumentException("Sha-1 sum is not 40 bytes long. " + str);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringSha1Sum that = (StringSha1Sum) o;

        return str != null ? str.equals(that.str) : that.str == null;
    }

    @Override
    public int hashCode() {
        return str != null ? str.hashCode() : 0;
    }

    @Override
    public String toString() {
        return str;
    }
}
