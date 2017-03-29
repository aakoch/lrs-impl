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
public class MboxId implements InverseFunctionalIdentifier {
    private final MailToIRI mbox;

    public MboxId(MailToIRI mbox) {
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

        MboxId mboxId = (MboxId) o;

        return mbox != null ? mbox.equals(mboxId.mbox) : mboxId.mbox == null;
    }

    @Override
    public int hashCode() {
        return mbox != null ? mbox.hashCode() : 0;
    }
}
