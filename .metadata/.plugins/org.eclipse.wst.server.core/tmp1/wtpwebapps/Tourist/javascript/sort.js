function sort(name,n) {
	var table, rows, switching, i, x, y, shouldSwitch, dir, switchCount = 0;
	table = document.getElementById("table");
	switching = true;
	dir = "asc";
	//name=((table.getElementsByTagName("TR"))[0].getElementsByTagName("TH"))[n].innerHTML;

	while (switching) {
		switching = false;
		
		rows = table.getElementsByTagName("TR");
		for (i = 1; i < (rows.length - 1); i++) {
			shouldSwitch = false;
			x = rows[i].getElementsByTagName("TD")[n];
			y = rows[i + 1].getElementsByTagName("TD")[n];
			if (dir == "asc") {
				(rows[0].getElementsByTagName("TH"))[n].innerHTML = name+"&#x2191";
				if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
					
					shouldSwitch = true;
					break;
				}
			} else if (dir == "desc") {
				(rows[0].getElementsByTagName("TH"))[n].innerHTML = name
						+ "&#x02193;";
				if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
					shouldSwitch = true;
					break;
				}
			}
		}
		if (shouldSwitch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
			switchCount++;
		} else {
			if (switchCount == 0 && dir == "asc") {
				dir = "desc";
				switching = true;
			}
		}
	}
}

function sortNumber(name,n) {
	var table, rows, switching, i, x, y, shouldSwitch, dir, switchCount = 0;
	table = document.getElementById("table");
	switching = true;
	dir = "asc";
	//name=((table.getElementsByTagName("TR"))[0].getElementsByTagName("TH"))[n].innerHTML;

	while (switching) {
		switching = false;
		
		rows = table.getElementsByTagName("TR");
		for (i = 1; i < (rows.length - 1); i++) {
			shouldSwitch = false;
			x = rows[i].getElementsByTagName("TD")[n];
			y = rows[i + 1].getElementsByTagName("TD")[n];
			if (dir == "asc") {
				(rows[0].getElementsByTagName("TH"))[n].innerHTML = name+"&#x2191";
				if (parseInt(x.innerHTML) > parseInt(y.innerHTML)) {
					
					shouldSwitch = true;
					break;
				}
			} else if (dir == "desc") {
				(rows[0].getElementsByTagName("TH"))[n].innerHTML = name
						+ "&#x02193;";
				if (parseInt(x.innerHTML) < parseInt(y.innerHTML)) {
					shouldSwitch = true;
					break;
				}
			}
		}
		if (shouldSwitch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
			switchCount++;
		} else {
			if (switchCount == 0 && dir == "asc") {
				dir = "desc";
				switching = true;
			}
		}
	}
}