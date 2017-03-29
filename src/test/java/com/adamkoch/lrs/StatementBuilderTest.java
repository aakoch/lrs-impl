package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.builders.ActorBuilder;
import com.adamkoch.lrs.builders.StatementBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by aakoch on 2017-03-11.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class StatementBuilderTest {

    StatementBuilder builder = new StatementBuilder();

    @Test
    public void build() throws Exception {
        Assert.assertThat(builder.build(), CoreMatchers.instanceOf(Statement.class));
    }

    @Test
    public void id() throws Exception {
        StatementId testStatementId = new StatementId(UUID.randomUUID());
        Assert.assertThat(builder.id(testStatementId).build().getStatementId(), CoreMatchers.equalTo(testStatementId));
    }

    @Test
    public void timestamp() throws Exception {
        LocalDateTime testTimestamp = LocalDateTime.now();
        Assert.assertThat(builder.timestamp(testTimestamp).build().getTimestamp(), CoreMatchers.equalTo(testTimestamp));
    }

    @Test
    public void actor() throws Exception {
        Actor testActor = new ActorBuilder().build();
        Assert.assertThat(builder.actor(testActor).build().getActor(), CoreMatchers.equalTo(testActor));
    }

}