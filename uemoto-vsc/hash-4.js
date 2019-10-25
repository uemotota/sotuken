class sha {
    constructor() {
        this.passwd = {};
    };

    async SHA_256_HASH_1( id, pass ) {
        let buffer = new TextEncoder("utf-8").encode(pass);
        let hash = await crypto.subtle.digest("SHA-256", buffer);
        this.passwd[id] = hex(hash);
        console.log(this.passwd);
        return hash;
    }

    async SHA_256_HASH_2( id, pass ) {
        var buffer = new TextEncoder("utf-8").encode(pass);
        let hash = await crypto.subtle.digest("SHA-256", buffer);
        console.log( [this.passwd[id], hex(hash) ]);
        return ( this.passwd[id] == hex(hash) );
    }

};



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

window.addEventListener( 'load', () => {
    //var login = document.querySelector("#login");
    //login.style.display = "none";
    var sha1 = new sha();

    document.querySelector("#commit").addEventListener('click', async () => {
        //document.querySelector('#subscription').style.display = "none";
        //let login = document.querySelector('#login');
        //login.style.display = "block";
        let id = document.getElementById("ID1").value;
        let pass = document.getElementById("passw1").value;
        let hashtext = await sha1.SHA_256_HASH_1( id, pass );

        document.getElementById("hashtext1").value = hex(hashtext);
        console.log(hashtext1);
    });

    document.querySelector('#signin').addEventListener('click', async () => {
        let id = document.getElementById("ID2").value;
        let pass = document.getElementById("passw2").value;
        let hantei = await sha1.SHA_256_HASH_2( id, pass );
        if(  hantei ) {
            console.log("ろぐいんできました");
        } else {
            console.log("ぱすわーどがちがいます");
        }
    });
})