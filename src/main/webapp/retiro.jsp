<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles.css" />
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
  <body class="vh-100">
    <nav class="navbar navbar-expand-lg bg-light shadow">
      <div class="container-fluid">
        <a class="navbar-brand" href="../index.html">
          <i class="bi bi-bank"></i
        ></a>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarTogglerDemo02"
          aria-controls="navbarTogglerDemo02"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="./deposito.jsp"
                >Depositar</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/retiro.jsp">Retirar dinero</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./saldo.jsp"
                >Saldo contable</a
              >
            </li>
          </ul>
          <div class="d-flex">
            <a href="../login.html" class="navbar-brand"
              ><i class="bi bi-person-circle"></i
            ></a>
          </div>
        </div>
      </div>
    </nav>
    <div class="container bg-light bg-gradiente rounded p-5 mt-5 shadow">
      <h2 class="text-center text-primary">Retiro de dinero</h2>
       <form action="retiro" method="post">
        <div class="form-group">
        <label for="amount">Email:</label>
          <input
            type="text"
            name= "email"
            value=""
            class="form-control mt-2"
            id="email"
            placeholder="Enter name"
          />
          <label for="amount" class= "mt-2">Monto a Retirar:</label>
          <input
            type="number"
            name="monto"
            class="form-control mt-2"
            id="amount"
            placeholder="Enter amount"
          />
        </div>
        <button type="submit" value="Retirar" class="btn btn-primary mt-3">
          Realizar Retiro
        </button>
      </form>
      <a href="./index.jsp" class="btn btn-secondary mt-3"
        >Volver al Menú Principal</a
      >
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>