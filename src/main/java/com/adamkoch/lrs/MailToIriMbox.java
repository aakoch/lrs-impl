package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Sha1Sum;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MailToIriMbox implements com.adamkoch.lrs.api.Mbox {
    private final MailToIRI mbox;

    public MailToIriMbox(MailToIRI mbox) {
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

        MailToIriMbox mbox = (MailToIriMbox) o;

        return this.mbox == null ? mbox.mbox == null : this.mbox.equals(mbox.mbox);
    }

    @Override
    public int hashCode() {
        return mbox == null ? 0 : mbox.hashCode();
    }

    @Override
    public Sha1Sum getSha1Sum() {
        throw new NotYetImplementedException();
    }
}
