/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.JDBCUtil;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet(name="Novo Cliente Servlet", urlPatterns = {"/admin/novoCliente"})
public class NovoClienteServlet extends HttpServlet {
    
    ClienteDAO clienteDAO = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            Cliente cliente = new Cliente();
            cliente.setEmail(request.getParameter("email"));
            cliente.setSenha( encoder.encode(request.getParameter("senha")));
            cliente.setCpf( request.getParameter("cpf"));
            cliente.setNome( request.getParameter("nome"));
            cliente.setTelefone( request.getParameter("telefone"));
            cliente.setSexo( request.getParameter("sexo"));
            cliente.setNascimento( java.sql.Date.valueOf(request.getParameter("nascimento")));
            
            clienteDAO.save(cliente);
            request.setAttribute("mensagem", "Cliente adicionado!");
            response.sendRedirect("verCliente");
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getLocalizedMessage().contains("A instrução foi interrompida, porque iria gerar um valor duplicado da chave em uma restrição de chave primária ou de unicidade identificada por 'SQL190416092129610' definida em 'CLIENTE'.")) {
                request.setAttribute("mensagem", "O cpf do cliente que você está tentando cadastrar já foi utilziado");
            } else {
                request.setAttribute("mensagem", e.getLocalizedMessage());
            }
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

