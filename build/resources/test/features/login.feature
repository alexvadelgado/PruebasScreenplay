#Author: Alexander Valencia Delgado #Language: en

Feature: Autenticacion en OrangeHRM
  Como usuario del sistema OrangeHRM
  Quiero poder iniciar sesion con mis credenciales
  Para acceder al dashboard del sistema

  Scenario: Login exitoso con credenciales válidas
    Given que estoy en la pagina de login de OrangeHRM
    When ingreso el usuario "Admin" y la contrasena "admin123"
    And hago clic en el boton "Login"
    Then debo estar autenticado y ver el dashboard
    And debo ver el nombre de usuario en la esquina superior derecha

  Scenario: Visualizacion del panel de busqueda de permisos en el dashboard
    Given que el usuario ha iniciado sesion exitosamente en OrangeHRM
    When navega al modulo "Leave" desde el menu lateral
    Then deberia visualizar el panel de busqueda de solicitudes de permisos
