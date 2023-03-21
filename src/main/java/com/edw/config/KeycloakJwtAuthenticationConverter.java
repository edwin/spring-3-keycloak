package com.edw.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;


/**
 * <pre>
 *     com.edw.config.KeycloakJwtAuthenticationConverter
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Mar 2023 20:55
 */
@Component
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new JwtAuthenticationToken(jwt,
                new JwtGrantedAuthoritiesConverter().convert(jwt).stream().toList(),
                    jwt.getClaim(JwtClaimNames.SUB));
    }
}
