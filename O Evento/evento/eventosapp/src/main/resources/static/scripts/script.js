function navigateTo(page) {
    window.location.href = page;
}

function proximaPagina() {
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;


    if (name && email && senha) {
        alert("Email: " + email + "\nsenha: " + senha);
        window.location.href = ""; // endereço da próxima página
    } else {
        alert("Por favor, preencha todos os campos.");
    }
}

window.onload = function() {
    // Verifica se o parâmetro 'logout' está na URL
    const urlParams = new URLSearchParams(window.location.search);
    const logout = urlParams.get('logout');

    if (logout === 'true') {
        // Se logout=true, exibe a mensagem
        document.getElementById('logoutMessage').style.display = 'block';
    }
};

// Função para navegação (caso precise navegar entre páginas)
function navigateTo(page) {
    window.location.href = page;
}

window.onload = function() {
    // Verifica se o parâmetro 'error' está presente na URL
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get('error');

    if (error === 'true') {
        // Se error=true, exibe a mensagem de erro
        document.getElementById('error-message').style.display = 'block';
    }
};
