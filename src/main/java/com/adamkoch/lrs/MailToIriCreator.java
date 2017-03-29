package com.adamkoch.lrs;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MailToIriCreator {
    public static MailToIRI of(String mbox) {
        return new MailToIriCreator.DefaultMailToIRI(mbox);
    }

    private static class DefaultMailToIRI implements MailToIRI {
        private final String mbox;

        public DefaultMailToIRI(String mbox) {
            this.mbox = mbox;
        }

        @Override
        public String toString() {
            return mbox;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DefaultMailToIRI that = (DefaultMailToIRI) o;

            return mbox != null ? mbox.equals(that.mbox) : that.mbox == null;
        }

        @Override
        public int hashCode() {
            return mbox != null ? mbox.hashCode() : 0;
        }
    }
}
