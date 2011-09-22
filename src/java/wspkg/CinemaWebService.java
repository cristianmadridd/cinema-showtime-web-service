/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Helio
 */
@WebService(serviceName = "CinemaWebService")
public class CinemaWebService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "buscarPorHorario")
    public ArrayList buscarPorHorario(@WebParam(name = "cidade") String cidade, @WebParam(name = "horario") String horario) throws ParseException {
        //este é nosso web service
       
        //XMLAdapt
        ArrayList retorno = Util.parseURL(getURL(cidade), horario);
        //Adapters.XCollection xmlresult =  Adapters.xmlizeNestedCollection(retorno);
        //return xmlresult;
        
        return retorno;
  
    }
    
    private String getURL(String cidade){
        return "http://www.google.com.br/movies?hl=pt-BR&near="+cidade;
    }
}
