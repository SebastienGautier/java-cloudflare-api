import net.groseb.cloudflare.Cloudflare;
import net.groseb.cloudflare.exception.CloudflareException;
import net.groseb.cloudflare.models.BillingHistory;
import net.groseb.cloudflare.models.BillingProfile;
import net.groseb.cloudflare.models.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CloudflareKeyTest {

    private Cloudflare cloudflare;

    @Before
    public void init() {
        String email = System.getenv("CLOUFLARE_EMAIL");
        String key = System.getenv("CLOUFLARE_KEY");
        cloudflare = new Cloudflare(email, key);
    }

    @Test
    public void userTest() {
        try {
            User user = cloudflare.user();
        } catch (IOException | CloudflareException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void billingProfileTest() {
        try {
            BillingProfile billingProfile = cloudflare.billingProfile();
        } catch (IOException | CloudflareException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void billingHistoryTest() {
        try {
            BillingHistory[] billingHistory = cloudflare.billingHistory();
        } catch (IOException | CloudflareException e) {
            e.printStackTrace();
        }
    }
}
