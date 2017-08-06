var helloWorld = function () {
    var message = "Hello World"
    return function () {
        return message;
    }
}

var functionReceiver = helloWorld()
console.log(functionReceiver())
// A funcao retornada nao perde a referencia a funcao "mae" (incluindo seus atributos).