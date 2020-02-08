//require serve per importare moduli
const fs= require('fs');    //const al posto di let poiche', le variabili 
                            //di storing non dovrebbero esser modificate
fs.readFile(process.argv[2], 'utf8', function(err, data){    //utf8 serve per dire che la funzione sta
                                                            //bufferizzando i dati
    if(err) throw err;  //invece di throw err anche return console.log(err);
    
    let lines= data.split('\n').length-1;

    console.log(lines);
});  
