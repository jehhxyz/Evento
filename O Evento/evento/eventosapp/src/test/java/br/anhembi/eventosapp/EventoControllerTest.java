package br.anhembi.eventosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.anhembi.eventosapp.controller.EventoController;
import br.anhembi.eventosapp.model.Evento;
import br.anhembi.eventosapp.repository.EventoRepo;

class EventoControllerTest {

    @InjectMocks
    private EventoController eventoController;

    @Mock
    private EventoRepo eventoRepo;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarEventoComSucesso() {
        Evento evento = new Evento();
        evento.setNome("Show Post Malone");
        evento.setData("2025-05-06");
        evento.setLocal("Nova York, EUA");
        evento.setHorario("21:00");

        when(bindingResult.hasErrors()).thenReturn(false);

        String resultado = eventoController.form(evento, bindingResult, redirectAttributes);

        verify(eventoRepo, times(1)).save(evento);
        verify(redirectAttributes, times(1)).addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        assertEquals("redirect:/cadastrarEvento", resultado);
    }

    @Test
    void deveRetornarErroQuandoDadosSaoInvalidos() {
        Evento evento = new Evento();
        when(bindingResult.hasErrors()).thenReturn(true);

        String resultado = eventoController.form(evento, bindingResult, redirectAttributes);

        verify(eventoRepo, never()).save(any(Evento.class));
        verify(redirectAttributes, times(1)).addFlashAttribute("mensagem", "Verifique os campos!");
        assertEquals("redirect:/cadastrarEvento", resultado);
    }

}
