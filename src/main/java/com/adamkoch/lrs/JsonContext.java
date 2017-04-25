package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Context;
import com.adamkoch.lrs.api.Group;
import com.adamkoch.lrs.api.JsonSerializable;
import com.adamkoch.lrs.api.StatementReference;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Map;
import java.util.UUID;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-04-24.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonContext implements Context, JsonSerializable {

    @Override
    public UUID getRegistration() {
        throw new NotYetImplementedException();
    }

    @Override
    public AbstractAgent getInstructor() {
        return null;
    }

//            @Override
//            public Agent getInstructor() {
//                throw new NotYetImplementedException();
//            }

    @Override
    public Group getTeam() {
        throw new NotYetImplementedException();
    }

    @Override
    public Map getContextActivities() {
        throw new NotYetImplementedException();
    }

    @Override
    public String getRevision() {
        throw new NotYetImplementedException();
    }

    @Override
    public String getPlatform() {
        throw new NotYetImplementedException();
    }

    @Override
    public String getLanguage() {
        throw new NotYetImplementedException();
    }

    @Override
    public StatementReference getStatementReference() {
        throw new NotYetImplementedException();
    }

    @Override
    public Map getExtensions() {
        throw new NotYetImplementedException();
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }
}
