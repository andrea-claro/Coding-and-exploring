const fs= require('fs');
const path= require('path');

fs.readdir(process.argv[2], function(err, data){    //utf8 serve per dire che la funzione sta
                                                            //bufferizzando i dati
    if(err) throw err;  //invece di throw err anche return console.log(err);
    
    const filterdFiles= []
    for(let k= 0; k < data.length; k++){
        const fileName= data[1];
        if(path.extername(filename=== '.'))
    }

});

//da finire