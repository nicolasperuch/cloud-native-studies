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


var product = {
    type: "t-shirt",
    name: "Adidas t-shirt",
    cost: 99.99
}

var calculateLowerTaxesFromProduct = function (product){
    return product.cost * 0.2; 
}
var calculateHighTaxesFromProduct = function (product){
    return product.cost * 0.25; 
}
var addTaxesToProduct = function (product, calculateTaxes){
    return product.cost + calculateTaxes(product)
}

console.log(product)
console.log(calculateHighTaxesFromProduct(product))
console.log(addTaxesToProduct(product, calculateHighTaxesFromProduct))
