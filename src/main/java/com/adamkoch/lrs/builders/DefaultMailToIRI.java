package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.MailToIRI;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultMailToIRI implements MailToIRI {
    private final String mbox;

    public DefaultMailToIRI(String mbox) {
        this.mbox = mbox;
    }

    @Override
    public String getDomain() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }
}
