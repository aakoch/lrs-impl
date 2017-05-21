package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aakoch on 2017-03-22.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class FromJsonTest {

    @Test
    public void testSimpleStatement() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/simple_statement.json");

        Statement statement = JsonConverter.convertToStatement(jsonObject);

        assertEquals(StatementId.of("fd41c918-b88b-4b20-a0a5-a4c32391aaa0"), statement.getId());
        assertEquals(LocalDateTime.parse("2015-11-18T12:17"), statement.getTimestamp());
        // test actor - separate test?
        Actor actor = statement.getActor();
        assertNotNull(actor);
        assertEquals("Project Tin Can API", actor.getName().get());
        assertEquals("Agent", actor.getObjectType().get().toString());
        assertEquals("mailto:user@example.com", ((Agent) actor).getId().getMBox().get().toString());

        // test verb - separate test?
        final Verb verb = statement.getVerb();
        assertNotNull(verb);
        assertEquals("http://example.com/xapi/verbs#sent-a-statement", verb.getId().toString());
        final LanguageMap display = verb.getDisplay().get();
        assertEquals("sent", display.get(LanguageTagFactory.EN_US));

        // test object - separate test?
        final Activity lrsObject = (Activity) statement.getObject();
        assertNotNull(lrsObject);
        assertEquals("http://example.com/xapi/activity/simplestatement", lrsObject.getId().toString());
        assertEquals(IriFactory.of("http://example.com/xapi/activity/simplestatement"), lrsObject.getId());
        final ActivityDefinition definition = lrsObject.getDefinition();
        assertEquals("simple statement", definition.getName().get(LanguageTagFactory.EN_US));
        assertEquals("A simple Experience API statement. Note that the LRS does not need to have any prior information about the Actor (learner), the verb, or the Activity/object.", definition.getDescription().get(LanguageTagFactory.EN_US));
    }

    @Test
    public void testSimpleActor() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/simple_actor.json");
        Actor actor = JsonConverter.convertToActor(jsonObject);

        assertEquals("Project Tin Can API", actor.getName().get());
        assertEquals(ObjectType.AGENT, actor.getObjectType().get());
        assertEquals("mailto:user@example.com", ((Agent) actor).getId().toString());
    }

    @Test
    public void testComplexStatement() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/complex_statement.json");
        Statement statement = JsonConverter.convertToStatement(jsonObject);

        assertEquals(StatementId.of("6690e6c9-3ef0-4ed3-8b37-7f3964730bee"), statement.getId());
        assertEquals(LocalDateTime.parse("2013-05-18T05:32:34.804"), statement.getTimestamp());
        // test actor - separate test?
        assertNotNull(statement.getActor());
        // test verb - separate test?
        assertNotNull(statement.getVerb());
        // test result - separate test?
        assertNotNull(statement.getResult());
        // test context - separate test?
        assertNotNull(statement.getContext());
        // test stored
        assertEquals(LocalDateTime.parse("2013-05-18T05:32:34.804"), statement.getStored());
        // test authority - separate test?
        assertNotNull(statement.getAuthority());
        // test version
        assertEquals("1.0.0", statement.getVersion());
        // test object - separate test?
        assertNotNull(statement.getObject());
    }

    private JsonObject readFromFileToJsonObject(String filename) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        assert is != null;

        JsonReader jsonReader = Json.createReader(is);
        return jsonReader.readObject();
    }

}
