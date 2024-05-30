package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/saldo")
public class SaldoController extends HttpServlet {

    private UserService usuarioService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        double saldo = usuarioService.obtenerSaldo(email);

        request.setAttribute("saldo", saldo);

        request.getRequestDispatcher("saldo.jsp").forward(request, response);
    }
}