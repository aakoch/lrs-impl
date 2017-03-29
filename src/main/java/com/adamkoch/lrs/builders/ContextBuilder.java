package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.Agent;
import com.adamkoch.lrs.api.Context;
import com.adamkoch.lrs.api.Group;
import com.adamkoch.lrs.api.StatementReference;

import java.util.Map;
import java.util.UUID;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ContextBuilder {
    public Context build() {
        return new Context(){
            @Override
            public UUID getRegistration() {
                throw new NotYetImplementedException();
            }

            @Override
            public Agent getInstructor() {
                throw new NotYetImplementedException();
            }

            @Override
            public Group getTeam() {
                throw new NotYetImplementedException();
            }

            @Override
            public Map getContextActivities() {
                throw new NotYetImplementedException();
            }

            @Override
            public String getRevision() {
                throw new NotYetImplementedException();
            }

            @Override
            public String getPlatform() {
                throw new NotYetImplementedException();
            }

            @Override
            public String getLanguage() {
                throw new NotYetImplementedException();
            }

            @Override
            public StatementReference getStatementReference() {
                throw new NotYetImplementedException();
            }

            @Override
            public Map getExtensions() {
                throw new NotYetImplementedException();
            }
        };
    }
}
