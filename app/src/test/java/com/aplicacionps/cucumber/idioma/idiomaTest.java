package com.aplicacionps.cucumber.idioma;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class idiomaTest {
    String message;
    @Given("^que estoy en la pantalla de ajustes$")
    public void que_estoy_en_la_pantalla_de_ajustes() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de idioma$")
    public void hago_click_sobre_el_botn_de_idioma() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^la bandera del botón se actualiza$")
    public void la_bandera_del_botn_se_actualiza() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }

}
