package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class novoCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastrar um novo cliente</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <sec:authorize access=\"hasRole('ADMIN')\">\n");
      out.write("                <form action=\"novoCliente\">\n");
      out.write("            <fieldset>\n");
      out.write("\n");
      out.write("                <!-- Form Name -->\n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.nome == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> <legend>Novo Cliente</legend> </c:if>\n");
      out.write("                \n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"id\">ID</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"id\" name=\"id\" type=\"hidden\" placeholder=\"ID\" class=\"form-control input-md\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                </c:if>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"nome\">Nome</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"nome\" name=\"nome\" type=\"text\" placeholder=\"Nome\" class=\"form-control input-md\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"email\">Email</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"email\" name=\"email\" type=\"text\" placeholder=\"Email\" class=\"form-control input-md\" required=\"\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Password input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"senha\">Senha</label>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"senha\" name=\"senha\" type=\"password\" placeholder=\"senha\" class=\"form-control input-md\" required=\"\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"cpf\">CPF</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"cpf\" name=\"cpf\" type=\"text\" placeholder=\"CPF\" class=\"form-control input-md\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.cpf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Multiple Radios -->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"sexo\">Sexo</label>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <div class=\"radio\">\n");
      out.write("                            <label for=\"sexo-0\">\n");
      out.write("                                <input type=\"radio\" name=\"sexo\" id=\"sexo-0\" value=\"M\" checked=\"checked\">\n");
      out.write("                                Masculino\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"radio\">\n");
      out.write("                            <label for=\"sexo-1\">\n");
      out.write("                                <input type=\"radio\" name=\"sexo\" id=\"sexo-1\" value=\"F\">\n");
      out.write("                                Feminino\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"telefone\">Telefone</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"telefone\" name=\"telefone\" type=\"text\" placeholder=\"Telefone\" class=\"form-control input-md\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.telefone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"nascimento\">Nascimento</label>  \n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <input id=\"nascimento\" name=\"nascimento\" type=\"date\" placeholder=\"Nascimento\" class=\"form-control input-md\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.nascimento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <!-- Button -->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"submit\"></label>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <button id=\"submit\" type=\"submit\" name=\"submit\" class=\"btn btn-primary\">Salvar</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("            </sec:authorize>\n");
      out.write("<br>\n");
      out.write("            <a href=\"http://localhost:8080/Sistema-para-locacao-de-bicicletas/admin/verCliente\">Voltar</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
