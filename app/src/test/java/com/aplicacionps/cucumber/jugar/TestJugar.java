package com.aplicacionps.cucumber.jugar;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestJugar {
    String message;
    @Given("^estoy en la pantalla de inicio$")
    public void estoy_en_la_pantalla_de_inicio() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de jugar$")
    public void hago_click_sobre_el_botn_de_jugar() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^te lleva a la pantalla del jugar$")
    public void te_lleva_a_la_pantalla_de_jugar() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }
}


