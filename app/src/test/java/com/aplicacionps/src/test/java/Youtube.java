package com.aplicacionps.src.test.java;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Cucumber.class)
public class Youtube {

    @Given("^que estoy en el menú principal $")
    public void que_estoy_en_el_men_principal() throws Throwable {
        throw new PendingException();
    }

    @When("^hago click sobre el botón de youtube $")
    public void hago_click_sobre_el_botn_de_youtube() throws Throwable {
        throw new PendingException();
    }

    @Then("^soy redirigido al vídeo $")
    public void soy_redirigido_al_vdeo() throws Throwable {
        throw new PendingException();
    }
    }