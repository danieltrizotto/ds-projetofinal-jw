const form = document.getElementById("formulario");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const usuario = document.getElementByName("usuario");
    const senha = document.getElementsByName("senha");

    if(usuario.value.trim() === "" || senha.value.trim() === "" ) {
        alert("Usuario e/ou Senha não preenchidos!");
    } else {
        form.submit();
    }
});

