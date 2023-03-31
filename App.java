

import java.io.InputStream;

import java.net.URL;



import java.util.List;
import java.util.Map;





public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        

        // Fazer uma conexão HTTP e buscar os filmes 
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        

       //  String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
       // var extrator = new ExtratatorDeConteudoDaNasa();

         var http = new ClienteHttp();
         String json = http.buscaDados(url);

          
        
        

        // Selecionar os dados com alguns atributos especificos (titulo, poster e classificação)
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json); 
        
        
        

        var geradora = new GeradoraDeFigurinhas();

        // Exibir e manipular os dados do jeito que eu quiser.
       for (int i = 0; i <10; i++){
         Conteudo conteudo = conteudos.get(i) ;
            

            
            
            //float rate = String.format( "%.2f", (filme.get("ImdbRating")));
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            
            String nomeArquivo =  conteudo.getTitulo() + ".png";
            
            geradora.cria(inputStream, nomeArquivo);
            
            System.out.println(conteudo.getTitulo());
        //    System.out.println(filme.get( "image"));
        //    System.out.println(filme.get( "imDbRating"));
            
            System.out.println( );
            
        }





    }
}