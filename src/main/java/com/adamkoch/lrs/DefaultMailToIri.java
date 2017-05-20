package com.adamkoch.lrs;

import com.adamkoch.lrs.api.MailToIri;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultMailToIri implements MailToIri {
    private final String mbox;

    public DefaultMailToIri(String mbox) {
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

    @Override
    public String toString() {
        return mbox;
    }
}
