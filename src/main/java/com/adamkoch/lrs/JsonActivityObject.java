package com.adamkoch.lrs;

import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.ActivityObject;
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
public class JsonActivityObject implements ActivityObject, JsonSerializable {

    @Override
    public InternationalizedResourceIdentifier getId() {
        throw new NotYetImplementedException();
    }

    @Override
    public ActivityDefinition getDefinition() {
        throw new NotYetImplementedException();
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }
}
