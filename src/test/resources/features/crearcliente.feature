Feature: Realizar registro de cliente nuevo
  Yo como QA Engineer
  Quiero poder realizar el registro de un cliente nuevo
  Para poder utilizar diferentes practicas de pruebas correctamente

  Background:
    Given abre la plataforma de Siigo
    And se loguea con usuario y contrasena

  Scenario Outline: Realizar la creacion de un cliente (E2E)
    When ingresa al modulo de crear clientes
    And digita los datos para realizar el registro del cliente nuevo
      | Tipo   | Nombre   | Apellido   | Identificacion   | Ciudad   | NombreContacto   |
      | <Tipo> | <Nombre> | <Apellido> | <Identificacion> | <Ciudad> | <NombreContacto> |
    Then validar la creacion del cliente
    And identificar tecnica utilizada "<Tecnica>"

    Examples:
      | Tipo       | Nombre  | Apellido | Identificacion  | Ciudad | NombreContacto | Tecnica                         |
      | Es persona | Chris   | Galvis   | 98765           | Bogotá | QAPrueba       | Particion equivalencia valida   |
      | Es persona | ChrisQA |          | 12345           | Bogota | QAPrueba       | Particion equivalencia valida   |
      | Es persona |         | Galvis   | 98765           | Bogota | QAPrueba       | Particion equivalencia invalida |
      | Es persona | Chris   |          | 98765           | Bogota | QAPrueba       | Particion equivalencia invalida |
      | Es persona | Chris   | Galvis   | QA1234          | Bogota | QAPrueba       | Tabla decision invalida         |
      | Es persona | Chris   |          | QA1234QATEST    | Bogota | QAPrueba       | Tabla decision valida           |
      | Es persona | Chris   | Galvis   | 12              | Bogota | QAPrueba       | Valores limite invalida         |
      | Es persona | Chris   | Galvis   | 987654321012345 | Bogota | QAPrueba       | valores limite invalida         |