const sum = a => b=>{
    if(arguments.length ==1){
        return function(b2){
            return a+b2;
        };
    }
    return a + b;
};

const product = (a, b) => {
    return a * b;
};

export {sum, product};
