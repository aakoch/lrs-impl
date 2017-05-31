package com.adamkoch.lrs;

import com.adamkoch.lrs.api.LanguageMap;
import com.adamkoch.lrs.factories.LanguageTagFactory;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>Created by aakoch on 2017-05-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class VoidTest {
    @Test
    public void testGetId() throws Exception {
        assertEquals("http://adlnet.gov/expapi/verbs/voided", Void.INSTANCE.getId().toString());
    }

    @Test
    public void testGetDisplay() throws Exception {
        final Optional<LanguageMap> display = Void.INSTANCE.getDisplay();
        assertTrue(display.isPresent());
        final LanguageMap languageMap = display.get();
        assertEquals("voided", languageMap.get(LanguageTagFactory.of("en-US")));
    }

}