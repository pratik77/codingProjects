/**
 * 
 */
function overlayEffect()
{
document.getElementById("overlay").style.height="100%";
document.getElementById("outPopUp").style.display="none";
return false;

}

function off()
{
	document.getElementById("signupForm").reset();
		document.getElementById("overlay").style.height="0%";
}