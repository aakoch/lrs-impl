package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.api.MailToIRI;
import com.adamkoch.lrs.api.ObjectType;

import java.util.Optional;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultActor implements Actor {
    private final MailToIRI mailToIRI;

    public DefaultActor(MailToIRI mailToIRI) {
        this.mailToIRI = mailToIRI;
    }

    @Override
    public Optional<String> getName() {
        return null;
    }

    @Override
    public Optional<ObjectType> getObjectType() {
        return null;
    }
}
