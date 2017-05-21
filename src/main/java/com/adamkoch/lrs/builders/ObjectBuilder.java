package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.IriFactory;
import com.adamkoch.lrs.JsonActivityObject;
import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.LrsObject;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ObjectBuilder {
    private String id;
    private ActivityDefinition definition;

    public LrsObject build() {
        final JsonActivityObject activity = new JsonActivityObject();
        activity.setId(IriFactory.of(id));
        activity.setDefinition(definition);
        return activity;
    }

    public ObjectBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ObjectBuilder definition(ActivityDefinition definition) {
        this.definition = definition;
        return this;
    }
}
