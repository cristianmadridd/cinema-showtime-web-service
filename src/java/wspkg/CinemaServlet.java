/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.ws.WebServiceRef;
import wsclient1.CinemaWebService_Service;
import wsclient1.ParseException_Exception;

/**
 *
 * @author Helio
 */
public class CinemaServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/cinema-webservice/CinemaWebService.wsdl")
    private CinemaWebService_Service service;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CinemaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CinemaServlet at " + request.getContextPath () + "</h1>");
            
//            String cidade = request.getParameter("cidade");
//            String horario = request.getParameter("horario");
            String cidade = "maringa";
            String horario = "20:00";
            
            List result = buscarPorHorario(cidade, horario);
            for (Object obj: result){
                
                out.println("Nome do cinema: "+((HashMap)obj).get("name"));
                
            }
            
            
            out.println("</body>");
            out.println("</html>");
             
        } catch (Exception e){
            e.printStackTrace();
        
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(CinemaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(CinemaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<java.lang.Object> buscarPorHorario(java.lang.String cidade, java.lang.String horario) throws ParseException_Exception {
        wsclient1.CinemaWebService port = service.getCinemaWebServicePort();
        return port.buscarPorHorario(cidade, horario);
    }
}
