function getAge(){
    return this.age;
}

var pessoa = {
    
    getAge: getAge,

    localization: {
        city: "NY",
        neighborhood: "Brooklyn"
    }

};

pessoa.name = "Oliver";
pessoa.age = 20;


console.log(pessoa);
console.log(pessoa.getAge());
