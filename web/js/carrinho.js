///luan 
document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function () {
        var idProduto = this.getAttribute('data-id');
        var idUsuario = this.getAttribute('data-uso');
        var quantidade = this.getAttribute('data-qauntidade');
        // Crie um novo objeto FormData
        var formData = new FormData();

        // Adicione os dados do produto ao FormData
        formData.append('idProduto', idProduto);
        formData.append('idUsuario', idUsuario);
        formData.append('quantidade', quantidade);

        // Envie o FormData
        fetch('enviar-carr', {
            method: 'POST',
            body: formData
        })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Ocorreu um erro ao enviar o formulário.');
                    } else {
                        alert('Compra feita com sucesso.');
                        window.location.href = './carrinho';
                    }

                })
                .catch(error => {
                    console.error('Erro:', error);
                });
    });
});
////