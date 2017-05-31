package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.JsonAuthority;
import com.adamkoch.lrs.api.Authority;
import com.adamkoch.lrs.api.InverseFunctionalIdentifier;
import com.adamkoch.lrs.api.ObjectType;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class AuthorityBuilder {
    private ObjectType objectType;
    private InverseFunctionalIdentifier id;

    public Authority build() {
        assert objectType != null;

        final JsonAuthority authority = new JsonAuthority();
        authority.setId(id);
        authority.setObjectType(objectType);
        return authority;
    }

    public AuthorityBuilder objectType(ObjectType objectType) {
        this.objectType = objectType;
        return this;
    }

    public AuthorityBuilder id(InverseFunctionalIdentifier id) {
        this.id = id;
        return this;
    }
}
