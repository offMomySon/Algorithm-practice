const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


function GCMandLCM(n1,n2){
    var big,small;
    var nmg; //나머지
    var GCM, LCM;

    if (n1>=n2){
        big = n1;
        small = n2;
    }
    else {
        big = n2;
        small = n1;
    }
    
    do {
        nmg = big%small;
        if(nmg == 0){
            GCM = small;
            LCM = (n1*n2)/GCM;
            console.log(`최대공약수는 ${GCM}, 최소공배수는 ${LCM}`);
            return;
        }
        else {
            big = small;
            small = nmg;
        }
    }while(true);
}

function main(execute){
    rl.setPrompt('두 수를 입력(콤마로 구분) > ');
    rl.prompt();
    rl.on('line', (data)=>{
        var numArr = data.split(',');
        var n1 = Number(numArr[0]);
        var n2 = Number(numArr[1]);

        execute(n1,n2);
        rl.close();
    })
}

main(GCMandLCM);

// https://gist.github.com/momoci99/93679ba241dc90f954d0c201c7870fd0
// //node.js에서 파일을 읽기위한 모듈 참조
// fs = require('fs');

// var movies = createArr("films.txt");
// var movieList = new List();
// var customers = new List();
