package com.aplicacionps.cucumber.Ajustes;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AjustesTest {
    String message;
    @Given("^estoy en la pantala principal$")
    public void estoy_en_la_pantala_principal() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de ajustes$")
    public void hago_click_sobre_el_botn_de_ajustes() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^te lleva a la pantalla de ajustes$")
    public void te_lleva_a_la_pantalla_de_ajustes() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }
}


