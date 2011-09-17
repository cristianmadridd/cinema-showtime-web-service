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
    
    public static ArrayList parseURL(String urlstr){
        
        ArrayList result = new ArrayList();
        Document doc = null;
        try {
            doc = Jsoup.connect(urlstr).get();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //pega lista de divs que contém as informações sobre os cinemas
        Elements theaters = doc.select("div.theater"); 
        
        
        for (Element theater: theaters){
            //pegar nome do cinema e endereço
            Element desc = theater.getElementById("div.desc"); // nao sei se e assim, tem q testar
            
            String name = desc.getElementById("name").text();
            String info = desc.getElementById("info").text();
            
            //[...] por aí vai, tem q ir pegando as div s aninhadas e recuperando as informações
            
            
        }
        
        return result;
        
    }
    
}
