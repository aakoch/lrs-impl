package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.JsonVerb;
import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.api.Verb;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class VerbBuilder {
    private LanguageMap display;
    private InternationalizedResourceIdentifier id;

    public Verb build() {
        final JsonVerb jsonVerb = new JsonVerb();
        jsonVerb.setDisplay(display);
        jsonVerb.setId(id);
        return jsonVerb;
    }

    public VerbBuilder display(LanguageMap display) {
        this.display = display;
        return this;
    }

    public VerbBuilder id(InternationalizedResourceIdentifier id) {
        this.id = id;
        return this;
    }
}
