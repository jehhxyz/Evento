package br.anhembi.eventosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.anhembi.eventosapp.controller.LoginController;

class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRedirecionarParaMenuQuandoLoginForSucesso() {
        String username = "admin";
        String password = "admin";

        String resultado = loginController.login(username, password, redirectAttributes);
        assertEquals("redirect:/menu", resultado);
    }

    @Test
    void deveRedirecionarParaLoginComErroQuandoCredenciaisForemInvalidas() {
        String username = "usuarioInvalido";
        String password = "senhaErrada";

        String resultado = loginController.login(username, password, redirectAttributes);

        assertEquals("redirect:/login", resultado);

        verify(redirectAttributes, times(1)).addFlashAttribute("mensagem", "Usuário ou senha inválidos!");
    }

    @Test
    void deveRedirecionarParaLoginComErroQuandoCamposEstiveremVazios() {
        String username = "";
        String password = "";

        String resultado = loginController.login(username, password, redirectAttributes);

        assertEquals("redirect:/login", resultado);

        verify(redirectAttributes, times(1)).addFlashAttribute("mensagem", "Por favor, insira suas credenciais!");
    }

    @Test
    void deveRealizarLogoutComSucesso() {
        String resultado = loginController.logout(redirectAttributes);

        assertEquals("redirect:/", resultado);

        verify(redirectAttributes, times(1)).addFlashAttribute("mensagem", "Você saiu da conta com sucesso!");
    }
}
