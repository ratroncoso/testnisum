package org.rtroncoso.testnisum.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtils {

    @Value("${security.jwt.expiration.miliseconds}")
    private Long jwtTimeToLive;
    private String jwtSecret = "12125454989865653232";

    private SecretKey getSigningKey() {
        return Jwts.SIG.HS256.key().build();
    }

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .subject((username))
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtTimeToLive))
                .signWith(this.getSigningKey())
                .compact();
    }
}
