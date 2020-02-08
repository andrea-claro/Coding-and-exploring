console.log(process.argv);

//var sum= 0; let al posto di var, poiche' var da problemi di scope con le funzioni 
let sum= 0;

for(let k= 2; k < process.argv.length; k++)
    sum+= Number(process.argv[k]);

console.log("i numeri sono:", process.argv, sum);