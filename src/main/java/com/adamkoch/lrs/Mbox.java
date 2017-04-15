package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InverseFunctionalIdentifier;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Mbox implements InverseFunctionalIdentifier {
    private final MailToIRI mbox;

    public Mbox(MailToIRI mbox) {
        this.mbox = mbox;
    }

    @Override
    public String toString() {
        return mbox.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mbox mbox = (Mbox) o;

        return this.mbox != null ? this.mbox.equals(mbox.mbox) : mbox.mbox == null;
    }

    @Override
    public int hashCode() {
        return mbox != null ? mbox.hashCode() : 0;
    }
}
