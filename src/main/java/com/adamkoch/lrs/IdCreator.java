package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InverseFunctionalIdentifier;

import java.util.UUID;

/**
 * First pass at creating something that can create IDs. I haven't read the specs of the InverseFunctionalIdentifier
 * lately so this is just using UUID for now.
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IdCreator {

    public static InverseFunctionalIdentifier create() {
        return new DefaultId();
    }

    public static InverseFunctionalIdentifier from(UUID uuid) {
        return new DefaultId(uuid);
    }

    private static class DefaultId implements InverseFunctionalIdentifier {
        private final UUID id;

        public DefaultId() {
            id = UUID.randomUUID();
        }

        public DefaultId(UUID uuid) {
            id = uuid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DefaultId defaultId = (DefaultId) o;

            return id == null ? defaultId.id == null : id.equals(defaultId.id);
        }

        @Override
        public int hashCode() {
            return id == null ? 0 : id.hashCode();
        }
    }
}
