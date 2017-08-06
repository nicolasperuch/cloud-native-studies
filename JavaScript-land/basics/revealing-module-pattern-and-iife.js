var counter = (function () {
        var _value = 0;
        var _add = function (){
            return ++_value;
        };
        var _reset = function (){
            return _value = 0;
        };
        return {
            add: _add,
            reset: _reset
        };
})();


console.log(counter._value);
console.log(counter.add());
console.log(counter.reset());
console.log(counter.add());
console.log(counter.add());