var validate=function(){
	var un=document.getElementById("uname").value;
	var pw=document.getElementById("pwd").value;
	console.log(un +":"+pw);
	if(un==""||un.length==0 & pw==""||pw.length==0)
		{
	return false;
		}
	else
		{
		return true;
		}
}