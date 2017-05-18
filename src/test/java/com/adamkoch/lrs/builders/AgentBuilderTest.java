package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.Account;
import com.adamkoch.lrs.api.MailToIRI;
import com.adamkoch.lrs.api.OpenId;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-04-28.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class AgentBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAgentMustHaveIdentifier() throws Exception {
        new AgentBuilder().build();
    }

    @Test
    public void testAgentWithMbox() throws Exception {
        MailToIRI mbox = mock(MailToIRI.class);
        new AgentBuilder().mbox(mbox).build();
    }

    @Test
    public void testAgentWithMboxSha1Sum() throws Exception {
        new AgentBuilder().mboxSha1Sum(new DummySha1Sum("test")).build();
    }

    @Test
    public void testAgentWithOpenId() throws Exception {
        OpenId openId = mock(OpenId.class);
        new AgentBuilder().openId(openId).build();
    }

    @Test
    public void testAgentWithAccount() throws Exception {
        Account account = mock(Account.class);
        new AgentBuilder().account(account).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgentWithMultipleIFI_MboxAndOpenId() throws Exception {
        MailToIRI mbox = mock(MailToIRI.class);
        OpenId openId = mock(OpenId.class);
        new AgentBuilder().mbox(mbox).openId(openId).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgentWithMultipleIFI_MboxSha1SumAndAccount() throws Exception {
        Account account = mock(Account.class);
        new AgentBuilder().mboxSha1Sum(new DummySha1Sum("test")).account(account).build();
    }

    // An Agent MUST be identified by one (1) of the four types of Inverse Functional Identifiers (see 4.1.2.3 Inverse
    // Functional Identifier);
    // An Agent MUST NOT include more than one (1) Inverse Functional Identifier;
    // An Agent SHOULD NOT use Inverse Functional Identifiers that are also used as a Group identifier.

}