function htmlReq1(option){
	let table = document.getElementById("movietable");
	for(let i = table.rows.length-1; i > -1;i--){
		table.deleteRow(i);
		
	}
    let request = new XMLHttpRequest();
    if(option == 1){
    	request.open('GET', 'https://jyme.azurewebsites.net/rest/1/movieName', true);
    }
    else if(option == 2){
    	request.open('GET', 'https://jyme.azurewebsites.net/rest/1/movieDate', true);
    }
    request.onload = function () {
	
    	let splits = JSON.parse(request.response);
    	
    	for(let i = 0; i < splits.length;i++){
    		let row = table.insertRow(i);
    		let cell_name = row.insertCell(0);
    		let cell_date = row.insertCell(1);
    		cell_name.innerHTML = splits[i].movieName;
    		cell_date.innerHTML = splits[i].movieDate;	
    	}	
    }
    request.send();
}
