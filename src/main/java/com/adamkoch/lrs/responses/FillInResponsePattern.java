package com.adamkoch.lrs.responses;

import com.adamkoch.lrs.api.InteractionType;
import com.adamkoch.lrs.api.ResponsePattern;

/**
 * <p>Created by aakoch on 2017-03-22.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class FillInResponsePattern implements ResponsePattern {
    @Override
    public InteractionType getInteractionType() {
        return InteractionType.FILL_IN;
    }
}
