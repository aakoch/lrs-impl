package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.InverseFunctionalIdentifier;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#2421-when-the-actor-objecttype-is-agent">Agent</a>.
 *
 * <p>An Agent (an individual) is a persona or system.</p>
 *
 * Created by aakoch on 2017-03-22.
 *
 * @author aakoch
 * @since 1.0.0
 */
public abstract class AbstractAgent implements Agent {

    private InverseFunctionalIdentifier id;

    public AbstractAgent(InverseFunctionalIdentifier id) {
        this.id = id;
    }

    protected AbstractAgent() {
    }

    public InverseFunctionalIdentifier getId() {
        return id;
    }

    public void setId(InverseFunctionalIdentifier id) {
        this.id = id;
    }
}
