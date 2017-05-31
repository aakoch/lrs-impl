package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.builders.ActivityDefinitionBuilder;
import com.adamkoch.lrs.builders.LanguageMapBuilder;

import javax.json.JsonObject;

/**
 * <p>Created by aakoch on 2017-05-20.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ActivityDefinitionFactory {
    public static ActivityDefinition of(final JsonObject jsonObject) {
        final ActivityDefinitionBuilder builder = new ActivityDefinitionBuilder();

        if (jsonObject.containsKey("name")) {
            builder.name(convertToLanguageMap(jsonObject.getJsonObject("name")));
        }

        if (jsonObject.containsKey("description")) {
            builder.description(convertToLanguageMap(jsonObject.getJsonObject("description")));
        }

        if (jsonObject.containsKey("type")) {
            final String type = jsonObject.getString("type");
            builder.type(IriFactory.of(type));
        }
        if (jsonObject.containsKey("moreInfo")) {
            final String moreInfo = jsonObject.getString("moreInfo");
            builder.moreInfo(IrlFactory.of(moreInfo));
        }
        if (jsonObject.containsKey("extensions")) {
            final JsonObject extensions = jsonObject.getJsonObject("extensions");
            builder.extensions(ExtensionsFactory.of(extensions));
        }

        return builder.build();
    }

    private static LanguageMap convertToLanguageMap(JsonObject jsonObject) {
        return new LanguageMapBuilder().of(jsonObject);
    }

}
