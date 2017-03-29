package com.adamkoch.lrs;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aakoch on 2017-03-11.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class StatementIdTest {

    @Test(expected = IllegalArgumentException.class)
    public void testOf_withInvalidStatementId_throwsIllegalArgumentException() throws Exception {
        StatementId.of("a");
    }

    @Test
    public void testOf_withValidStatementId() throws Exception {
        String uuidAsString = "fd41c918-b88b-4b20-a0a5-a4c32391aaa0";
        StatementId statementId = StatementId.of(uuidAsString);
        Assert.assertThat(statementId, CoreMatchers.instanceOf(StatementId.class));
        Assert.assertThat(statementId.toString(), CoreMatchers.equalTo(uuidAsString));
    }

}