package nl.hva.web.workshops.restaurant.jwt;

import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;


public class JWTUtils {

    private static final String PASSPHRASE = "Het beste groepje van aquadis heeft deze hele mooie lange tekst verzonnen. Zou dit genoeg zijn voor een GO? Om dit password nog meer beveiligd te maken staat dit stukje tekst er nog even achter.";

    public static Key getKey() {
        byte hmacKey[] = PASSPHRASE.getBytes(StandardCharsets.UTF_8);
        Key key = new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
        return key;
    }


}
