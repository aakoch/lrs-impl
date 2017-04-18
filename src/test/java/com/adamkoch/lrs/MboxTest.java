package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Mbox;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * <p>Created by aakoch on 2017-04-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class MboxTest {

    @Test
    public void testCaseInsensitiveDomain() {
        Mbox mbox1 = MboxFactory.of("mailto:test@example.com");
        Mbox mbox2 = MboxFactory.of("mailto:test@EXAMPLE.com");
        assertNotNull(mbox1);
        assertNotNull(mbox2);
        assertNotNull(mbox1.getSha1Sum());
        assertNotNull(mbox2.getSha1Sum());
        assertEquals(mbox1.getSha1Sum(), mbox2.getSha1Sum());
    }
}
