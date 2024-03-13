function showListSmart() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphone",
        success: function (data) {
            console.log(data)
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `
  
  ${getSmartphone(data[i])}

 `
            }
            document.getElementById("list").innerHTML = content;
        }
    })
}

showListSmart();

function createSmart() {
    // chan su kien mac dinh
    event.preventDefault();
    let model = document.getElementById("model").value;
    let price = document.getElementById("price").value;
    let producer = document.getElementById("producer").value;
    let newSmartphone = {
        "model": model,
        "price": price,
        "producer": producer
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: "http://localhost:8080/api/smartphone",
        data: JSON.stringify(newSmartphone),
        success: showListSmart
    })
}

function getSmartphone(smartphone) {
    return `<tr>
<td >${smartphone.id}</td>
<td >${smartphone.model}</td>
<td >${smartphone.price}</td>
<td >${smartphone.producer}</td>
` + `<td class="btn"><button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button></td>
</tr>`;
}

function deleteSmartphone(id) {
    $.ajax({
        type: 'DELETE',
        url: `http://localhost:8080/api/smartphone/${id}`,
        success: showListSmart
    })
}