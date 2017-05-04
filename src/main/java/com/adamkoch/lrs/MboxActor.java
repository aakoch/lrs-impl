package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.Mbox;
import com.adamkoch.lrs.api.ObjectType;

import java.util.Optional;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MboxActor implements Agent {

    private String name;
    private String mbox;
    private Mbox id;

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return Optional.of(name);
    }

    public Optional<ObjectType> getObjectType() {
        return Optional.of(ObjectType.AGENT);
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }

    public String getMbox() {
        return mbox;
    }

    public void setId(Mbox id) {
        this.id = id;
    }
}
