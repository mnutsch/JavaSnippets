import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.UUID;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
 
public class OneHttpExample {
 
  public static void main(String[] args) throws Exception {
    // Replace the following with appropriate values for your usecase:
    String userName = "USERNAMEGOESHERE";
    String password = "PASSWORDGOESHERE";
    String baseUrl = "https://rn9999.onenetwork.com";
    String queueName = "inbox/VC";
    String inboundQueueEnterpriseName = "My Company Name";
    String sender = "My Company Name";
    String itf = "TMS.ShipmentInboundInterface";
    String itfVer = "1.0";
    String id = UUID.randomUUID().toString();
    String content = "PAYLOAD GOES HERE (e.g. CSV or XML content)";
 
    // The remaining code will leverage the parameters above to issue an HTTP Request to ONE
 
    String url = String.format(
        "%s/oms/rest/queue/enqueue?QueueName=%s&InboundQueueEnterpriseName=%s&Sender=%s&Id=%s&InboundInterface=%s&InboundInterfaceVersion=%s",
        baseUrl,
        URLEncoder.encode(queueName, "UTF-8"),
        URLEncoder.encode(inboundQueueEnterpriseName, "UTF-8"),
        URLEncoder.encode(sender, "UTF-8"),
        URLEncoder.encode(id, "UTF-8"),
        URLEncoder.encode(itf, "UTF-8"),
        URLEncoder.encode(itfVer, "UTF-8")
        );
 
    System.out.println("Posting to " + url);
    HttpClient client = HttpClients.createDefault();
    HttpPost post = new HttpPost(url);
    post.setEntity(new ByteArrayEntity(content.getBytes()));
    post.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((userName + ":" + password).getBytes()));
    HttpResponse response = client.execute(post);
 
    System.out.println("HTTP Status: " + response.getStatusLine().getStatusCode());
 
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    response.getEntity().writeTo(out);
 
    System.out.println("Response Body: " + new String(out.toByteArray()));
  }
 
}