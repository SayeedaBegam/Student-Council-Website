/**
 * 
 */
const forms = document.querySelector(".forms");
const pwShowHide = document.querySelectorAll(".eye-icon");
const links = document.querySelectorAll(".link");

pwShowHide.forEach(eyeIcon => {
  eyeIcon.addEventListener("click", () => {
    let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".password");
  
    pwFields.forEach(password => {
      if(password.type === "password"){
        password.type = "text";
        eyeIcon.classList.replace("bx-hide", "bx-show");
        return;
      }
      password.type = "password";
      eyeIcon.classList.replace("bx-show", "bx-hide");
    })
  
  })
})      

links.forEach(link => {
  link.addEventListener("click", e => {
    e.preventDefault(); //preventing form submit
    forms.classList.toggle("show-signup");
  })
})

const submitButton = document.querySelector("#submit");

submitButton.addEventListener("click", e => {
  e.preventDefault(); //preventing form submit
  const emailField = document.querySelector("#email");
  const passwordField = document.querySelector("#password");

  if (emailField.value === "abc@gmail.com" && passwordField.value === "abc") {
    // Redirect to the next page
    window.location.href = "/session.java";
  } else {
    // Display an error message
    alert("Invalid email or password");
  }
})
