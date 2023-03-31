import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratatorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

         // Selecionar os dados com alguns atributos especificos (titulo, poster e classificação)
         var parser = new JsonParse();
         List<Map<String, String>> listaDeAtributos = parser.parse(json) ;

         List<Conteudo> conteudos= new ArrayList<>();

        // popular a lista 
        for (Map <String, String > atributos :listaDeAtributos){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url"); 
           var conteudo = new Conteudo(titulo, urlImagem);
           
           conteudos.add(conteudo);

        }

         return conteudos;
        
    }
    
}
