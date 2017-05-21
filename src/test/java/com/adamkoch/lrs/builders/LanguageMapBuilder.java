package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.DefaultLanguageMap;
import com.adamkoch.lrs.LanguageTagFactory;
import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.api.LanguageTag;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Map;

/**
 * <p>Created by aakoch on 2017-05-20.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class LanguageMapBuilder {
    public LanguageMap of(JsonObject jsonObject) {
        LanguageMap map = new DefaultLanguageMap();
        LanguageTag languageTag = null;
        for (Map.Entry<String, JsonValue> entry : jsonObject.<String, JsonValue>entrySet()) {
            String key = entry.getKey();
            languageTag = LanguageTagFactory.of(key);
            map.put(languageTag, jsonObject.getString(key));
        }

        return map;
    }
}
