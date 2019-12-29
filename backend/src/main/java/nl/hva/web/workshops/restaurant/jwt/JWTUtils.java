package nl.hva.web.workshops.restaurant.jwt;

import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;


private class JWTUtils {

    private static final String PHRASE = "Het beste groepje van aquadis heeft deze hele mooie lange tekst verzonnen."
            + "Zou dit genoeg zijn voor een GO? Om dit password nog meer beveiligd te maken staat dit stukje tekst er "
            + "nog even achter.";

    public static Key getKey() {
        byte[] hmacKey = PHRASE.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
    }


}
