var alterFlag = "on"; //alert开关

/**
 * alert开关方法
 * @param msg
 */
function xAlert(msg){
	if (alterFlag == "on"){
		alert(msg)
	}else{
		return;
	}
}