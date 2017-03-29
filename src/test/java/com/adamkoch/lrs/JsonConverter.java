package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;
import com.adamkoch.lrs.builders.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.JsonObject;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * <a href=""></a>
 *
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

        Actor actor = convertToActor(jsonObject);

        JsonObject verbJsonObject = jsonObject.getJsonObject("verb");
        Verb verb = new VerbBuilder().build();

        JsonObject objectJsonObject = jsonObject.getJsonObject("object");
        LrsObject object = new ObjectBuilder().build();

        JsonObject resultJsonObject = jsonObject.getJsonObject("result");
        Result result = new ResultBuilder().build();

        JsonObject contextJsonObject = jsonObject.getJsonObject("context");
        Context context = new ContextBuilder().build();

        JsonObject authorityJsonObject = jsonObject.getJsonObject("authority");
        Authority authority = new AuthorityBuilder().build();


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

    public static Actor convertToActor(JsonObject actorJsonObject) {

        return new ActorBuilder()
                .name(actorJsonObject.getString("name"))
                .type(actorJsonObject.getString("objectType"))
                .mbox(actorJsonObject.getString("mbox"))
                .build();
    }
}
