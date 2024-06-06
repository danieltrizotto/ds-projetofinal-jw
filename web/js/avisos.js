const form = document.getElementsByName("formLogin");

form.addEventListener("click", function (event) {
    event.preventDefault();
    const usuario = document.getElementById("usuario");
        const senha = document.getElementById("senha");

        if (usuario.value.trim() === "" || senha.value.trim() === "") {
            window.alert("Usuario ou senha nao preenchidos!");
        }
});