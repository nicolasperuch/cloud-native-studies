var itens = [];
// or itens = new Array();

itens[0] = "Chair";
itens[1] = "Bottle";
itens[4] = "Cup";

itens.push("Cupcake"); // the push always add a item to the end of the array, in this case on position 5
itens.pop(); // pop always remove the last added in this case cupcake
itens.unshift("Bread"); // Add a iten at the beginning
itens.shift(); // Remove the first item

itens.splice(4,1,"Socks") // replace socks for cup(cuz cup is in the pos 4) - args -> 4 = position, 1 = amount of itens to change, "socks" = new item
itens.splice(4,1); // remove one item(cuz of seconde args) from position four(cuz of first args)
itens.splice(4,0,"Book"); // add new item on the position 4.

console.log(itens.toString())
console.log(itens)
console.log(itens.length) // the output is 5

itens.forEach(function (eachItem) {
    console.log(eachItem)
})

var onlyBooks = itens.filter(function (eachItem){
    return eachItem === "Book"
})

console.log(" - onlyBooks - \n"+onlyBooks)

console.log("Todos os itens sao livros? "+
    itens.every(function (eachItem){
        return eachItem === "Book";
    }))

console.log("Existem algum item do tipo livro no array? "+
    itens.some(function (eachItem){
        return eachItem === "Book";
    }))