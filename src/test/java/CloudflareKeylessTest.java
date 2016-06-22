import net.groseb.cloudflare.Cloudflare;
import net.groseb.cloudflare.exception.CloudflareException;
import net.groseb.cloudflare.models.Ips;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CloudflareKeylessTest {

    private Cloudflare cloudflare;

    @Before
    public void init() {
        cloudflare = new Cloudflare();
    }

    @Test
    public void apisTest() {
        try {
            Ips ips = cloudflare.ips();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CloudflareException e) {
            e.printStackTrace();
        }
    }
}
