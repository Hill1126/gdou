function getFileContent(){
	var reader=new FileReader();
	var file=document.querySelector("#myFile").files;
	reader.readAsDataURL(file[0]);
	reader.onload=function(){
		document.querySelector("#Img").src=reader.result;
	}
}

