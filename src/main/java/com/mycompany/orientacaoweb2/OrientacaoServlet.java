package com.mycompany.orientacaoweb2;

import com.mycompany.orientacaoweb2.dao.OrientacaoDAO;
import com.mycompany.orientacaoweb2.dao.ProfessorDAO;
import com.mycompany.orientacaoweb2.model.Orientacao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.orientacaoweb2.model.Professor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadOrientacao", urlPatterns = {"/CadOrientacao"})
public class OrientacaoServlet extends HttpServlet {
    
    OrientacaoDAO oriDao = new OrientacaoDAO(); 
    ProfessorDAO profDao = new ProfessorDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("nome");
        
        if(session.getAttribute("nome") == null) {
            response.sendRedirect("/login");
            return;
        }
        
        ArrayList<Professor> prof = new ArrayList<>();      
        try {
            prof = profDao.listarTodos();
        } catch (Exception ex) {
            Logger.getLogger(OrientacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        request.setAttribute("objetoRecebido", prof);
        request.getRequestDispatcher("CadastroOrientacao.jsp").forward(request, response);  
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Orientacao orientacao = new Orientacao();
        
        String descricaoOrientacao = request.getParameter("descricaoOrientacao");
        String option = request.getParameter("option");
        String msg = "";
        String msgCampos = "";
        
        String orientadoOrientacao = request.getParameter("orientadoOrientacao");
   
                
        orientacao.setDescricaoOrientacao(descricaoOrientacao);
        orientacao.setOrientadoOrientacao(orientadoOrientacao);
        orientacao.getProfessor().setIdProfessor(Integer.parseInt(option));
        if(descricaoOrientacao.equals("") || orientadoOrientacao.equals("") || option.equals("")){
            msgCampos = "Campo 'Descrição' ou campo 'Orientado' ou campo 'Selecione um professor' não foram devidamente preenchidos";
            
        }else{

            
            try {
                oriDao.inserir(orientacao);
                msg = "Orientação inserida com sucesso.";
            } catch (Exception ex) {
                msg = "Não foi possível inserir orientação.";
                Logger.getLogger(OrientacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        request.setAttribute("msgSucesso", msg);
        request.setAttribute("msgCampos", msgCampos);
        request.getRequestDispatcher("CadastroOrientacao.jsp").forward(request, response); 
 
     }
}