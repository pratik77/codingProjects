/**
 * 
 */
function validateTags(x) {
	var i = 0, count = 0;

	for (i = 0; i < x; i++) {
		if (document.form.tagSelect[i].checked == true) {
			// alert(document.form.songSelect[i].value);
			count++;
			//document.getElementById("signupForm").reset();
			return true;
		}
	}
	alert("Please select atleast one tag.");
	return false;

}
function reset()
{

	document.getElementById("signupForm").reset();
}