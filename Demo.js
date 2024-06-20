const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if (username === "Pooja" && password === "Pooja12@") { 
       // window.open('https://www.w3schools.com/html/html_elements.asp')
      // window.open('http://127.0.0.1:5500/EmployeeDetails.html')
       localStorage.setItem("username",username);
       localStorage.setItem("password",password);

console.log("username",localStorage.getItem(username))
//document.write('<html><body><h1><left>');
        window.open('http://127.0.0.1:5500/EmployeeDetails.html')

//document.write("Welocome" +" ");
//document.write(username);

//document.write('</html></body></h1></left>');
       //console.log(newusername);
        //location.reload();
        //window.open('http://127.0.0.1:5500/EmployeeDetails.html')
   } else {
       loginErrorMsg.style.opacity = 1;
    }

})
