package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;
import com.adamkoch.lrs.factories.IriFactory;
import com.adamkoch.lrs.factories.IrlFactory;
import com.adamkoch.lrs.factories.LanguageTagFactory;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by aakoch on 2017-03-22.
 *
 * @author aakoch
 * @since 1.0.0
 */
public class FromJsonTest {

    @Test
    public void testAuthorityAccount() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/authority_account.json");
        Authority authority = JsonConverter.convertToAuthority(jsonObject);
        assertNotNull(authority);
        assertEquals(ObjectType.AGENT, authority.getObjectType().get());
        assertTrue(authority.getId().getAccount().isPresent());

        // TODO: maybe create another authority as a group
    }

    @Test
    public void testGroup() {
        JsonObject jsonObject = readFromFileToJsonObject("examples/complex_group.json");
        Group group = JsonConverter.convertToGroup(jsonObject);
        assertNotNull(group);
        assertEquals(3, group.getMember().size());
    }

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
        final Authority authority = statement.getAuthority();
        assertNotNull(authority);
        assertEquals(ObjectType.AGENT, authority.getObjectType().get());

//        Actor agent = (Actor) authority;
//
//        final InverseFunctionalIdentifier agentId = agent.getId();
//        assertNotNull(agentId);
//        Account agentAccount = (Account) agent;
//        assertEquals("anonymous", agentAccount.getName());

        // test version
        assertEquals("1.0.0", statement.getVersion());

        // test object - separate test?
        final Activity activity = (Activity) statement.getObject();
        assertNotNull(activity);
        assertEquals("http://www.example.com/meetings/occurances/34534", activity.getId().toString());
        assertEquals(IriFactory.of("http://www.example.com/meetings/occurances/34534"), activity.getId());
        final ActivityDefinition definition = activity.getDefinition();
        assertNotNull(definition);
        final LanguageMap nameLanguageMap = definition.getName();
        assertNotNull(nameLanguageMap);
        assertEquals("example meeting", nameLanguageMap.get(LanguageTagFactory.EN_US));
        assertEquals("example meeting", nameLanguageMap.get(LanguageTagFactory.EN_GB));
        final LanguageMap descriptionLanguageMap = definition.getDescription();
        assertEquals("An example meeting that happened on a specific occasion with certain people present.", descriptionLanguageMap.get(LanguageTagFactory.EN_US));
        assertEquals("An example meeting that happened on a specific occasion with certain people present.",
                descriptionLanguageMap.get(LanguageTagFactory.EN_GB));
        final InternationalizedResourceIdentifier definitionType = definition.getType();
        assertEquals(IriFactory.of("http://adlnet.gov/expapi/activities/meeting"), definitionType);
        final InternationalizedResourceLocator moreInfo = definition.getMoreInfo();
        assertEquals(IrlFactory.of("http://virtualmeeting.example.com/345256"), moreInfo);

        final Extensions extensions = definition.getExtensions();
        final Set<InternationalizedResourceIdentifier> extensionKeySet = extensions.keySet();
        assertEquals(1, extensionKeySet.size());
    }

    private JsonObject readFromFileToJsonObject(String filename) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        assert is != null;

        JsonReader jsonReader = Json.createReader(is);
        return jsonReader.readObject();
    }

}
