package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Authority;
import com.adamkoch.lrs.api.InverseFunctionalIdentifier;
import com.adamkoch.lrs.api.JsonSerializable;
import com.adamkoch.lrs.api.ObjectType;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Optional;

/**
 * <p>Created by aakoch on 2017-04-24.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonAuthority implements Authority, JsonSerializable {

    private InverseFunctionalIdentifier id;
    private ObjectType objectType;
    private String name;

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }

    @Override
    public Optional<ObjectType> getObjectType() {
        return Optional.ofNullable(objectType);
    }

    public void setId(InverseFunctionalIdentifier id) {
        this.id = id;
    }

    public InverseFunctionalIdentifier getId() {
        return id;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
