/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locacao;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pedro
 */
@WebServlet(name="Nova Locacao Servlet", urlPatterns = {"/user/novaLocacao"})
public class NovaLocacaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            LocacaoDAO locacaoDAO = new LocacaoDAO();
            ClienteDAO clienteDAO = new ClienteDAO();
            LocadoraDAO locadoraDAO = new LocadoraDAO();
            
            Locacao locacao = new Locacao();
            locacao.setCpfclienteId(clienteDAO.getCpf(request.getParameter("cpf")));
            if(locadoraDAO.getCnpj(request.getParameter("cnpj")) == null){
                request.setAttribute("mensagem", "CNPJ Invalido");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            locacao.setCnpjlocadoraId(locadoraDAO.getCnpj(request.getParameter("cnpj")));
            locacao.setDataHora( java.sql.Date.valueOf(request.getParameter("data")));
            
            locacaoDAO.save(locacao);
            request.setAttribute("mensagem", "Locacao adicionado!");
            response.sendRedirect("verLocacoesCliente");
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

