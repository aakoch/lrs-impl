package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.IdentifiedGroup;
import com.adamkoch.lrs.api.InverseFunctionalIdentifier;

import java.util.Collection;

/**
 * "An Identified Group is used to uniquely identify a cluster of Agents."
 *
 * <p>Created by aakoch on 2017-03-22.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultIdentifiedGroup extends DefaultAnonymousGroup implements IdentifiedGroup {

    private InverseFunctionalIdentifier id;

    public DefaultIdentifiedGroup(Collection<Agent> members, String name) {
        super(members, name);
    }

    @Override
    public InverseFunctionalIdentifier getId() {
        return id;
    }
}

