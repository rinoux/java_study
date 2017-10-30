package com.fr.decision.staticres;

/**
 * storage身份认证
 *
 */
public abstract class Authentication {
    private String accessURL;
    private String authenticUser;
    private String password;

    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }

    public void setAuthenticUser(String authenticUser) {
        this.authenticUser = authenticUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessURL() {
        return accessURL;
    }

    public String getAuthenticUser() {
        return authenticUser;
    }

    public String getPassword() {
        return password;
    }

    public abstract void readConfig();
}
