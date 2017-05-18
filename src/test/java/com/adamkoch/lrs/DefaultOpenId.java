package com.adamkoch.lrs;

import com.adamkoch.lrs.api.OpenId;
import com.adamkoch.lrs.api.UniformResourceIdentifier;

/**
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultOpenId implements OpenId {
    private final UniformResourceIdentifier uri;

    public DefaultOpenId(UniformResourceIdentifier uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultOpenId that = (DefaultOpenId) o;

        return uri != null ? uri.equals(that.uri) : that.uri == null;
    }

    @Override
    public int hashCode() {
        return uri != null ? uri.hashCode() : 0;
    }

    @Override
    public String toString() {
        return uri.toString();
    }
}
