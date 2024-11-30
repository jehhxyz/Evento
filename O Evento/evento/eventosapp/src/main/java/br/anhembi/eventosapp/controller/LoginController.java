package br.anhembi.eventosapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Processa o login
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password, RedirectAttributes attributes) {

        // Verifica se o usuário deixou os campos vazios
        if (username.isEmpty() || password.isEmpty()) {
            attributes.addFlashAttribute("mensagem", "Por favor, insira suas credenciais!");
            return "redirect:/login"; // Redireciona para a página de login com a mensagem de erro
        }

        // Verifica se as credenciais são "admin"
        if ("admin".equals(username) && "admin".equals(password)) {
            return "redirect:/menu"; // Redireciona para o menu se as credenciais estiverem corretas
        } else {
            // Se as credenciais forem inválidas, adiciona uma mensagem de erro
            attributes.addFlashAttribute("mensagem", "Usuário ou senha inválidos!");
            return "redirect:/login"; // Redireciona para a página de login com a mensagem de erro
        }
    }

    // Realiza o logout do usuário
    @GetMapping("/logout")
    public String logout(RedirectAttributes attributes) {
        // Limpa a sessão ou qualquer informação do usuário (se necessário)
        attributes.addFlashAttribute("mensagem", "Você saiu da conta com sucesso!");
        return "redirect:/"; // Redireciona para a tela inicial
    }
}