package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.Account;
import com.adamkoch.lrs.api.InternationalizedResourceLocator;
import com.adamkoch.lrs.api.ObjectType;

import java.util.Optional;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-30.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class AccountBuilder {
    public Account build() {
        return new InnerAccount();
    }

    private class InnerAccount implements Account {
        @Override
        public InternationalizedResourceLocator getHomePage() {
            throw new NotYetImplementedException();
        }

        @Override
        public String getName() {
            throw new NotYetImplementedException();
        }

        @Override
        public Optional<ObjectType> getObjectType() {
            throw new NotYetImplementedException();
        }
    }
}
