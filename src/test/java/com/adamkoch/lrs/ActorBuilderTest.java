package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Actor;
import com.adamkoch.lrs.api.ActorType;
import com.adamkoch.lrs.builders.ActorBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertThat(builder.type("group").build(), CoreMatchers.instanceOf(Actor.class));
    }

    @Test
    public void testBuild_withGroupType() throws Exception {
        Actor actor = builder.type("Group").build();
        Assert.assertThat(actor, CoreMatchers.instanceOf(Actor.class));
        Assert.assertThat(actor.getObjectType(), CoreMatchers.equalTo(ActorType.GROUP.toString()));
    }

    @Test
    public void testBuild_withAgentType() throws Exception {
        Actor actor = builder.type("Agent").build();
        Assert.assertThat(actor, CoreMatchers.instanceOf(Actor.class));
        Assert.assertThat(actor.getObjectType(), CoreMatchers.equalTo(ActorType.AGENT.toString()));
    }

    @Test
    public void actor() throws Exception {

    }

}