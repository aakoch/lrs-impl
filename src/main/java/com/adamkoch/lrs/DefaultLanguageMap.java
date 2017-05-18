package com.adamkoch.lrs;

import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.api.LanguageTag;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <p>Created by aakoch on 2017-05-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DefaultLanguageMap implements LanguageMap {

    Map<LanguageTag, String> map = new HashMap<>();

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
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(LanguageTag key, String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends LanguageTag, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<LanguageTag> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<String> values() {
        return map.values();
    }

    @Override
    public Set<Entry<LanguageTag, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return map.equals(o);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public String getOrDefault(Object key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super LanguageTag, ? super String> action) {
        map.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super LanguageTag, ? super String, ? extends String> function) {
        map.replaceAll(function);
    }

    @Override
    public String putIfAbsent(LanguageTag key, String value) {
        return map.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return map.remove(key, value);
    }

    @Override
    public boolean replace(LanguageTag key, String oldValue, String newValue) {
        return map.replace(key, oldValue, newValue);
    }

    @Override
    public String replace(LanguageTag key, String value) {
        return map.replace(key, value);
    }

    @Override
    public String computeIfAbsent(LanguageTag key, Function<? super LanguageTag, ? extends String> mappingFunction) {
        return map.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public String computeIfPresent(LanguageTag key, BiFunction<? super LanguageTag, ? super String, ? extends String> remappingFunction) {
        return map.computeIfPresent(key, remappingFunction);
    }

    @Override
    public String compute(LanguageTag key, BiFunction<? super LanguageTag, ? super String, ? extends String> remappingFunction) {
        return map.compute(key, remappingFunction);
    }

    @Override
    public String merge(LanguageTag key, String value, BiFunction<? super String, ? super String, ? extends String> remappingFunction) {
        return map.merge(key, value, remappingFunction);
    }

}
