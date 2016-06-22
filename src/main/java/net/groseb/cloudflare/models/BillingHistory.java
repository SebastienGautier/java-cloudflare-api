package net.groseb.cloudflare.models;

import java.util.Date;

public class BillingHistory {
    public String id;
    public String type;
    public String action;
    public String description;
    public Date occurred_at;
    public float amount;
    public String currency;
    public Zone zone;
}
