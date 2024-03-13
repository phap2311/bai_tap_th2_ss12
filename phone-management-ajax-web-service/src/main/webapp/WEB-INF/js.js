function showListSmart() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphone",
        success: function (data) {
            console.log(data)
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `   <tr>
   <td>${data[i].id}</td>
   <td>${data[i].model}</td>
   <td>${data[i].price}</td>
   <td>${data[i].producer}</td>

</tr> `
            }
            document.getElementById("list").innerHTML = content;
        }
    })
}
showListSmart();
