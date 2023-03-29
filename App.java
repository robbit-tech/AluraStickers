
import java.awt.Image;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import java.util.List;
import java.util.Map;

import javax.swing.text.Keymap;



public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        

        // Fazer uma conexão HTTP e buscar os filmes 
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address  = URI.create(url);
        // A criação da variavel serve para inferir o tipo, remover a repetição de declaração.
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
         HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       
        
       

        // Selecionar os dados com alguns atributos especificos (titulo, poster e classificação)
        var parser = new JsonParse();
        List<Map<String, String>> listadefilmes = parser.parse(body) ;
        
        // Exibir e manipular os dados do jeito que eu quiser.
        for (Map<String,String> filme : listadefilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            //float rate = String.format( "%.2f", (filme.get("ImdbRating")));
            InputStream inputStream = new URL(urlImagem).openStream();
            
            
            
            String nomeArquivo = titulo + ".png";
            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);
            
            System.out.println(filme.get( "title"));
        //    System.out.println(filme.get( "image"));
        //    System.out.println(filme.get( "imDbRating"));
            
            System.out.println( );
            
        }





    }
}