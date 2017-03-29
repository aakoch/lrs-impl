package com.adamkoch.lrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by aakoch on 2017-03-11.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class StatementsControllerTest extends JerseyTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(StatementsController.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the responses.
     */
    @Test
    public void testPlainText() {
        final String responseMsg = target().path("statements").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("Hello, Heroku!", responseMsg);

    }

    /**
     * Test to see that the message "{}" is sent in the responses.
     */
    @Test
    public void testJson() {
        final String responseMsg = target().path("statements").request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{}", responseMsg);
    }

    /**
     * The LRS MUST include the "X-Experience-API-Version" header in every response.
     */
    @Test
    public void testXApiVersionHeader() {
        final Response responseMsg = target().path("statements").request(MediaType.APPLICATION_JSON).get(Response.class);
        assertEquals("1.0.3", responseMsg.getHeaderString("X-Experience-API-Version"));
    }
}
