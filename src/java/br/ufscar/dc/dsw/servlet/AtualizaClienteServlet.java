/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pedro
 */
@WebServlet(name = "Atualiza Cliente Servlet", urlPatterns = {"/admin/atualziaCliente"})
public class AtualizaClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            HttpSession session = request.getSession();
//            Cliente cliente2 = (Cliente) session.getAttribute("cliente");
            
            Cliente cliente = new Cliente();
            cliente.setEmail(request.getParameter("email"));
            cliente.setSenha( encoder.encode(request.getParameter("senha")));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setSexo(request.getParameter("sexo"));
            cliente.setNascimento(java.sql.Date.valueOf(request.getParameter("nascimento")));
           
            int id = Integer.parseInt(request.getParameter("id"));
            clienteDAO.update(cliente,id);
            
            request.setAttribute("mensagem", "Cliente atualizado!");
            response.sendRedirect("verCliente");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
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
