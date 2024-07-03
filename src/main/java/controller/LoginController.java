package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

/**
 * Controlador para gestionar las solicitudes de inicio de sesión.
 * Este servlet maneja las peticiones POST para el inicio de sesión de los usuarios,
 * verificando sus credenciales y redirigiéndolos según el resultado de la verificación.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    /**
     * Maneja la solicitud POST para el inicio de sesión.
     * Este método recupera el email y la contraseña del usuario desde la solicitud,
     * verifica las credenciales utilizando el servicio de usuario, y redirige al usuario
     * a la página del menú si la autenticación es exitosa, o de lo contrario, a la página de inicio con un mensaje de error.
     *
     * @param request La solicitud HTTP que contiene el email y la contraseña del usuario.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error específico del servlet.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userService.verificarUsuario(email, password)) {
            response.sendRedirect("menu.jsp");
        } else {
            response.sendRedirect("index.jsp?error=true");
        }
    }
}
