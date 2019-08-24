package com.infoshare.alpha.wwr.servlet.validators;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.security.AccessControlException;
import java.util.Collections;

public class IdTokenValidator {

    private static final String GOOGLE_CLIENT_ID = "674333452690-oqakalh87637ojol3g6h1383aeppqvot.apps.googleusercontent.com";

    public static GoogleIdToken.Payload getPayload(String tokenString) throws Exception {

        JacksonFactory jacksonFactory = new JacksonFactory();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jacksonFactory)
                .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID)).build();


        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);
        boolean tokenIsValid = (token != null) && verifier.verify(token);

        if (tokenIsValid) {
            GoogleIdToken.Payload payload = token.getPayload();


            if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
                throw new IllegalArgumentException("Audience mismatch");
            } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
                throw new IllegalArgumentException("Client ID mismatch");
            }
            return payload;
        } else {
            throw new AccessControlException("id token cannot be verified");
        }
    }
}


