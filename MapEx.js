const arr=["Hi","Hello","Good"];
let num=arr.map(function(element){
    //console.log(element);
   // if(element%2!=0)
    //    return "Odd";
   // else 
   // return "Even";
   
   return element+element;

});
console.log(num);
const arr1=[
{"name":"Bob","Marks":[2,4,5,6,78,9]},
{"name":"Anne","Marks":[4,5,7,82,4]},
{"name":"Anita","marks":[66,70,75,53]},
{"name":"Edward","marks":[44,54,64,58]},
{"name":"Thomas","marks":[62,55,65,81]},
{"name":"Robin","marks":[41,44,47,49]},
{"name":"Sophia","marks":[71,73,67,77]},
{"name":"Bruce","marks":[52,57,61,64]}
]
// let totalsum=arr1.reduce(function(acc,curr){
//     if(acc>curr)
//         return acc;
//     else
//     return curr;

// },0)
//console.log(totalsum);
let Details=[{"id" : 101, "name" : "Mark"},
{"id" : 105, "name" : "Steve"},
{"id" : 78, "name" : "James"}
];
let Detailsprint=Details.map(function(element){
    return "<p class=id"+element.id+">"+element.name+"/p>";
});
console.log(Detailsprint);
const info=[{"fname":"Jack","lname":"Smith","city":"London"},
{"fname":"Mary","lname":"Markle","city":"Amsterdam"},
{"fname":"Ed","lname":"May","city":"Paris"},
{"fname":"Tim","lname":"Gates","city":"Rome"}
];
let cityinfo=info.map(function(element){
return element.city;
})
console.log(cityinfo);

let peopelinfo=[{"fname":"Jack","lname":"Smith","city":"London"},
{"fname":"Mary","lname":"Markle","city":"Amsterdam"},
{"fname":"Ed","lname":"May","city":"Paris"},
{"fname":"Tim","lname":"Gates","city":"Rome"}
]
let fullname='';
let newinfo=peopelinfo.map(function(element){
    peopelinfo[fullname]=element.fname+' '+element.lname;
    return peopelinfo.push[fullname];
});
console.log(newinfo);
function addtosale(){
    
}




