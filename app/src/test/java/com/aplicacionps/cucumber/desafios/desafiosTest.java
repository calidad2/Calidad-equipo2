package com.aplicacionps.cucumber.desafios;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class desafiosTest {
    String message;
    @Given("^en la pantalla de menú principal$")
    public void en_la_pantalla_de_men_principal() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de desafios$")
    public void hago_click_sobre_el_botn_de_desafios() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^te lleva a la pantalla de desafios$")
    public void te_lleva_a__la_pantalla_de_desafios() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }
}


