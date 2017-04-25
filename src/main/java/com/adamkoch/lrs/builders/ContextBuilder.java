package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.AbstractAgent;
import com.adamkoch.lrs.JsonContext;
import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.*;

import java.util.Map;
import java.util.UUID;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ContextBuilder {
    public Context build() {
        return new JsonContext();
    }
}
