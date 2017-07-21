var cars = []

cars.push({
    brand: "Ford",
    model: "Ka",
    price: 26000
});
cars.push({
    brand: "Honda",
    model: "Civic",
    price: 35000
});
cars.push({
    brand: "Honda",
    model: "City",
    price: 33000
});

console.log(cars)

var brandOnly = cars.map(function (eachCar) { // create a new array with the tipe of return, in this case we'll be an array of brand
    return eachCar.brand;
})

console.log(brandOnly.toString())

console.log("Slice")
console.log(cars.slice(0,2)) // literally slices de array using de args as indexes
console.log("Reverse")
console.log(cars.reverse())
console.log("Reverse")
console.log(cars.reverse())

cars.sort(function(a, b){ // by default sort organizes per alphabetical order, in this case organizes per price (cres)
    return a.price - b.price;
})

console.log(cars)