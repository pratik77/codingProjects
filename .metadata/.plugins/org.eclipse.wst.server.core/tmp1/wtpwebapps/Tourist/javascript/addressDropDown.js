/**
 * 
 */
function addressDropDown() {
	var area = document.getElementById("area").value;
	switch (area) {
	case "India":
		document.getElementById("address").innerHTML = "<option value=Maharashtra>Maharashtra</option>"
				+ "<option value=Gujarat>Gujarat</option>"
				+ "<option value=Uttar pradesh>Uttar pradesh</option>"
				+ "<option value=Tamil Nadu>Tamil Nadu</option>";
		break;
	case "United States":
		document.getElementById("address").innerHTML = "<option value=New York>New York</option>" +
				"<option value=Colorado>Colorado</option>" +
				"<option value=Columbia>Columbia</option>" +
				"<option value=California>California</option>";
		break;
	default:
		document.getElementById("address").innerHTML ="";
		break;
	}

}

function validate()
{
	if(document.getElementById("address").value="")
	{
		alert("Please select an area");
		return false;
	}	
	return true;
}

function populateCountry(country,state,tags)
{
	
	document.getElementById("area").value=country;
	
	document.getElementById("address").innerHTML="<option value=New York>"+state+"</option>";
	
	document.getElementById("tags").value=tags;
}