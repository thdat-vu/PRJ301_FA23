/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private final String PAGE_LOGIN = "login.html";
    private final String LOGIN_CONTROLLER = "LoginServlet";//cai nay copy tu web.xml -> <servlet-name>
    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastnameServlet";//cai nay copy trong class SearchLastnameServlet -> @WebServlet -> url-pattern

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String url = PAGE_LOGIN;

        //1. Xac dinh user se click button cua Login hay Search
        //tao bien String luu value cua parameter btAction
        

        response.setContentType("text/html;charset=UTF-8");
        
        String button = request.getParameter("btAction");
        //luon check truoc gia  tri button co bang null hay ko
        try {
            if (button == null) {
                out.print(button);
                //day la noi ma moi vao trong login, 
                //nen la button luc nay ko co value
            } else if (button.equals("Login")) { //neu value cua button == Login nhu trong login.html
                //khai bao 1 bien la LOGIN_CONTROLLER di
                //neu value.equals "Login" thi chuyen duong dan ve class LoginServlet xu ly.
                //buoc so 1 tao view
                //buoc so 2 map tinh nang moi vao trong dieu phoi
                url = LOGIN_CONTROLLER;
                out.println(url);
                out.print(request.toString());

            } else if (button.equals("Search")) {
                //di len khai bao SEARCH_LASTNAME_CONTROLLER
                //neu value.equals "Search" thi chuyen ve class SearchLastNameServlet xu ly' 
                url = SEARCH_LASTNAME_CONTROLLER;
                out.println(url);
                out.print(request.toString());
                //buoc so 3: tao servlet chuc nang
            }

        } finally {
            //tu nay ve sau dung dieu phoi dispatcher.
            //TAT CA MOI THU PHAI QUA THANG DIEU PHOI
            //tao requestDispatcher -> lay url giu do'
            RequestDispatcher rd = request.getRequestDispatcher(url);
            out.print(url);
            //sau do forward(req, resps)
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
