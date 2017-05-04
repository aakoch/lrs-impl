package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.MailToIriCreator;
import com.adamkoch.lrs.MailToIriMbox;
import com.adamkoch.lrs.MboxActor;
import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.Group;
import com.adamkoch.lrs.api.ObjectType;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Used to create an {@link Actor}.
 *
 * <p>Created by aakoch on 2017-03-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ActorBuilder {
    private String name;
    private String type;
    private String mbox;

    public Actor build() {
        final Actor actor;
        if (type == null) {
            throw new IllegalArgumentException("Missing required actor type");
        } else {
            ObjectType objectType;
            try {
                objectType = ObjectType.of(type);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unknown actor type \"" + type + "\"");
            }

            if (objectType == ObjectType.AGENT) {

//                An Agent MUST be identified by one (1) of the four types of Inverse Functional Identifiers (see 4.1.2.3 Inverse Functional Identifier);
//                An Agent MUST NOT include more than one (1) Inverse Functional Identifier;

                if ((mbox != null) ^ false ^ false) {
                    MboxActor mboxActor = new MboxActor();
                    mboxActor.setName(name);
                    mboxActor.setId(new MailToIriMbox(MailToIriCreator.of(mbox)));
                    actor = mboxActor;
                } else {
                    throw new IllegalArgumentException("Actor without mbox is not supported yet. TODO");
                }
            } else if (objectType == ObjectType.GROUP) {
                actor = new Group() {
                    @Override
                    public Collection<Agent> getMember() {
                        return Collections.emptyList();
                    }

                    @Override
                    public Optional<String> getName() {
                        return Optional.of(name);
                    }
                };
            } else {
                throw new IllegalArgumentException("Unknown actor type \"" + type + "\"");
            }
        }

        return actor;
    }

    public ActorBuilder name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Takes a String because it's intention is to read from JSON.
     */
    public ActorBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ActorBuilder mbox(String mbox) {
        this.mbox = mbox;
        return this;
    }
}
