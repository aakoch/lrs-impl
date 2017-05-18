package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.AnonymousGroup;

import java.util.Collection;
import java.util.Optional;

/**
 * A Learning Record Consumer MUST consider each Anonymous Group distinct even if it has an identical set of members.
 *
 * <p>Created by aakoch on 2017-03-22.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultAnonymousGroup implements AnonymousGroup {

    private Collection<Agent> members;

    private String name;

    public DefaultAnonymousGroup(Collection<Agent> members, String name) {
        this.members = members;
        this.name = name;
    }

    @Override
    public Collection<Agent> getMember() {
        return members;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public boolean equals(Object obj) {
        // A Learning Record Consumer MUST consider each Anonymous Group distinct even if it has an identical set of members.
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
