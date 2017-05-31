package com.adamkoch.lrs.factories;

import com.adamkoch.lrs.api.Extensions;
import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Created by aakoch on 2017-05-30.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ExtensionsFactory {
    public static Extensions of(JsonObject jsonObject) {
        final DefaultExtensions extensions = new DefaultExtensions();
        for (Map.Entry<String, JsonValue> entry : jsonObject.entrySet()) {
            final String key = entry.getKey();
            InternationalizedResourceIdentifier iri = IriFactory.of(key);
            extensions.put(iri, jsonObject.getJsonObject(key));
        }
        return extensions;
    }

    private static class DefaultExtensions implements Extensions {

        private final HashMap<InternationalizedResourceIdentifier, JsonObject> map;

        private DefaultExtensions() {
            map = new HashMap<InternationalizedResourceIdentifier, JsonObject>();
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return map.containsValue(value);
        }

        @Override
        public JsonObject get(Object key) {
            return map.get(key);
        }

        @Override
        public JsonObject put(InternationalizedResourceIdentifier key, JsonObject value) {
            return map.put(key, value);
        }

        @Override
        public JsonObject remove(Object key) {
            return map.remove(key);
        }

        @Override
        public void putAll(Map<? extends InternationalizedResourceIdentifier, ? extends JsonObject> m) {
            map.putAll(m);
        }

        @Override
        public void clear() {
            map.clear();
        }

        @Override
        public Set<InternationalizedResourceIdentifier> keySet() {
            return map.keySet();
        }

        @Override
        public Collection<JsonObject> values() {
            return map.values();
        }

        @Override
        public Set<Entry<InternationalizedResourceIdentifier, JsonObject>> entrySet() {
            return map.entrySet();
        }
    }
}
