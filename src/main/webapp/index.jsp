<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <title>Wallet - Login</title>
  </head>
  <body>
    <div class="container vh-100 d-flex">
      <div class="row w-100 align-items-center justify-content-center">
        <div class="col-md-6 text-center text-md-start">
          <h1 class="text-primary display-2">
            Alke-Wallet
            <a class="navbar-brand" href="./index.html"
              ><i class="bi bi-bank"></i
            ></a>
          </h1>
          <p class="text-secondary fw-bold lead">
            Todas tus movimientos de dinero en un solo lugar
          </p>
        </div>
        <div class="col-md-6">
          <div class="bg-light rounded-3 p-5 shadow">
            <form action="login" method="post">
              <h3 class="text-secondary text-center mb-4">Inicio de sesión</h3>
              <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input
                  type="email"
                  class="form-control"
                  id="email"
                  name="email"
                  placeholder="Ingrese su email"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Contraseña:</label>
                <input
                  type="password"
                  class="form-control"
                  id="password"
                  name="password"
                  placeholder="Ingrese su contraseña"
                  required
                />
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-primary">
                  Iniciar sesión
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <footer class="text-white bg-dark bg-gradient">
      <div class="container py-4">
        <div class="row">
          <div class="col-lg-6 col-md-8 mx-auto text-center">
            <h5 class="text-uppercase mb-4">Síguenos</h5>
            <a href="https://twitter.com" class="text-white me-4"
              ><i class="bi bi-twitter"></i
            ></a>
            <a href="https://facebook.com" class="text-white me-4"
              ><i class="bi bi-facebook"></i
            ></a>
            <a href="https://instagram.com" class="text-white"
              ><i class="bi bi-instagram"></i
            ></a>
          </div>
        </div>
        <div class="row">
          <div class="col-12 text-center mt-1">
            <p>
              ¿Tienes preguntas?
              <a href="mailto:support@alkewallet.com" class="text-reset"
                >Contáctanos</a
              >
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col-12 text-center mt-1">
            <p>© 2024 Alke Wallet. Todos los derechos reservados.</p>
          </div>
        </div>
      </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>