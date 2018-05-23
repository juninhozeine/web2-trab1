package com.mycompany.orientacaoweb2;
import com.mycompany.orientacaoweb2.dao.OrientacaoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.orientacaoweb2.model.Orientacao;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/lista")
public class ListagemServlet extends HttpServlet {
    
    OrientacaoDAO oriDao = new OrientacaoDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.getAttribute("nome");
        
        if(session.getAttribute("nome") == null) {
            response.sendRedirect("/login");
            return;
        }
        
        String inputNome = request.getParameter("inputNome");
        String msgCampos = "";
        ArrayList<Orientacao> arrays = new ArrayList<>();
        
        if(inputNome.equals("")){
            msgCampos = "Campo 'Pesquise o professor' obrigatório";
        }else{        
            
            try {
                arrays = oriDao.listar(inputNome);
            } catch (Exception ex) {
                Logger.getLogger(OrientacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        request.setAttribute("orientacoes", arrays);
        request.setAttribute("msgCampos", msgCampos);
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
}