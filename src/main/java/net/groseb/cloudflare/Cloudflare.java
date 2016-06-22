package net.groseb.cloudflare;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.groseb.cloudflare.exception.CloudflareException;
import net.groseb.cloudflare.models.BillingHistory;
import net.groseb.cloudflare.models.BillingProfile;
import net.groseb.cloudflare.models.Ips;
import net.groseb.cloudflare.models.User;
import net.groseb.cloudflare.responses.BillingHistoryResponse;
import net.groseb.cloudflare.responses.BillingProfileResponse;
import net.groseb.cloudflare.responses.IpsResponse;
import net.groseb.cloudflare.responses.UserResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cloudflare {
    private String endpoint = "https://api.cloudflare.com/client/v4/";
    private Auth auth = null;

    public Cloudflare() {

    }

    public Cloudflare(String email, String APIKey) {
        this.auth = new Auth(email, APIKey);
    }

    public Cloudflare(String email, String APIKey, String endpoint) {
        this.auth = new Auth(email, APIKey);
        this.endpoint = endpoint;
    }

    private InputStream callAPI(String path) throws CloudflareException, IOException {
        String uri = endpoint + path;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (auth != null) {
            connection.setRequestProperty("X-Auth-Email", auth.getEmail());
            connection.setRequestProperty("X-Auth-Key", auth.getAPIKey());
        }

        InputStream is = null;
        try {
            is = connection.getInputStream();
        } catch (IOException ioe) {
            int statusCode = connection.getResponseCode();
            if (statusCode != 200) {
                is = connection.getErrorStream();
            }
        }

        if (is == null) {
            throw new CloudflareException("Error");
        }

        return is;
    }

    public Ips ips() throws IOException, CloudflareException {
        InputStream is = callAPI("ips");

        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        IpsResponse response = gson.fromJson(reader, IpsResponse.class);
        return response.result;
    }

    public User user() throws IOException, CloudflareException {
        InputStream is = callAPI("user");

        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        UserResponse response = gson.fromJson(reader, UserResponse.class);
        return response.result;
    }

    public BillingProfile billingProfile() throws IOException, CloudflareException {
        InputStream is = callAPI("user/billing/profile");

        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        BillingProfileResponse response = gson.fromJson(reader, BillingProfileResponse.class);
        return response.result;
    }

    public BillingHistory[] billingHistory() throws IOException, CloudflareException {
        InputStream is = callAPI("user/billing/history");

        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        BillingHistoryResponse response = gson.fromJson(reader, BillingHistoryResponse.class);
        return response.result;
    }
}
