package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.AbstractAgent;
import com.adamkoch.lrs.IdCreator;
import com.adamkoch.lrs.api.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>Created by aakoch on 2017-04-28.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class AgentBuilder {
    private InverseFunctionalIdentifier id;
    private MailToIri mbox;
    private Sha1Sum sha1;
    private Account account;
    private OpenId openId;
    private String name;

    // An Agent MUST be identified by one (1) of the four types of Inverse Functional Identifiers (see 4.1.2.3 Inverse
    // Functional Identifier);
    // An Agent MUST NOT include more than one (1) Inverse Functional Identifier;
    // An Agent SHOULD NOT use Inverse Functional Identifiers that are also used as a Group identifier.

    public Agent build() {
        final long numberOfNulls = countNulls(mbox, sha1, account, openId);
        if (numberOfNulls == 4) {
            throw new IllegalArgumentException("No IFI");
        }
        if (numberOfNulls < 3) {
            throw new IllegalArgumentException("Too many IFIs");
        }
        DefaultAgent agent = new DefaultAgent();
        if (name != null) {
            agent.setName(name);
        }
        final InverseFunctionalIdentifier id;
        if (mbox != null) {
            id = IdCreator.from(mbox);
        }
        else if (sha1 != null) {
            id = IdCreator.from(sha1);
        }
        else if (account != null) {
            id = IdCreator.from(account);
        }
        else if (openId != null) {
            id = IdCreator.from(openId);
        }
        else {
            id = null;
        }
        agent.setId(id);
        return agent;
    }

    private long countNulls(Object... objects) {
        return Arrays.stream(objects).filter(Objects::isNull).count();
    }

    public AgentBuilder mbox(MailToIri mbox) {
        this.mbox = mbox;

        return this;
    }

    public AgentBuilder mboxSha1Sum(Sha1Sum sha1) {
        this.sha1 = sha1;
        return this;
    }

    public AgentBuilder openId(OpenId openId) {
        this.openId = openId;
        return this;
    }

    public AgentBuilder account(Account account) {
        this.account = account;
        return this;
    }

    public AgentBuilder name(String name) {
        this.name = name;
        return this;
    }

    private class DefaultAgent extends AbstractAgent {
        private Optional<String> name;

        DefaultAgent() {
            name = Optional.empty();
        }

        @Override
        public Optional<String> getName() {
            return name;
        }

        public void setName(String name) {
            if (isValidName(name))
                this.name = Optional.of(name);
            else
                throw new IllegalArgumentException(name + " is not a valid name");
        }

        private boolean isValidName(String name) {
            return name != null;
        }
    }
}
