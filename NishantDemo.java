import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.net.InetAddress;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class NishantDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new NishantDemo().add();

	}
	void add () throws Exception {

		@SuppressWarnings("resource")
		TransportClient client =new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress( InetAddress.getByName("localhost"), 9300));
		XContentBuilder builder = jsonBuilder()
			    .startObject()
			        .field("name", "Prashant")
			        .field("salary", 35000)
			        .field("teamName", "Admin")
			    .endObject();
		IndexResponse response = client.prepareIndex("employee", "id", "2").setSource(builder).get();
		System.out.println(response.toString());
	}
}
