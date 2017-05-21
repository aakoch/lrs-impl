package com.adamkoch.lrs;

import com.adamkoch.lrs.api.InternationalizedResourceIdentifier;

/**
 * <p>Created by aakoch on 2017-05-20.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class IriFactory {
    public static InternationalizedResourceIdentifier of(String id) {
        return new InternationalizedResourceIdentifier() {
            @Override
            public String toString() {
                return id;
            }
        };
    }
}
