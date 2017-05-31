package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.*;

import java.util.Collection;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-30.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ActivityDefinitionBuilder {
    private LanguageMap name;
    private LanguageMap description;
    private InternationalizedResourceIdentifier type;
    private InternationalizedResourceLocator moreInfo;
    private Extensions extensions;

    public ActivityDefinition build() {

        final DefaultActivityDefinition definition = new DefaultActivityDefinition();
        definition.setName(name);
        definition.setDescription(description);

        definition.setType(type);
        definition.setMoreInfo(moreInfo);
        definition.setExtensions(extensions);

        return definition;
    }

    public ActivityDefinitionBuilder name(LanguageMap name) {
        this.name = name;
        return this;
    }

    public ActivityDefinitionBuilder description(LanguageMap description) {
        this.description = description;
        return this;
    }

    public ActivityDefinitionBuilder type(InternationalizedResourceIdentifier type) {
        this.type = type;
        return this;
    }

    public ActivityDefinitionBuilder moreInfo(InternationalizedResourceLocator moreInfo) {
        this.moreInfo = moreInfo;
        return this;
    }

    public ActivityDefinitionBuilder extensions(Extensions extensions) {
        this.extensions = extensions;
        return this;
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
