const URL = "http://localhost:8081/";

let loginButton = document.getElementById("loginButton");
loginButton.onclick = loginToErs;

async function loginToErs()
{
  let ersUser = 
  {
    username:document.getElementById("ID").value,
    password:document.getElementById("password").value
  }

  let ersResponse = await fetch(URL + "login", 
  {
    method: "POST",
    body:JSON.stringify(ersUser),
    credentials: "include"
  });

  if(ersResponse.status === 200)
  {
    document.getElementById("show-reim")[0].innerHTML = '';
    
  }
  else
  {
    let ersFail = document.createElement("p");
    ersFail.setAttribute("style","color:red")
    ersFail.innerText = "User doesn't exist"
    document.getElementById("show-reim")[0].appendChild(ersFail);
  }
}

async function getErsUser()
{
  let response = await fetch(URL + "ersusers", {credentials: "include"});

  if(response.status === 200)
  {
    let users = await response.json();
    makeErsUsers(user);
  }
  else
  {
    console.log("No users to show.");
  }
}

function makeErsUsers(users)
{
  let userTable = document.getElementById("show-users");
  userTable.innerHTML = "";

  for(let user of users)
  {
    let userRow = document.createElement("tr");
    for(let cell in user)
    {
      let td = document.createElement("td");
      td.innerText = `${reim[cell].reimb_id}: ${reim[cell].reimb_amount}, ${reim[cell].reimb_submitted}, ${reim[cell].reimb_resolved},
                        ${reim[cell].reimb_description}, ${reim[cell].reimb_receipt}, ${reim[cell].reimb_author},
                        ${reim[cell].reimb_resolver}, ${reim[cell].reimb_status_id}, ${reim[cell].reimb_type_id}`
    }
    userRow.appendChild(td);
  }
  userTable.appendChild(userRow);
}

async function getErsReim()
{
  let response = await fetch(URL + "ersreim", {credentials: "include"});

  if(response.status === 200)
  {
    let reimbursements = await response.json();
    showErsReim(reimbursements);
  }
  else
  {
    console.log("No reimbursements to show.");
  }
}

function makeErsReim(reimbursements)
{
  let reimTable = document.getElementById("show-reim");
  reimTable.innerHTML = "";

  for(let reim of reimbursements)
  {
    let reimRow = document.createElement("tr");
    for(let cell in reim)
    {
      let td = document.createElement("td");
      td.innerText = `${reim[cell].reimb_id}: ${reim[cell].reimb_amount}, ${reim[cell].reimb_submitted}, ${reim[cell].reimb_resolved},
                        ${reim[cell].reimb_description}, ${reim[cell].reimb_receipt}, ${reim[cell].reimb_author},
                        ${reim[cell].reimb_resolver}, ${reim[cell].reimb_status_id}, ${reim[cell].reimb_type_id}`
    }
    reimRow.appendChild(td);
  }
  reimTable.appendChild(reimRow);
}
