package com.adamkoch.lrs;

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
        return definition;
    }

    private static LanguageMap convertToLanguageMap(JsonObject jsonObject) {
        return new LanguageMapBuilder().of(jsonObject);
    }

    private static class DefaultActivityDefinition implements ActivityDefinition {
        private LanguageMap name;
        private LanguageMap description;

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
            throw new NotYetImplementedException();
        }

        @Override
        public InternationalizedResourceLocator getMoreInfo() {
            throw new NotYetImplementedException();
        }

        @Override
        public LrsObject getExtensions() {
            throw new NotYetImplementedException();
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
    }
}
