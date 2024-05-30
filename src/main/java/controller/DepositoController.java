package controller;

import model.Usuario;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deposito")
public class DepositoController extends HttpServlet {

    private UserService usuarioService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        double monto = Double.parseDouble(request.getParameter("monto"));

        usuarioService.realizarDeposito(email, monto);

    
        response.sendRedirect("index.jsp");
    }
}