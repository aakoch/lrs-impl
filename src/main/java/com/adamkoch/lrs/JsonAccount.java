package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Account;
import com.adamkoch.lrs.api.InternationalizedResourceLocator;
import com.adamkoch.lrs.api.JsonSerializable;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Optional;

/**
 * <a href="https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#2424-account-object">Account</a>.
 *
 * <p>A user account on an existing system, such as a private system (LMS or intranet) or a public system (social
 * networking site).</p>
 *
 * <p>Created by aakoch on 2017-03-22.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class JsonAccount implements Account, JsonSerializable {
    private InternationalizedResourceLocator homePage;

    private String name;

    @Override
    public InternationalizedResourceLocator getHomePage() {
        return homePage;
    }

    public void setHomePage(InternationalizedResourceLocator homePage) {
        this.homePage = homePage;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Optional<String> getObjectType() {
        throw new NotYetImplementedException();
    }

    @Override
    public JsonObject toJson(JsonObjectBuilder builder) {
        throw new NotYetImplementedException();
    }
}
