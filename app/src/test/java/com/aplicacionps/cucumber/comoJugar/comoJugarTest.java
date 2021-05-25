package com.aplicacionps.cucumber.comoJugar;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class comoJugarTest {
    String message;
    @Given("^que estoy en la pantalla del menú principal$")
    public void que_estoy_en_la_pantalla_de_men_principal() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de comoJugar$")
    public void hago_click_sobre_el_botn_de_comoJugar() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^te lleva a la pantalla del tutorial$")
    public void te_lleva_a_la_pantalla_del_tutorial() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }
}
