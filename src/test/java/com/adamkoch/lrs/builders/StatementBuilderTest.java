package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.AbstractAgent;
import com.adamkoch.lrs.JsonVerb;
import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.StatementId;
import com.adamkoch.lrs.api.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by aakoch on 2017-03-11.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class StatementBuilderTest {

    StatementBuilder builder = new StatementBuilder();

    @Test
    public void testBuild() throws Exception {
        StatementId testStatementId = StatementId.of(UUID.randomUUID().toString());
        LocalDateTime testTimestamp = LocalDateTime.now();
        Actor testActor = new ActorBuilder().type(ObjectType.AGENT.toString()).id("mailto:test@example.com").build();
        LrsObject testLrsObject = new AbstractAgent() {
            @Override
            public Optional<String> getName() {
                throw new NotYetImplementedException();
            }
        };
        Verb testVerb = new JsonVerb();

        Statement statement = builder
                .id(testStatementId)
                .actor(testActor)
                .timestamp(testTimestamp)
                .object(testLrsObject)
                .verb(testVerb)
                .build();

        assertThat(statement, instanceOf(Statement.class));
        assertThat(statement.getId(), equalTo(testStatementId));
        assertThat(statement.getTimestamp(), equalTo(testTimestamp));
        assertThat(statement.getActor(), equalTo(testActor));
        assertThat(statement.getVerb(), equalTo(testVerb));
        assertThat(statement.getObject(), equalTo(testLrsObject));
    }

}