    //Factory
var createPerson = function (name, age) {
    return {
        name: name,
        age: age
    }
}

console.log(createPerson("Saul", 42))
console.log(createPerson("Annie", 23))

    //Constructor
var OtherWayToCreatePerson = function (name, age){
    this.name = name;
    this.age = age;
}

console.log(new OtherWayToCreatePerson("David", 18))
console.log(new OtherWayToCreatePerson("Darlene", 27))

