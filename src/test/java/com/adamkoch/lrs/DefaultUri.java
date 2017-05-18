package com.adamkoch.lrs;

import com.adamkoch.lrs.api.UniformResourceIdentifier;

/**
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultUri implements UniformResourceIdentifier {

    private final String uri;

    public DefaultUri(String uri) {
        this.uri = uri;
    }
}
