var numeroParaSerEncontrado = 0;
var tentativas = 0;

function atualizar() {
    numeroParaSerEncontrado = parseInt(Math.random() * 101, 10);
    console.log('Número a ser encontrado: ' + numeroParaSerEncontrado);
}

atualizar();

function verificarnumero() {
    var numero = parseInt(document.getElementById('inputnumero').value, 10);

    if (isNaN(numero) || numero > 100 || numero < 0) {
        alert('Número inválido. Digite um número entre 0 e 100. 🚨');
        return;
    }

    tentativas++;

    if (numero > numeroParaSerEncontrado) {
        alert('O número a ser encontrado é menor! ❌');
    } else if (numero < numeroParaSerEncontrado) {
        alert('O número a ser encontrado é maior! ✅');
    } else {
        alert(`Você acertou com ${tentativas} tentativas!`);
        atualizar();
        tentativas = 0;
    }

    document.getElementById('inputnumero').value = '';
}
