/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.servlet;

import datvt.registration.RegistrationDAO;
import datvt.util.DBHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class LoginServlet extends HttpServlet {
    //tat ca phai khai bao bang hang so va CHU IN HOA
    private final String SEARCH_PAGE = "search.html";
    private final String INVALID_PAGE = "invalid.html";
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
            throws ServletException, IOException { // tuyet doi ko sua dong nay
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //truyen bao nhieu Parameter thi get bao nhieu parameter
       // String username = request.getParameter("txtUsername");
        //String password = request.getParameter("password");
        String button = request.getParameter("btAction");
        String url = INVALID_PAGE;
        try {
            //in ra nhung gia tri da lay
//            out.println("Username " + username + " - " + password + " - " + button);
//            //day la dong ki thuat debug
//            //trang web ko chay ra ket qua nhung duoi console luon luon chay.
//            System.out.println("Username " + username + " - " + password + " - " + button);
//            //o day chi co try catch thoi
//            Connection conn = DBHelper.creatConnection();
//            if(conn != null){
//                out.println("Database connected");
//            }else{
//                out.print("Good night!");
//            }
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }catch(ClassNotFoundException ex){
//            ex.printStackTrace();}
            if (button.equals("Login")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("password");
                //2. call DAO
                //2.1 new DAO
                RegistrationDAO dao = new RegistrationDAO();
                //2.2 call method DAO
                boolean result = dao.checkLogin(username, password);
                //3.process
                if(result){
                    //tat ca cac trang va resource phai khai bao bang hang so
                    url = SEARCH_PAGE;
            }//end user clicked Login button
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            //4. return to browser
            response.sendRedirect(url);
            out.close();

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
