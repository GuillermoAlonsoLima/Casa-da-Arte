/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import MB.login.loginMB;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 631510046
 */
@WebFilter(filterName = "FiltroAcesso", urlPatterns = {"/faces/index/index_admin.xhtml","/faces/index/index_usuario.xhtml"})
public class loginFiltro implements Filter {
    
    //Obtendo o objeto UsuarioMB da sessão
    @Inject 
    private loginMB loginMB;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        //Obtem o request e response para utilizacao Web
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //Se o usuário estiver logado 
        if (loginMB != null && loginMB.isLogado()) {            
            //deixa acessar o recurso
            chain.doFilter(request, response);
        } else {
            //redireciona para a página de login
            //getContextPath -> Caminho da aplicação
            resp.sendRedirect(req.getContextPath() + "/faces/login/login.xhtml");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    
}
