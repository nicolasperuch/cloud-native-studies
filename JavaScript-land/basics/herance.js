var vehicle = {
    motor: "2.0"
};

var car = {
    doors: 4,
    year: 2010
}

Object.setPrototypeOf(car, vehicle)

console.log(car)
console.log(car.motor)

// shows all the properties that car references
for(var property in car){
    console.log(property)
}