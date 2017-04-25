package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.JsonAuthority;
import com.adamkoch.lrs.api.Authority;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class AuthorityBuilder {
    public Authority build() {
        return new JsonAuthority();
    }
}
