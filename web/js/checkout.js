function mostrarDiv() {///mostra os div
    var metodo = document.querySelector('input[name="metodo"]:checked').value;
    var infoCartao = document.querySelector('.infoCartao');
    var pagarPix = document.querySelector('.pagarPix');
    var pixCodeInput = document.getElementById('pixCode');
 

    if (metodo === 'credito' || metodo === 'debito') {//para cartao    
        infoCartao.classList.add('visible');
        infoCartao.classList.remove('hidden');
        pagarPix.classList.add('hidden');
        pagarPix.classList.remove('visible');
    } else if (metodo === 'pix') {//para pix
        infoCartao.classList.add('hidden');
        infoCartao.classList.remove('visible');
        pagarPix.classList.add('visible');
        pagarPix.classList.remove('hidden');
        pixCodeInput.value = gerarCodigoPix(12); 
    } 

}


function gerarCodigoPix(length) {
    var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var code = '';
    for (var i = 0; i < length; i++) {
        code += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return code;
}
