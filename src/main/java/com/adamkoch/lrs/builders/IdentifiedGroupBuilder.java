package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.DefaultIdentifiedGroup;
import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.IdentifiedGroup;
import com.adamkoch.lrs.api.InverseFunctionalIdentifier;

import java.util.Collection;

public class IdentifiedGroupBuilder {
    private Collection<Agent> members;
    private String name;
    private InverseFunctionalIdentifier id;

    public IdentifiedGroupBuilder members(Collection<Agent> members) {
        this.members = members;
        return this;
    }

    public IdentifiedGroupBuilder name(String name) {
        this.name = name;
        return this;
    }

    public IdentifiedGroupBuilder id(InverseFunctionalIdentifier id) {
        this.id = id;
        return this;
    }

    public IdentifiedGroup build() {
        return new DefaultIdentifiedGroup(members, name, id);
    }
}