package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.JsonSerializable;
import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.api.Verb;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Optional;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#243-verb">Verb</a>.
 *
 * <p>Created by aakoch on 2017-03-22.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonVerb implements Verb, JsonSerializable {
    private LanguageMap display;
    private InternationalizedResourceIdentifier id;

    @Override
    public InternationalizedResourceIdentifier getId() {
        return id;
    }

    @Override
    public Optional<LanguageMap> getDisplay() {
        return Optional.ofNullable(display);
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }

    public void setDisplay(LanguageMap display) {
        this.display = display;
    }

    public void setId(InternationalizedResourceIdentifier id) {
        this.id = id;
    }
}
