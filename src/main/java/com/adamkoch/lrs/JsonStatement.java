package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#20-statements">Statement</a>.
 *
 * <p>"Statements are the evidence for any sort of experience or event which is to be tracked in xAPI. While Statements
 * follow a machine readable JSON format, they can also easily be described using natural language. This can be
 * extremely useful for the design process. Statements are meant to be aggregated and analyzed to provide larger meaning
 * for the overall experience than just the sum of its parts."</p>
 *
 * <p>Created by aakoch on 2017-03-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonStatement implements Statement, JsonSerializable {

    private StatementId statementId;

    private LocalDateTime timestamp;

    /**
     * A Statement MUST use "actor", "verb", and "object".
     */
    private Actor actor;

    /**
     * A Statement MUST use "actor", "verb", and "object".
     *
     * Valid values are: Activity, Agent, Group, SubStatement or StatementRef
     */
    private LrsObject object;

    private Result result;

    private Context context;

    /**
     * Set by LRS.
     */
    private LocalDateTime stored;

    private Authority authority;

    private Collection attachments;


    /**
     * A Statement MUST use "actor", "verb", and "object".
     */
    private com.adamkoch.lrs.api.Verb verb;

    /**
     * Not recommended
     */
    private String version;


    /**
     * ID is an exception to the immutability rule.
     */
    public void setStatementId(StatementId statementId) {
        this.statementId = statementId;
    }

    @Override
    public StatementId getId() {
        return statementId;
    }

    /**
     * Timestamp is an exception to the immutability rule.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public Actor getActor() {
        return actor;
    }

    @Override
    public LrsObject getObject() {
        return object;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setObject(LrsObject object) {
        this.object = object;
    }

    @Override
    public com.adamkoch.lrs.api.Verb getVerb() {
        return verb;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setVerb(com.adamkoch.lrs.api.Verb verb) {
        this.verb = verb;
    }

    @Override
    public Result getResult() {
        return result;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public Context getContext() {
        return context;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Authority getAuthority() {
        return authority;
    }

    /**
     * Authority is an exception to the immutability rule.
     */
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getVersion() {
        return version;
    }

    /**
     * Version is an exception to the immutability rule.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public LocalDateTime getStored() {
        return stored;
    }

    /**
     * Stored is an exception to the immutability rule.
     */
    public void setStored(LocalDateTime stored) {
        this.stored = stored;
    }

    @Override
    public Collection getAttachments() {
        return attachments;
    }

    /**
     * Attachments are an exception to the immutability rule.
     */
    public void setAttachments(Collection attachments) {
        this.attachments = attachments;
    }

    /**
     * There are a number of scenarios outlined in this specification which require Statements to be compared to see if
     * they match. In these scenarios, the following rules apply:
     *
     * Differences which could have been caused by exceptions to Statement immutability MUST be ignored. Differences
     * relating to a different serialization of any properties not listed as exceptions MUST not be ignored.
     */
    @Override
    public boolean equals(Object o) {
        // TODO: equals method does not yet conform to Javadoc statement
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JsonStatement statement = (JsonStatement) o;

        if (statementId == null ? statement.statementId != null : !statementId.equals(statement.statementId))
            return false;
        if (timestamp == null ? statement.timestamp != null : !timestamp.equals(statement.timestamp)) return false;
        if (actor == null ? statement.actor != null : !actor.equals(statement.actor)) return false;
        if (object == null ? statement.object != null : !object.equals(statement.object)) return false;
        if (result == null ? statement.result != null : !result.equals(statement.result)) return false;
        if (context == null ? statement.context != null : !context.equals(statement.context)) return false;
        if (stored == null ? statement.stored != null : !stored.equals(statement.stored)) return false;
        if (authority == null ? statement.authority != null : !authority.equals(statement.authority)) return false;
        if (attachments == null ? statement.attachments != null : !attachments.equals(statement.attachments))
            return false;
        if (verb == null ? statement.verb != null : !verb.equals(statement.verb)) return false;
        return version == null ? statement.version == null : version.equals(statement.version);
    }

    /**
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        // TODO: hashCode method does not yet conform to Javadoc statement
        int result1 = statementId != null ? statementId.hashCode() : 0;
        result1 = 31 * result1 + (timestamp != null ? timestamp.hashCode() : 0);
        result1 = 31 * result1 + (actor != null ? actor.hashCode() : 0);
        result1 = 31 * result1 + (object != null ? object.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (context != null ? context.hashCode() : 0);
        result1 = 31 * result1 + (stored != null ? stored.hashCode() : 0);
        result1 = 31 * result1 + (authority != null ? authority.hashCode() : 0);
        result1 = 31 * result1 + (attachments != null ? attachments.hashCode() : 0);
        result1 = 31 * result1 + (verb != null ? verb.hashCode() : 0);
        result1 = 31 * result1 + (version != null ? version.hashCode() : 0);
        return result1;
    }

    public String toJson() {
        JsonObject object = toJson(Json.createObjectBuilder());

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(object);
        jsonWriter.close();

        return stringWriter.toString();
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        JsonObject object = builder
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .add("address", Json.createObjectBuilder()
                        .add("streetAddress", "21 2nd Street")
                        .add("city", "New York")
                        .add("state", "NY")
                        .add("postalCode", "10021"))
                .add("phoneNumber", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "212 555-1234"))
                        .add(Json.createObjectBuilder()
                                .add("type", "fax")
                                .add("number", "646 555-4567")))
                .build();

        return object;
    }
}
