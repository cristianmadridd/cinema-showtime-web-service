/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Helio
 */
@WebService(serviceName = "CinemaWebService")
public class CinemaWebService {

    /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "buscarPorHorario")
    public ArrayList buscarPorHorario(@WebParam(name = "cidade") String cidade, @WebParam(name = "horario") String horario) {
        //TODO write your implementation code here:
        
        //String codfonte = Util.recuperarCodigoFonte(getURL(cidade));
        
        return Util.parseURL(getURL(cidade));
        
        
        //TESTE geração do resultado
//        ArrayList<ArrayList> resultado = new ArrayList<ArrayList>(); //lista de cinemas
//        ArrayList<HashMap> cinema1 = new ArrayList<HashMap>(); //lista de filmes, 
//        //cada filme contém varias informações indexadas em uma HashSet
//        HashMap<String,String> filme2 = new HashMap<String, String>();
//        filme2.put("titulo", "planeta dos macacos");
//        cinema1.add(filme2);
//        resultado.add(cinema1);
//        return "teste";
        
        //return null;
    }
    
    private String getURL(String cidade){
        return "http://www.google.com.br/movies?hl=pt-BR&near="+cidade.replaceAll(" ", "+");
    }
}
