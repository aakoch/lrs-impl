package com.adamkoch.lrs;

import com.adamkoch.lrs.api.JsonSerializable;
import com.adamkoch.lrs.api.LrsObject;
import com.adamkoch.lrs.api.Result;
import com.adamkoch.lrs.api.Score;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.time.Duration;

/**
 * <p>Created by aakoch on 2017-04-24.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonResult implements Result, JsonSerializable {

    @Override
    public Score getScore() {
        throw new NotYetImplementedException();
    }

    @Override
    public Boolean getSuccess() {
        throw new NotYetImplementedException();
    }

    @Override
    public Boolean getCompletion() {
        throw new NotYetImplementedException();
    }

    @Override
    public String getResponse() {
        throw new NotYetImplementedException();
    }

    @Override
    public Duration getDuration() {
        throw new NotYetImplementedException();
    }

    @Override
    public LrsObject getExtensions() {
        throw new NotYetImplementedException();
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }
}
