package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

/**
 * Creates implementation of IFIs from inner class. This will probably be moved out at some point.
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IdCreator {

    public static InverseFunctionalIdentifier from(MailToIri iri) {
        final DefaultIFI defaultIFI = new DefaultIFI();
        defaultIFI.setMailtoIRI(iri);
        return defaultIFI;
    }

    public static InverseFunctionalIdentifier from(Sha1Sum sha1Sum) {
        final DefaultIFI defaultIFI = new DefaultIFI();
        defaultIFI.setSha1Sum(sha1Sum);
        return defaultIFI;
    }

    public static InverseFunctionalIdentifier from(Account account) {
        final DefaultIFI defaultIFI = new DefaultIFI();
        defaultIFI.setAccount(account);
        return defaultIFI;
    }

    public static InverseFunctionalIdentifier from(OpenId openId) {
        final DefaultIFI defaultIFI = new DefaultIFI();
        defaultIFI.setOpenId(openId);
        return defaultIFI;
    }

    private static class DefaultIFI implements InverseFunctionalIdentifier {
        private final UUID id;
        private MailToIri mailtoIRI;
        private Sha1Sum sha1Sum;
        private Account account;
        private OpenId openId;

        public DefaultIFI() {
            id = UUID.randomUUID();
        }

        public DefaultIFI(UUID uuid) {
            id = uuid;
        }

        @Override
        public Optional<MailToIri> getMBox() {
            return Optional.ofNullable(mailtoIRI);
        }

        @Override
        public Optional<Sha1Sum> getMboxSha1Sum() {
            return Optional.ofNullable(sha1Sum);
        }

        @Override
        public Optional<OpenId> getOpenId() {
            return Optional.empty();
        }

        @Override
        public Optional<Account> getAccount() {
            return Optional.ofNullable(account);
        }

        public void setMailtoIRI(MailToIri mailtoIRI) {
            this.mailtoIRI = mailtoIRI;
        }

        public void setSha1Sum(Sha1Sum sha1Sum) {
            this.sha1Sum = sha1Sum;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public void setOpenId(OpenId openId) {
            this.openId = openId;
        }

        @Override
        public String toString() {
            if (mailtoIRI != null)
                return mailtoIRI.toString();

            if (sha1Sum != null)
                return sha1Sum.toString();

            if (openId != null)
                return openId.toString();

            if (account != null)
                return account.toString();

            return id.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DefaultIFI that = (DefaultIFI) o;

            boolean idsNotNullAndEqual = id != null && that.id != null && id.equals(that.id);
            if (idsNotNullAndEqual) {
                return true;
            }

            boolean mboxesNotNullAndEqual = mailtoIRI != null && that.mailtoIRI != null && mailtoIRI.equals(that
                    .mailtoIRI);
            if (mboxesNotNullAndEqual) {
                return true;
            }

            boolean sha1SumsNotNullAndEqual = sha1Sum != null && that.sha1Sum != null && sha1Sum.equals(that.sha1Sum);
            if (sha1SumsNotNullAndEqual) {
                return true;
            }

            boolean accountsNotNullAndEqual = account != null && that.account != null && account.equals(that.account);
            if (accountsNotNullAndEqual) {
                return true;
            }

            boolean openIdsNotNullAndEqual = openId != null && that.openId != null && openId.equals(that.openId);
            if (openIdsNotNullAndEqual) {
                return true;
            }

            if (sha1Sum == null && that.sha1Sum != null) {
                try {
                    sha1Sum = (new Sha1Creator()).getSha1(mailtoIRI.toString());
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return sha1Sum.equals(that.sha1Sum);
            }

            if (that.sha1Sum == null && sha1Sum != null) {
                Sha1Sum thatSha1Sum = null;
                try {
                    thatSha1Sum = (new Sha1Creator()).getSha1(that.mailtoIRI.toString());
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return sha1Sum.equals(thatSha1Sum);
            }

            return false;
        }

        /**
         * TODO: finish changing so contract with equals method is fulfilled.
         */
        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (mailtoIRI != null ? mailtoIRI.hashCode() : 0);
            result = 31 * result + (sha1Sum != null ? sha1Sum.hashCode() : 0);
            return result;
        }
    }
}
