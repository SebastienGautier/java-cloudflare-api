package net.groseb.cloudflare.models;

import java.util.Date;

public class User {
    public String id;
    public String email;
    public String first_name;
    public String last_name;
    public String username;
    public String telephone;
    public String country;
    public String zipcode;
    public Date created_on;
    public Date modified_on;
    public boolean two_factor_authentication_enabled;
}
