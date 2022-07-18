package sandbox;

import org.springframework.beans.factory.annotation.Value;

public class TokenResponse {
    private String token;

    private TokenResponse() {
    }

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
