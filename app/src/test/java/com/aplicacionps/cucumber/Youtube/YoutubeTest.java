package com.aplicacionps.cucumber.Youtube;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.junit.Assert;


public class YoutubeTest {
    String message;
    @Given("^estoy en el menú principal$")
    public void que_estoy_en_el_men_principal() throws Throwable {
        System.out.println("El usuario esta en el menu principal");
    }

    @When("^hago click sobre el botón de youtube$")
    public void hago_click_sobre_el_botn_de_youtube() throws Throwable {
        message = "Esto es una prueba";
    }

    @Then("^soy redirigido al vídeo$")
    public void soy_redirigido_al_vdeo() throws Throwable {
        Assert.assertEquals("Esto es una prueba",message);
    }

}