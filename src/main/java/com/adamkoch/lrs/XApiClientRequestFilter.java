package com.adamkoch.lrs;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * <a href="https://jax-rs-spec.java.net/nonav/2.0/apidocs/javax/ws/rs/client/ClientRequestFilter.html">ClientRequestFilter</a>
 *
 * <p>Created by aakoch on 2017-03-28.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
@Provider
public class XApiClientRequestFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("X-Experience-API-Version", "1.0.3");
    }
}
