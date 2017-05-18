package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.AbstractAgent;
import com.adamkoch.lrs.api.MailToIRI;

import java.util.Optional;

/**
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultAgent extends AbstractAgent {
    private final MailToIRI mailToIRI;
    private String name;

    public DefaultAgent(MailToIRI mailToIRI) {
        this.mailToIRI = mailToIRI;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
