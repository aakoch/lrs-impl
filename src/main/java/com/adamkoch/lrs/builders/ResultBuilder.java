package com.adamkoch.lrs.builders;

import com.adamkoch.lrs.api.LrsObject;
import com.adamkoch.lrs.NotYetImplementedException;
import com.adamkoch.lrs.api.Result;
import com.adamkoch.lrs.api.Score;

import java.time.Duration;

/**
 * <a href=""></a>
 *
 * <p>Created by aakoch on 2017-03-23.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class ResultBuilder {
    public Result build() {
        return new Result() {
            @Override
            public Score getScore() {
                throw new NotYetImplementedException();
            }

            @Override
            public Boolean getSuccess() {
                throw new NotYetImplementedException();
            }

            @Override
            public Boolean getCompletion() {
                throw new NotYetImplementedException();
            }

            @Override
            public String getResponse() {
                throw new NotYetImplementedException();
            }

            @Override
            public Duration getDuration() {
                throw new NotYetImplementedException();
            }

            @Override
            public LrsObject getExtensions() {
                throw new NotYetImplementedException();
            }
        };
    }
}
