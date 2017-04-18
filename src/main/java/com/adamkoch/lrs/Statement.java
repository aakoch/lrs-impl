package com.adamkoch.lrs;

import com.adamkoch.lrs.api.*;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#20-statements">Statement</a>.
 *
 * <p>Created by aakoch on 2017-03-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Statement implements com.adamkoch.lrs.api.Statement {

    private StatementId statementId;

    private LocalDateTime timestamp;

    private Actor actor;

    /**
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

    private com.adamkoch.lrs.api.Verb verb;

    /**
     * Not recommended
     */
    private String version;

    public void setStatementId(StatementId statementId) {
        this.statementId = statementId;
    }

    public StatementId getId() {
        return statementId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public LrsObject getObject() {
        return object;
    }

    public void setObject(LrsObject object) {
        this.object = object;
    }

    public com.adamkoch.lrs.api.Verb getVerb() {
        return verb;
    }

    public void setVerb(com.adamkoch.lrs.api.Verb verb) {
        this.verb = verb;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getStored() {
        return stored;
    }

    public void setStored(LocalDateTime stored) {
        this.stored = stored;
    }
}
