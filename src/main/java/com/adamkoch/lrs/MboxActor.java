package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.Mbox;

import java.util.Optional;

/**
 * <a href=""></a>
 *
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

    public String getName() {
        return name;
    }

    public Optional<String> getObjectType() {
        return Optional.of("Agent");
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
