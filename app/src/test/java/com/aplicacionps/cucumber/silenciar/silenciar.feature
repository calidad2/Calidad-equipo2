Feature: silenciar aplicación

  Scenario: Un botón para silenciar el audio de la aplicación

    Given que estoy en la pantalla de ajustes

    When hago click sobre el botón de silenciar

    Then el audio de la aplicación se silencia