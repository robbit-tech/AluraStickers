import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {

    

    public String buscaDados (String url){

        try {
            URI address  = URI.create(url);
        // A criação da variavel serve para inferir o tipo, remover a repetição de declaração.
       
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
         HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       
        return body;
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }

        
    }
    
}
