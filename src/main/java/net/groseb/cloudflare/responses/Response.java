package net.groseb.cloudflare.responses;

import net.groseb.cloudflare.Error;

public class Response {
    public boolean success;
    public Error[] errors;
    public String[] messages;
}
