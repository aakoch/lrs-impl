package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.api.Verb;
import com.adamkoch.lrs.factories.LanguageTagFactory;

import java.util.Optional;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#voided">Voiding</a>
 *
 * <pre>"verb" : {
 "id":"",
 "display":{
 "en-US":"voided"
 }
 },</pre>
 *
 * <p>Created by aakoch on 2017-05-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Void implements Verb {

    public final static Verb INSTANCE = new Void();

    private Void() {
        // prevent instantiation as this should be a singleton
    }

    /**
     * Corresponds to a Verb definition. Each Verb definition corresponds to the meaning of a Verb, not the word.
     */
    @Override
    public InternationalizedResourceIdentifier getId() {
        return new InternationalizedResourceIdentifier() {
            @Override
            public String toString() {
                return "http://adlnet.gov/expapi/verbs/voided";
            }
        };
    }

    /**
     * "The human readable representation of the Verb in one or more languages. This does not have any impact on the
     * meaning of the Statement, but serves to give a human-readable display of the meaning already determined by the
     * chosen Verb."
     *
     * The requirements below relate to the "display" property as returned by the LRS via the API.
     * <ul><li>"When queried for Statements with a Format of 'exact', the LRS MUST return the 'display' property
     * exactly as included (or omitted) within the Statement.</li>
     * <li>When queried for Statements with a Format of 'ids', the LRS *SHOULD* NOT include the 'display' property.
     * </li>
     * <li> When queried for Statements with a Format of 'canonical', the LRS *SHOULD* return a canonical Display for
     * that Verb. </li>
     * <li>The LRS may determine its canonical Display based on the Verb's
     * 'display' property included within Statements it receives, the 'name' property included in the metadata as
     * described in 3.2 Hosted Metadata, or the Verb's Display as defined in some other location."</li></ul>
     *
     * "The 'display' property SHOULD be used by all Statements."
     */
    @Override
    public Optional<LanguageMap> getDisplay() {
        LanguageMap map = new DefaultLanguageMap();
        map.put(LanguageTagFactory.of("en-US"), "voided");
        return Optional.of(map);
    }
}
