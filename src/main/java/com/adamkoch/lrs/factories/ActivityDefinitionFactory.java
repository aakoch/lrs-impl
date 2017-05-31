package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.*;
import com.adamkoch.lrs.builders.LanguageMapBuilder;

import javax.json.JsonObject;
import java.util.Collection;

/**
 * <p>Created by aakoch on 2017-05-20.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ActivityDefinitionFactory {
    public static ActivityDefinition of(JsonObject jsonObject) {
        final DefaultActivityDefinition definition = new DefaultActivityDefinition();
        definition.setName(convertToLanguageMap(jsonObject.getJsonObject("name")));
        definition.setDescription(convertToLanguageMap(jsonObject.getJsonObject("description")));
        if (jsonObject.containsKey("type")) {
            final String type = jsonObject.getString("type");
            definition.setType(IriFactory.of(type));
        }
        if (jsonObject.containsKey("moreInfo")) {
            final String moreInfo = jsonObject.getString("moreInfo");
            definition.setMoreInfo(IrlFactory.of(moreInfo));
        }
        if (jsonObject.containsKey("extensions")) {
            final JsonObject extensions = jsonObject.getJsonObject("extensions");
            definition.setExtensions(ExtensionsFactory.of(extensions));
        }
        return definition;
    }

    private static LanguageMap convertToLanguageMap(JsonObject jsonObject) {
        return new LanguageMapBuilder().of(jsonObject);
    }

    private static class DefaultActivityDefinition implements ActivityDefinition {
        private LanguageMap name;
        private LanguageMap description;
        private InternationalizedResourceIdentifier type;
        private InternationalizedResourceLocator moreInfo;
        private Extensions extensions;

        @Override
        public LanguageMap getName() {
            return name;
        }

        @Override
        public LanguageMap getDescription() {
            return description;
        }

        @Override
        public InternationalizedResourceIdentifier getType() {
            return type;
        }

        @Override
        public InternationalizedResourceLocator getMoreInfo() {
            return moreInfo;
        }

        @Override
        public Extensions getExtensions() {
            return extensions;
        }

        @Override
        public Collection<InteractionActivity> getInteractionActivities() {
            throw new NotYetImplementedException();
        }

        public void setName(LanguageMap name) {
            this.name = name;
        }

        public void setDescription(LanguageMap description) {
            this.description = description;
        }

        public void setType(InternationalizedResourceIdentifier type) {
            this.type = type;
        }

        public void setMoreInfo(InternationalizedResourceLocator moreInfo) {
            this.moreInfo = moreInfo;
        }

        public void setExtensions(Extensions extensions) {
            this.extensions = extensions;
        }
    }
}
