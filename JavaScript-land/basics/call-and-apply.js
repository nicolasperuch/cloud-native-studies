
function getAge(extraAge) {
    console.log(arguments) // verifica argumentos passados por parametro
    return this.age + extraAge;
}

var pessoa = {

    name: "Elliot",
    age: 22,
    getAge: getAge
};

console.log(pessoa.getAge(0));
console.log(getAge.call(pessoa, 2, 5)) // call passa argumentos um a um por parametro
console.log(getAge.apply(pessoa, [10, 5, 8])) // apply passa argumentos todos dentro de um vetor