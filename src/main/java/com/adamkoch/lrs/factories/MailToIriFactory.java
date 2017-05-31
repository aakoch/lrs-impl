package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.DefaultMailToIri;
import com.adamkoch.lrs.api.MailToIri;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MailToIriFactory {
    public static MailToIri of(String mbox) {
        return new DefaultMailToIri(mbox);
    }

//    private static class DefaultMailToIri implements MailToIRI {
//        private final String mbox;
//
//        public DefaultMailToIri(String mbox) {
//            this.mbox = mbox;
//        }
//
//        @Override
//        public String toString() {
//            return mbox;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            DefaultMailToIri that = (DefaultMailToIri) o;
//
//            return mbox == null ? that.mbox == null : mbox.equals(that.mbox);
//        }
//
//        @Override
//        public int hashCode() {
//            return mbox != null ? mbox.hashCode() : 0;
//        }
//
//        @Override
//        public String getDomain() {
//            return StringUtils.substringAfter(mbox, "@");
//        }
//
//        @Override
//        public String getUserName() {
//            return StringUtils.substringBefore(mbox, "@");
//        }
//    }
}
