package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.api.InternationalizedResourceLocator;

/**
 *
 * <p>Created by aakoch on 2017-05-30.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IrlFactory {
    public static InternationalizedResourceLocator of(String irl) {
        return new DefaultInternationalizedResourceLocator(irl);
    }

    private static class DefaultInternationalizedResourceLocator implements InternationalizedResourceLocator {
        private final String id;

        public DefaultInternationalizedResourceLocator(String id) {
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

            DefaultInternationalizedResourceLocator that = (DefaultInternationalizedResourceLocator) o;

            return id != null ? id.equals(that.id) : that.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}
