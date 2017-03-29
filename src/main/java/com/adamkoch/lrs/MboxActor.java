package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MboxActor extends Agent {

    private String name;
    private String mbox;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getObjectType() {
        return "Agent";
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }

    public String getMbox() {
        return mbox;
    }
}
