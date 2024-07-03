package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

/**
 * Controlador para gestionar las solicitudes de consulta de saldo.
 * Este servlet maneja las peticiones POST para consultar el saldo de la cuenta de un usuario.
 */
@WebServlet("/saldo")
public class SaldoController extends HttpServlet {

    private UserService usuarioService = new UserService();

    /**
     * Maneja la solicitud POST para consultar el saldo.
     * Este método recupera el email del usuario desde la solicitud,
     * consulta el saldo utilizando el servicio de usuario, y redirige al usuario
     * a la página de saldo con la información del saldo actual.
     *
     * @param request La solicitud HTTP que contiene el email del usuario.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error específico del servlet.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        double saldo = usuarioService.obtenerSaldo(email);

        request.setAttribute("saldo", saldo);

        request.getRequestDispatcher("saldo.jsp").forward(request, response);
    }
}