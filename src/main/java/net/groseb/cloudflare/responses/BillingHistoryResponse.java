package net.groseb.cloudflare.responses;

import net.groseb.cloudflare.models.BillingHistory;

public class BillingHistoryResponse extends PaginatedResponse {
    public BillingHistory[] result;
}
