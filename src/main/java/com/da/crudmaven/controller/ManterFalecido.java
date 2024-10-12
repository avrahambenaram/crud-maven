package com.da.crudmaven.controller;

import com.da.crudmaven.dao.FalecidoDAO;
import com.da.crudmaven.model.Falecido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ManterFalecido", urlPatterns = {"/ManterFalecido"})
public class ManterFalecido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            String resultado = "";

            if (op.equals("CADASTRAR")) {
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                String dataNascText = request.getParameter("dataNasc");
                String nacionalidade = request.getParameter("nacionalidade");
                String dataMorteText = request.getParameter("dataMorte");
                float peso = Float.parseFloat(request.getParameter("peso"));
                float altura = Float.parseFloat(request.getParameter("altura"));
                String convenio = request.getParameter("convenio");
                String salaVelorio = request.getParameter("salaVelorio");
                String doacaoText = request.getParameter("doacao");
                String cremacaoText = request.getParameter("cremacao");
                Date dataNasc = new Date(dataNascText);
                Date dataMorte = new Date(dataMorteText);
                Boolean doacao = false;
                Boolean cremacao = false;
                
                if (doacaoText == "true" || doacaoText == "1" || doacaoText == "Sim") {
                    doacao = true;
                }
                if (cremacaoText == "true" || cremacaoText == "1" || cremacaoText == "Sim") {
                    cremacao = true;
                }

                FalecidoDAO fdao = new FalecidoDAO();
                Falecido f = new Falecido(
                    0,
                    nome,
                    cpf,
                    dataNasc,
                    dataMorte,
                    nacionalidade,
                    peso,
                    altura,
                    convenio,
                    salaVelorio,
                    doacao,
                    cremacao
                );
                try {
                    fdao.cadastrar(f);
                    resultado = "Cadastrado com muito Sucesso.";                    
                    request.setAttribute("msg", resultado);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao cadastrar.";
                }
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                FalecidoDAO fdao = new FalecidoDAO();
                Falecido f = new Falecido();
                f.setId(id);
                try {
                    fdao.deletar(f);
                    List<Falecido> lfalecidos = fdao.consultarTodos();
                    request.setAttribute("lfalecidos", lfalecidos);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao deletar.";
                }
            } else if (op.equals("CONSULTARBYID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                FalecidoDAO fdao = new FalecidoDAO();
                Falecido f = new Falecido();
                f.setId(id);
                try {
                    f = fdao.consultarById(f);
                    request.setAttribute("falecido", f);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao consultar por ID.";
                }
            } else if (op.equals("CONSULTARTODOS")) {
                FalecidoDAO fdao = new FalecidoDAO();
                try {
                    List<Falecido> lfalecidos = fdao.consultarTodos();
                    request.setAttribute("lfalecidos", lfalecidos);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao consultar todos.";
                }
            } else if (op.equals("ATUALIZAR")) {
                String nome = request.getParameter("txtnome");
                String dataFalecimento = request.getParameter("txtdatafalecimento");
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                FalecidoDAO fdao = new FalecidoDAO();
                Falecido f = new Falecido();
                f.setId(id);
                try {
                    fdao.atualizar(f);
                    resultado = "Atualizado com Sucesso.";
                    request.setAttribute("msg", resultado);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            } else if (op.equals("EDITAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                FalecidoDAO fdao = new FalecidoDAO();
                Falecido f = new Falecido();
                f.setId(id);
                try {
                    f = fdao.consultarById(f);
                    request.setAttribute("falecido", f);
                    request.getRequestDispatcher("formularioeditar.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao editar.";
                }
            } 
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}