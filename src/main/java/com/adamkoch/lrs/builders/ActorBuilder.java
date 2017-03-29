package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.*;
import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.api.ActorType;
import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.Group;

import java.util.Collection;
import java.util.Collections;

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
        }
        else {
            ActorType actorType;
            try {
                actorType = ActorType.of(type);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unknown actor type \"" + type + "\"");
            }

            if (actorType == ActorType.AGENT) {
                if (mbox == null) {
                    throw new NotYetImplementedException();
                }
                else {
                    MboxActor mboxActor = new MboxActor();
                    mboxActor.setName(name);
                    mboxActor.setId(new MboxId(MailToIriCreator.of(mbox)));
                    actor = mboxActor;
                }
            }
            else if (actorType == ActorType.GROUP) {
                actor = new Group() {
                    @Override
                    public Collection<Agent> getMember() {
                        return Collections.emptyList();
                    }

                    @Override
                    public String getName() {
                        return name;
                    }
                };
            }
            else {
                throw new IllegalArgumentException("Unknown actor type \"" + type + "\"");
            }
        }

        return actor;
    }

    public ActorBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ActorBuilder type(String objectType) {
        this.type = objectType;
        return this;
    }

    public ActorBuilder mbox(String mbox) {
        this.mbox = mbox;
        return this;
    }
}
