const URL = "http://localhost:8081/";

let loginButton = document.getElementById("loginButton");
loginButton.onclick = loginToErs;

async function loginToErs()
{
  let ersUser = 
  {
    id:document.getElementById("id").value,
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
    showReim();
  }
  else
  {
    let ersFail = document.createElement("p");
    ersFail.setAttribute("style","color:red")
    ersFail.innerText = "User doesn't exist"
    document.getElementById("login-error").appendChild(ersFail);
  }
}

function showReim()
{
  let reimsP = document.createElement("p");
  let pText = document.createTextNode("Requesting Reimbursement");
  reimsP.appendChild(pText);

  let reimsDiv = document.createElement("div");

  let reimsLabel = document.createElement("label");
  reimsLabel.setAttribute("for", "reim_amount");
  reimsLabel.innerText = "$: ";

  let reimInput = document.createElement("input");
  reimInput.setAttribute("type", "text");
  reimInput.setAttribute("id", "reimb_amount");
  reimInput.setAttribute("name", "reimb_amount");

  reimsDiv.appendChild(reimsLabel);
  reimsDiv.appendChild(reimInput);

  document.getElementsByClassName("reims")[0].appendChild(reimsP);
  document.getElementsByClassName("reims")[0].appendChild(reimsDiv);
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

function showErsReim(reimbursements)
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
