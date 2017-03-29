package com.adamkoch.lrs;

import com.adamkoch.lrs.annotations.Required;
import com.adamkoch.lrs.api.InternationalizedResourceLocator;

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
public class Account {
    /**
     * The canonical home page for the system the account is on. This is based on FOAF's accountServiceHomePage.
     */
    @Required
    private InternationalizedResourceLocator homePage;

    /**
     * The unique id or name used to log in to this account. This is based on FOAF's accountName.
     */
    @Required
    private String name;
}
