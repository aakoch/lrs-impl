package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Mbox;
import com.adamkoch.lrs.api.Sha1Sum;

import java.security.NoSuchAlgorithmException;

/**
 * <h1>Created for testing SHA1.</h1>
 *
 * <p>Created by aakoch on 2017-04-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MboxFactory {
    public static Mbox of(String mailtoUri) {
        MboxImpl mbox = new MboxImpl(mailtoUri);
        return mbox;
    }

    private static class MboxImpl implements Mbox {
        private Sha1Sum sha1Sum;

        private MboxImpl(String s) {
            final MailToIRI iri = MailToIriCreator.of(s);
            final String domain = iri.getDomain();
            final String username = iri.getUserName();
            sha1Sum = calculateSha1String(username, domain);
        }

        @Override
        public Sha1Sum getSha1Sum() {
            return sha1Sum;
        }

        private void setSha1Sum(Sha1Sum sha1Sum) {
            this.sha1Sum = sha1Sum;
        }

        private static Sha1Sum calculateSha1String(String username, String domain) {
            final Sha1Creator creator = instantiateCreator();

            return creator.getSha1("mailto:" + username + "@" + domain.toLowerCase());
        }

        private static Sha1Creator instantiateCreator() {
            final Sha1Creator creator;
            try {
                creator = new Sha1Creator();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Could not instantiate the SHA1 creator. Check your Java runtime,", e);
            }
            return creator;
        }
    }
}
