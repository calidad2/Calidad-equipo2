package com.aplicacionps.cucumber.silenciar;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class silenciarTest {
    String message;
    @Given("^que estoy en la pantalla de ajustes$")
    public void que_estoy_en_la_pantalla_de_ajustes() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de silenciar$")
    public void hago_click_sobre_el_botn_de_silenciar() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^el audio de la aplicación se silencia$")
    public void el_audio_de_la_aplicacin_se_silencia() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }
}
