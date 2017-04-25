package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Authority;
import com.adamkoch.lrs.api.JsonSerializable;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * <p>Created by aakoch on 2017-04-24.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonAuthority implements Authority, JsonSerializable {

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }
}
