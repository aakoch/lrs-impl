package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.*;
import com.adamkoch.lrs.api.ActivityDefinition;
import com.adamkoch.lrs.api.ActivityObject;
import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;
import com.adamkoch.lrs.api.LrsObject;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ObjectBuilder {
    public LrsObject build() {
        return new ActivityObject() {
            @Override
            public InternationalizedResourceIdentifier getId() {
                throw new NotYetImplementedException();
            }

            @Override
            public ActivityDefinition getDefinition() {
                throw new NotYetImplementedException();
            }
        };
    }
}
