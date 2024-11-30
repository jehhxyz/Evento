package br.anhembi.eventosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.anhembi.eventosapp.controller.MenuController;

class MenuControllerTest {

    @InjectMocks
    private MenuController menuController;

    @BeforeEach
    void setUp(){
        // garante que os mocks serão inicializados corretamente
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRedirecionarParaMenuAdmin(){
        String resultado = menuController.menuAdmin();

        assertEquals("admin/menu", resultado);
    }

}
