function SHA_256_HASH_1() {
    window.location.href ='./the-4.html';

    var nam1 = document.getElementById("ID1").value;
    

    var str1 = document.getElementById("passw").value;
    var buffer = new TextEncoder("utf-8").encode(str1);
    return [crypto.subtle.digest("SHA-256", buffer).then(
        function (hash) {
            
            document.getElementById("hashtext1").value = hex(hash)
            console.log(hashtext1);
        }
    ),nam1,hashtext1];
   
}


function SHA_256_HASH_2() {
   

    var str2 = document.getElementById("passw").value;
    var buffer = new TextEncoder("utf-8").encode(str2);
    
    return crypto.subtle.digest("SHA-256", buffer).then(
        function (hash) {
            var nam1=SHA_256_HASH_1(nam1);
            var hasht1=SHA_256_HASH_1(hashtext1);
            var nam2 = document.getElementById("ID2").value;
            if(nam1==nam2){
                var hasht2=document.getElementById("hashtext2").value = hex(hash)
                if(hasht1==hasht2){
                    document.getElementById("hashtext2").value;
                    window.location.href ='./the-6.html'
                }else{

                }
            }else{

            }
        }
    );
}



function hex(buffer) {
    var hexCodes = [];
    var view = new DataView(buffer);
    for (var i = 0; i < view.byteLength; i += 4) {
        // Using getUint32 reduces the number of iterations needed (we process 4 bytes each time)
        var value = view.getUint32(i)
        // toString(16) will give the hex representation of the number without padding
        var stringValue = value.toString(16)
        // We use concatenation and slice for padding
        var padding = '00000000'
        var paddedValue = (padding + stringValue).slice(-padding.length)
        hexCodes.push(paddedValue);
    }
    // Join all the hex strings into one

    return hexCodes.join("");
}

