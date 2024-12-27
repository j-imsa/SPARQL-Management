package ir.jimsa.sparqlmanagement.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

@Configuration
@AllArgsConstructor
public class AppAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // key      : value
        // Username : Password
        HashMap<String, String> userDb = new HashMap<>();
        userDb.put("admin", passwordEncoder.encode("ihavethepower"));
        userDb.put("alirezaemad", passwordEncoder.encode("ihavenosecrets"));
        userDb.put("timbernerslee", passwordEncoder.encode("worldwideweb"));

        String rawPassword = userDb.get(username);
        if (rawPassword == null || !passwordEncoder.matches(password, rawPassword)) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(
                username,
                null,
                authentication.getAuthorities().stream().toList()
        );

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
