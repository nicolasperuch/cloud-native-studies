function* generatorFunction() {
  yield 'hello';
  yield 'world';
  yield 'cachorro'
}

var generator = generatorFunction();

var values = Array.from(generator);

console.log(values)

function* idMaker(){
    var index = 0;
    
    while(true)
        yield index++;

}

var gen = idMaker();

console.log(gen.next().value); // 0
console.log(gen.next().value); // 1
console.log(gen.next().value); // 2
 