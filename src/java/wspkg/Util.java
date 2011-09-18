/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Helio
 */
public class Util {
    
    public static String recuperarCodigoFonte(String urlstr){
        
        URL url;
        String result = null;
        try {
            url = new URL(urlstr);
            InputStreamReader inputStream;
            try {
                inputStream = new InputStreamReader(url.openStream());
           
            BufferedReader reader = new BufferedReader(inputStream);

            result = "";
            String line;

            while ((line = reader.readLine()) != null) {
                result += line;
            }

            reader.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
         } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return result;
        
    }
    
    /**
     * Gera uma lsita de cinemas com todas as informações sobre os filmes, de acordo com
     * a URL do Google Movies dada.
     * 
     * //TESTADO, FUNCIONOU
     * 
     * @param urlstr
     * @return 
     */
    public static ArrayList parseURL(String urlstr){
        
        ArrayList result = new ArrayList();
        Document doc = null;
        try {
            doc = Jsoup.connect(urlstr).get();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*
         * Estrutura do HTML:
         * <div class=movie_results>
         *      <div class=theater>
         *          <div class=desc>
         *              <h2 class=name>
         *                  NOME DO CINEMA
         *              </h2>
         *              <div class=info>
         *                  ENDEREÇO E FONE
         *          <div class=showtimes>
         *              <div class=show_left>
         *                  <div class=movie>
         *                      <div class=name>
         *                          NOME DO FILME
         *                      <span class=info>
         *                          INFO SOBRE FILME
         *                      <div class=times>
         *                          HORARIOS
         *                  <REPETE para outros FILMES>
         *      <REPETE para outros CINEMAS>
         * 
         * 
         */
        
        //pega lista de divs que contém as informações sobre os cinemas
        Elements theaters = doc.select("div.theater"); 
        
        
        for (Element theater: theaters){
            
            HashMap<String, Object> theater_infos = new HashMap<String, Object>();
            
            Elements nested = theater.children();
            
            //pegar nome do cinema e endereço
            //Element desc = theater.getElementsByClass("div.desc").get(0); // nao sei se e assim, tem q testar
            Element desc = nested.get(0);
                    
            String name = desc.getElementsByClass("name").get(0).text();
            String info = desc.getElementsByClass("info").get(0).text();
            
            ArrayList movie_list = new ArrayList();
            for (Element movie: nested.get(1).child(0).children()){ //showtimes -> show_left
                
                //if (!movie.className().equals("movie")) continue; //pula o primeiro q é o desc
                String movie_name = movie.child(0).text();
                String movie_info = movie.child(1).text();
                
                ArrayList movie_times = new ArrayList();
                Element times = movie.child(2);
                for (Element time: times.children()){
                    movie_times.add(time.text());
                }
                
                HashMap<String, Object> movie_infos = new HashMap<String, Object>();
                movie_infos.put("title", movie_name);
                movie_infos.put("info", movie_info);
                movie_infos.put("times", movie_times);
                
                movie_list.add(movie_infos);
                
            }
            
            theater_infos.put("name", name);
            theater_infos.put("info", info);
            theater_infos.put("movie list", movie_list);
            
            result.add(theater_infos);
            //[...] por aí vai, tem q ir pegando as div s aninhadas e recuperando as informações
            
            
        }
        return result;
        
    }
    
}
