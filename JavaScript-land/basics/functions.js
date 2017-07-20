var sum = function (number1, number2) {
    return function redundatWayToSum(){
        return number1 + number2;
    }
}

console.log(sum(2, 4)());

console.log(anotherWayToSum(3, 1));
// quando nao atribuimos a funcao a alguma variavel nós podemos fazer hoisting
function anotherWayToSum(number1, number2){
    return number1 + number2;
}

