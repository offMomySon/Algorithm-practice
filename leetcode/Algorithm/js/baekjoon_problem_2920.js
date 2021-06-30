const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];
let test;

rl.on('line', function (line) {
    input.push(parseInt(line));
  })
  .on('close', function () {
    main();
    process.exit();
  });


function main(){
  let count = 1;
  let nums = input.slice(1);
  let st=[];
  let rs =[];
  
  for(let i =0 ;i< nums.length; i++){
    
    while(count <= nums[i]){
      st.push(count);
      rs.push('+');
      count++;
    }

    if(st[st.length-1] == nums[i]){
      st.pop();
      rs.push('-');
    }
    else{
      return console.log("NO");
    }

  }

  for(let i =0; i< rs.length; i++){
    console.log(rs[i])
  }

}

