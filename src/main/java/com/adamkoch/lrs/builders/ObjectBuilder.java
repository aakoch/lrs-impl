package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.*;
import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.ActivityObject;
import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.LrsObject;

/**
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ObjectBuilder {
    public LrsObject build() {
        return new JsonActivityObject();
    }
}
