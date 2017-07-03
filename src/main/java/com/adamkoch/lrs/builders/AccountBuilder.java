package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.Account;
import com.adamkoch.lrs.api.InternationalizedResourceLocator;
import com.adamkoch.lrs.api.ObjectType;
import com.adamkoch.lrs.factories.IrlFactory;

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
    private String name;
    private String homePage;

    public Account build() {
        final InnerAccount account = new InnerAccount();
        account.setName(name);
        account.setHomePage(IrlFactory.of(homePage));
        return account;
    }

    public AccountBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder homePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    private class InnerAccount implements Account {
        private String name;
        private InternationalizedResourceLocator homePage;

        @Override
        public InternationalizedResourceLocator getHomePage() {
            return homePage;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Optional<ObjectType> getObjectType() {
            return Optional.of(ObjectType.AGENT);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHomePage(InternationalizedResourceLocator homePage) {
            this.homePage = homePage;
        }
    }
}
