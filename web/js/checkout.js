function mostrarDiv() {
    var metodo = document.querySelector('input[name="metodo"]:checked').value;
    var infoCartao = document.getElementsByClassName('.infoCartao');
    var pagarPix = document.getElementsByClassName('.pagarPix');

    if (metodo === 'credito' || metodo === 'debito' ) {
        infoCartao.style.display = 'block';
        pagarPix.style.display = 'none';
    } else if (metodo === 'pix') {
        infoCartao.style.display = 'none';
        pagarPix.style.display = 'block';
    } else {
        infoCartao.style.display = 'none';
        pagarPix.style.display = 'none';
    }
}

const form = document.getElementsByClassName("infoCartao");

form.addEventListener("click", function (event) {
    event.preventDefault();

});