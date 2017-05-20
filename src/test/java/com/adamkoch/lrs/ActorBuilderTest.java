package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.api.ObjectType;
import com.adamkoch.lrs.builders.ActorBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by aakoch on 2017-03-11.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ActorBuilderTest {

    ActorBuilder builder = new ActorBuilder();

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_withMissingType_throwsIllegalArgumentException() throws Exception {
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_withInvalidActorType_throwsIllegalArgumentException() throws Exception {
        assertThat(builder.type("group").build(), instanceOf(Actor.class));
    }

    @Test
    public void testBuild_withGroupType() throws Exception {
        Actor actor = builder.type("Group").build();
        assertThat(actor, instanceOf(Actor.class));
        assertThat(actor.getObjectType().get(), equalTo(ObjectType.GROUP));
    }

    @Test
    public void testBuild_withAgentType() throws Exception {
        Actor actor = builder
                .type("Agent")
        // temporary?
                .id("test")
                .build();
        assertThat(actor, instanceOf(Actor.class));

        assertThat(actor.getObjectType().get(), equalTo(ObjectType.AGENT));
    }

    @Test
    public void actor() throws Exception {

    }

}