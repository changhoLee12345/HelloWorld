// variable.js

var myName = '이창호'; // string
var yourName; // undefined
myName = 100; // number
myName = true; // boolean
myName = null; // object

console.log(typeof yourName);
var yourName = "홍길동";
console.log(typeof yourName);

// 전역변수(스크립트변수), 지역변수(함수안에서 변수)

function checkInfo() {
  var myName = 'LeeChangho';
  console.log(myName);
  var myName = 'LLL';
}
checkInfo();
console.log(myName);

// ES6 (ES2015) => let, const
// let 블럭레벨 변수선언.

function info() {
  let myName = 'Hong';
  console.log(myName);
}
info();

{
  let myName = 'Hong';
  console.log(myName);
}

{
  let myName = 'Hwang';
  console.log(myName);
}

const otherName = 'Hong';
// otherName = 'Hwang';

// var, let => 변수선언.
// const => 상수선언.

