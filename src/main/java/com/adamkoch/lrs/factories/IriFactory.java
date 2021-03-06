package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;

/**
 * <p>Created by aakoch on 2017-05-20.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IriFactory {
    public static InternationalizedResourceIdentifier of(String id) {
        return new DefaultInternationalizedResourceIdentifier(id);
    }

    private static class DefaultInternationalizedResourceIdentifier implements InternationalizedResourceIdentifier {
        private final String id;

        public DefaultInternationalizedResourceIdentifier(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DefaultInternationalizedResourceIdentifier that = (DefaultInternationalizedResourceIdentifier) o;

            return id != null ? id.equals(that.id) : that.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}
