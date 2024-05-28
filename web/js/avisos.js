const form = document.getElementById("formLogin");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const usuario = document.getElementByName("usuario");
    const senha = document.getElementsByName("senha");

    if(usuario.value.trim() === "" || senha.value.trim() === "" ) {
     window.alert("Usuario ou senha nao preenchidos!")
    } else {
        form.submit();
    }
});
