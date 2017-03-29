package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Agent;
import org.junit.Assert;
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

        assertEquals(StatementId.of("fd41c918-b88b-4b20-a0a5-a4c32391aaa0"), statement.getStatementId());
        assertEquals(LocalDateTime.parse("2015-11-18T12:17"), statement.getTimestamp());
        // test actor - separate test?
        Assert.assertNotNull(statement.getActor());
        // test verb - separate test?
        Assert.assertNotNull(statement.getVerb());
        // test object - separate test?
        Assert.assertNotNull(statement.getObject());
    }

    @Test
    public void testSimpleActor() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/simple_actor.json");
        Agent actor = (Agent) JsonConverter.convertToActor(jsonObject);

        assertEquals("Project Tin Can API", actor.getName());
        assertEquals("Agent", actor.getObjectType());
        assertEquals(new MboxId(MailToIriCreator.of("mailto:user@example.com")), actor.getId());
    }

    @Test
    public void testComplexStatement() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/complex_statement.json");
        Statement statement = JsonConverter.convertToStatement(jsonObject);

        assertEquals(StatementId.of("6690e6c9-3ef0-4ed3-8b37-7f3964730bee"), statement.getStatementId());
        assertEquals(LocalDateTime.parse("2013-05-18T05:32:34.804"), statement.getTimestamp());
        // test actor - separate test?
        Assert.assertNotNull(statement.getActor());
        // test verb - separate test?
        Assert.assertNotNull(statement.getVerb());
        // test result - separate test?
        Assert.assertNotNull(statement.getResult());
        // test context - separate test?
        Assert.assertNotNull(statement.getContext());
        // test stored
        assertEquals(LocalDateTime.parse("2013-05-18T05:32:34.804"), statement.getStored());
        // test authority - separate test?
        Assert.assertNotNull(statement.getAuthority());
        // test version
        assertEquals("1.0.0", statement.getVersion());
        // test object - separate test?
        Assert.assertNotNull(statement.getObject());
    }

    private JsonObject readFromFileToJsonObject(String filename) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        assert is != null;

        JsonReader jsonReader = Json.createReader(is);
        return jsonReader.readObject();
    }

}
