const fs= require('fs');    //const al posto di let poiche', le variabili 
                            //di storing non dovrebbero esser modificate
const file= fs.readFileSync(process.argv[2]).toString();
let lines= file.split('\n');

console.log(lines.length-1);