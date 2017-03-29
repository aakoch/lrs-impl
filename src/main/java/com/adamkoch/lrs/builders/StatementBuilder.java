package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.*;
import com.adamkoch.lrs.Statement;
import com.adamkoch.lrs.api.*;

import java.time.LocalDateTime;

/**
 * Use to build a {@link Statement}.
 *
 * <p>Created by aakoch on 2017-03-11.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class StatementBuilder {

    private StatementId statementId;
    private LocalDateTime localDateTime;
    private Actor actor;
    private Verb verb;
    private LrsObject object;
    private Result result;
    private Context context;
    private LocalDateTime storedLocalDateTime;
    private Authority authority;
    private String version;

    public Statement build() {
        if (actor == null) {
            throw new IllegalArgumentException("Actor is required");
        }
        if (object == null) {
            throw new IllegalArgumentException("Object is required");
        }
        if (verb == null) {
            throw new IllegalArgumentException("Verb is required");
        }
        Statement statement = new Statement();
        statement.setStatementId(statementId);
        statement.setTimestamp(localDateTime);
        statement.setActor(actor);
        statement.setVerb(verb);
        statement.setObject(object);
        statement.setResult(result);
        statement.setContext(context);
        statement.setStored(storedLocalDateTime);
        statement.setAuthority(authority);
        statement.setVersion(version);
        return statement;
    }

    public StatementBuilder id(StatementId statementId) {
        this.statementId = statementId;
        return this;
    }

    public StatementBuilder timestamp(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;

        return this;
    }

    public StatementBuilder actor(Actor actor) {
        this.actor = actor;
        return this;
    }

    public StatementBuilder verb(Verb verb) {
        this.verb = verb;
        return this;
    }

    public StatementBuilder object(LrsObject object) {
        this.object = object;
        return this;
    }

    public StatementBuilder result(Result result) {
        this.result = result;
        return this;
    }

    public StatementBuilder context(Context context) {
        this.context = context;
        return this;
    }

    public StatementBuilder stored(LocalDateTime storedLocalDateTime) {
        this.storedLocalDateTime = storedLocalDateTime;
        return this;
    }

    public StatementBuilder authority(Authority authority) {
        this.authority = authority;
        return this;
    }

    public StatementBuilder version(String version) {
        this.version = version;
        return this;
    }
}
