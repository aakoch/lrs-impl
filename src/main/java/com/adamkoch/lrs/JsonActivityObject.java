package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Activity;
import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.JsonSerializable;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * <p>Created by aakoch on 2017-04-24.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonActivityObject implements Activity, JsonSerializable {

    private ActivityDefinition definition;
    private InternationalizedResourceIdentifier id;

    @Override
    public InternationalizedResourceIdentifier getId() {
        return id;
    }

    @Override
    public ActivityDefinition getDefinition() {
        return definition;
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }

    public void setDefinition(ActivityDefinition definition) {
        this.definition = definition;
    }

    public void setId(InternationalizedResourceIdentifier id) {
        this.id = id;
    }
}
