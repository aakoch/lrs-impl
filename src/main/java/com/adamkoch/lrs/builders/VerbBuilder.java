package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.JsonVerb;
import com.adamkoch.lrs.api.Verb;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class VerbBuilder {
    public Verb build() {
        return new JsonVerb();
    }
}
