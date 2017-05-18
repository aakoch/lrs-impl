package com.adamkoch.lrs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

/**
 * <p>Created by aakoch on 2017-05-10.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class LanguageTagFactoryTest {
    @Test
    public void testOf() throws Exception {
        final Locale locale = Locale.forLanguageTag("en-US");
        final Locale[] availableLocales = Locale.getAvailableLocales();
        final Locale defaultLocale = Locale.getDefault();
        System.out.println("locale = " + locale);
        System.out.println("availableLocales = " + Arrays.toString(availableLocales));
        System.out.println("defaultLocale = " + defaultLocale);

    }

}