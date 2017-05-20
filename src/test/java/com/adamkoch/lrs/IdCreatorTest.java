package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

/**
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IdCreatorTest {

    @Test
    public void testEquals_mailtoAndSha() throws NoSuchAlgorithmException {
        MailToIri mailtoIri = new MailToIri() {
            @Override
            public String getDomain() {
                return null;
            }

            @Override
            public String getUserName() {
                return null;
            }

            @Override
            public String toString() {
                return "empty";
            }
        };
        InverseFunctionalIdentifier id1 = IdCreator.from(mailtoIri);
        Sha1Sum sha1sum = (new Sha1Creator()).getSha1(mailtoIri.toString());
        InverseFunctionalIdentifier id2 = IdCreator.from(sha1sum);
        assertEquals(id1, id2);
    }

    @Test
    public void testEquals_mailtoAndSha_inverted() throws NoSuchAlgorithmException {
        MailToIri mailtoIri = new MailToIri() {
            @Override
            public String getDomain() {
                return null;
            }

            @Override
            public String getUserName() {
                return null;
            }

            @Override
            public String toString() {
                return "empty";
            }
        };
        InverseFunctionalIdentifier id1 = IdCreator.from(mailtoIri);
        Sha1Sum sha1sum = (new Sha1Creator()).getSha1(mailtoIri.toString());
        InverseFunctionalIdentifier id2 = IdCreator.from(sha1sum);
        assertEquals(id2, id1);
    }

    @Test
    public void testEquals_account() throws NoSuchAlgorithmException {
        Account account = new JsonAccount();
        InverseFunctionalIdentifier id1 = IdCreator.from(account);
        InverseFunctionalIdentifier id2 = IdCreator.from(account);
        assertEquals(id1, id2);
    }

    @Test
    public void testEquals_openId() throws NoSuchAlgorithmException {
        UniformResourceIdentifier uri = new DefaultUri("http://toby.openid.example.org/");
        OpenId openId = new DefaultOpenId(uri);

        InverseFunctionalIdentifier id1 = IdCreator.from(openId);
        InverseFunctionalIdentifier id2 = IdCreator.from(openId);
        assertEquals(id1, id2);
    }

}