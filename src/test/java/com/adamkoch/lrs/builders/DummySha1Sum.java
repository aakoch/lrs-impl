package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.Sha1Sum;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-05-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class DummySha1Sum implements Sha1Sum {
    private final String sha1sum;

    public DummySha1Sum(String sha1sum) {

        this.sha1sum = sha1sum;
    }
}
