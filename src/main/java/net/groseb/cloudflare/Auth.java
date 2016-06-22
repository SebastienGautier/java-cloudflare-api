package net.groseb.cloudflare;

class Auth {
    private String email;
    private String APIKey;

    Auth(String email, String APIKey) {
        this.email = email;
        this.APIKey = APIKey;
    }

    String getEmail() {
        return email;
    }

    String getAPIKey() {
        return APIKey;
    }
}
