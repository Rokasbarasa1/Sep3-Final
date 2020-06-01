package clientNetworking;


import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class HTTPHandler {
    private ResteasyClient client;
    private ResteasyWebTarget target;

    public HTTPHandler() {
    }

    public String postToAPI(String json, String URL) {
        Response response;
        try{
            client = new ResteasyClientBuilder().build();
            target = client.target(URL);
            response = target.request().post(Entity.entity(json, "application/json"));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
        } catch (ProcessingException e){
            e.printStackTrace();
            return "Server not responding";
        }
        return response.readEntity(String.class);
    }

    public String getFromAPI(String URL){
        String value = "";
        try{
            client = new ResteasyClientBuilder().build();
            target = client.target(URL);

            Response response = target.request().get();
            value = response.readEntity(String.class);
            System.out.println(value);

        } catch (ProcessingException e){
            e.fillInStackTrace();
            return "Server not responding";
        }
        return value;
    }

    public void deleteFromAPI(String URL) {
        Response response;
        try {
            client = new ResteasyClientBuilder().build();
            target = client.target(URL);
            response = target.request().delete();
            System.out.println(response.readEntity(String.class));
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }
}
