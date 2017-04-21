package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;

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
public class Statement implements com.adamkoch.lrs.api.Statement {

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

    public StatementId getId() {
        return statementId;
    }

    /**
     * Timestamp is an exception to the immutability rule.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public LrsObject getObject() {
        return object;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setObject(LrsObject object) {
        this.object = object;
    }

    public com.adamkoch.lrs.api.Verb getVerb() {
        return verb;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setVerb(com.adamkoch.lrs.api.Verb verb) {
        this.verb = verb;
    }

    public Result getResult() {
        return result;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setResult(Result result) {
        this.result = result;
    }

    public Context getContext() {
        return context;
    }

    /**
     * Does the immutability rule mean there should be no setter?
     */
    public void setContext(Context context) {
        this.context = context;
    }

    public Authority getAuthority() {
        return authority;
    }

    /**
     * Authority is an exception to the immutability rule.
     */
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getVersion() {
        return version;
    }

    /**
     * Version is an exception to the immutability rule.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getStored() {
        return stored;
    }

    /**
     * Stored is an exception to the immutability rule.
     */
    public void setStored(LocalDateTime stored) {
        this.stored = stored;
    }

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

        Statement statement = (Statement) o;

        if (statementId != null ? !statementId.equals(statement.statementId) : statement.statementId != null)
            return false;
        if (timestamp != null ? !timestamp.equals(statement.timestamp) : statement.timestamp != null) return false;
        if (actor != null ? !actor.equals(statement.actor) : statement.actor != null) return false;
        if (object != null ? !object.equals(statement.object) : statement.object != null) return false;
        if (result != null ? !result.equals(statement.result) : statement.result != null) return false;
        if (context != null ? !context.equals(statement.context) : statement.context != null) return false;
        if (stored != null ? !stored.equals(statement.stored) : statement.stored != null) return false;
        if (authority != null ? !authority.equals(statement.authority) : statement.authority != null) return false;
        if (attachments != null ? !attachments.equals(statement.attachments) : statement.attachments != null)
            return false;
        if (verb != null ? !verb.equals(statement.verb) : statement.verb != null) return false;
        return version != null ? version.equals(statement.version) : statement.version == null;
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
}
