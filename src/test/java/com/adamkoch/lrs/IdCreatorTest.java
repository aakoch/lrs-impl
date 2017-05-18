package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InverseFunctionalIdentifier;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IdCreatorTest {

    @Test
    public void testCreate() throws Exception {
        assertNotNull(IdCreator.create());
    }

    @Test
    public void testEquals() {
        UUID uuid = UUID.randomUUID();
        InverseFunctionalIdentifier id1 = IdCreator.from(uuid);
        InverseFunctionalIdentifier id2 = IdCreator.from(uuid);
        assertEquals(id1, id2);
    }

}