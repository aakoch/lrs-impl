package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;
import com.adamkoch.lrs.builders.*;
import com.adamkoch.lrs.factories.ActivityDefinitionFactory;
import com.adamkoch.lrs.factories.IriFactory;
import com.adamkoch.lrs.factories.IrlFactory;
import com.adamkoch.lrs.factories.MailToIriFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FromJsonTest.class);

    public static Statement convertToStatement(JsonObject jsonObject) {
        String id = jsonObject.getString("id");
        LOGGER.debug("id = " + id);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(jsonObject.getString("timestamp"));

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        LOGGER.debug("localDateTime = " + localDateTime);

        Actor actor = convertToActor(jsonObject.getJsonObject("actor"));

        Verb verb = convertToVerb(jsonObject.getJsonObject("verb"));

        LrsObject object = convertToObject(jsonObject.getJsonObject("object"));

        JsonObject resultJsonObject = jsonObject.getJsonObject("result");
        Result result = new ResultBuilder().build();

        JsonObject contextJsonObject = jsonObject.getJsonObject("context");
        Context context = new ContextBuilder().build();

        Authority authority;
        if (jsonObject.containsKey("authority")) {
            authority = createAuthority(jsonObject);
        }
        else {
            authority = null;
        }


        final LocalDateTime storedLocalDateTime;
        if (jsonObject.containsKey("stored")) {
            final String stored = jsonObject.getString("stored");
            ZonedDateTime zonedDateTimeStored = ZonedDateTime.parse(stored);
            storedLocalDateTime = zonedDateTimeStored.toLocalDateTime();
        } else {
            storedLocalDateTime = null;
        }

        final String version;
        if (jsonObject.containsKey("version")) {
            version = jsonObject.getString("version");
        } else {
            version = null;
        }

        Statement statement = new StatementBuilder()
                .id(StatementId.of(id))
                .timestamp(localDateTime)
                .actor(actor)
                .verb(verb)
                .object(object)
                .result(result)
                .context(context)
                .stored(storedLocalDateTime)
                .authority(authority)
                .version(version)
                .build();

        LOGGER.debug("jsonObject = " + jsonObject);
        return statement;
    }

    private static Authority createAuthority(JsonObject jsonObject) {
        Authority authority;
        JsonObject authorityJsonObject = jsonObject.getJsonObject("authority");
        final String authorityObjectType = authorityJsonObject.getString("objectType");

        if (authorityObjectType.equals(ObjectType.AGENT.toString())) {
            // the authority is an Agent
            // an agent has an ID
            // the ID is an account, or mailbox, etc
        }
        else if (authorityObjectType.equals(ObjectType.GROUP.toString())) {
            // the authority is a Group
            // can the group be anonymous?
        }

        if (authorityJsonObject.containsKey("account")) {
            final JsonObject jsonAccount = authorityJsonObject.getJsonObject("account");
            JsonAccount account = new JsonAccount();
            account.setName(jsonAccount.getString("name"));
            account.setHomePage(IrlFactory.of(jsonAccount.getString("homePage")));
            authority = new AuthorityBuilder().objectType(ObjectType.of(authorityObjectType))
                                              .id(IdCreator.from(account))
                                              .build();
        }
        else {
            authority = null;
        }

        return authority;
    }

    private static LrsObject convertToObject(JsonObject objectJsonObject) {
        return new ObjectBuilder()
                .id(objectJsonObject.getString("id"))
                .definition(createDefinition(objectJsonObject.getJsonObject("definition")))
                .build();
    }

    private static ActivityDefinition createDefinition(JsonObject jsonObject) {
        ActivityDefinition definition = ActivityDefinitionFactory.of(jsonObject);
        return definition;
    }

    private static Verb convertToVerb(JsonObject verbJsonObject) {
        final InternationalizedResourceIdentifier id = IriFactory.of(verbJsonObject.getString("id"));
        return new VerbBuilder()
                .display(new LanguageMapBuilder().of(verbJsonObject.getJsonObject("display")))
                .id(id)
                .build();
    }

    public static Actor convertToActor(JsonObject actorJsonObject) {

        return new ActorBuilder()
                .name(actorJsonObject.getString("name"))
                .type(actorJsonObject.getString("objectType"))
                .id(actorJsonObject.getString("mbox"))
                .build();
    }

    public static Authority convertToAuthority(JsonObject jsonObject) {
        InverseFunctionalIdentifier id;
        if (isAccount(jsonObject)) {
            Account account = new AccountBuilder().build();
            id = IdCreator.from(account);
        }
        else {
            id = null;
        }
        return new AuthorityBuilder().objectType(ObjectType.of(jsonObject.getString("objectType"))).id(id).build();
    }

    private static boolean isAccount(JsonObject jsonObject) {
        return true;
    }

    public static Group convertToGroup(JsonObject jsonObject) {
        Group group = null;
        if (jsonObject.containsKey("mbox")) {

            final Collection<Agent> members;
            if (jsonObject.containsKey("member")) {
                members = createMembers(jsonObject.getJsonArray("member"));
            }
            else {
                members = Collections.emptyList();
            }
            String name = jsonObject.getString("name");
            InverseFunctionalIdentifier id = IdCreator.from(MailToIriFactory.of(jsonObject.getString("mbox")));
            group = new IdentifiedGroupBuilder().members(members)
                                                .name(name)
                                                .id(id)
                                                .build();
        }
        return group;
    }

    private static List<Agent> createMembers(JsonArray members) {
        List<Agent> membersList = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            final JsonObject jsonObject = members.getJsonObject(i);
            membersList.add(convertToAgent(jsonObject));
        }

        return membersList;
    }

    private static Agent convertToAgent(JsonObject jsonObject) {
        AgentBuilder builder = new AgentBuilder()
                .name(jsonObject.getString("name"))
                .mbox(MailToIriFactory.of(jsonObject.getString("mbox")));
        return builder.build();
    }
}
