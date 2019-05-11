if(window.attachEvent)
{
window.attachEvent("onload",fn2)
}
else
{
window.addEventListener("load", fn2)
}
function fn2() {
	var oCompile=document.getElementsByClassName("compile");
	var oDelete=document.getElementsByClassName("delete");
	var oX=document.getElementById("x");
	var oBwrap=document.getElementsByClassName("big_wrap");
	var oCancel=document.getElementById("cancel");
	var oSure=document.getElementById("sure");
	var mark1='';
	var mark2='';
	for (let i=0;i< oDelete.length;i++) {
		Block1(oDelete[i]);
		Block2(oCompile[i]);
	}
	
//	弹出删除框
	function Block1(oDel){
	   
		oDel.onclick=function(){
//			重新定义索引值
		for (let i=0;i<oDelete.length;i++) {
			oDelete[i].index=i;
		}
		mark1=this.index;
		oBwrap[0].style.display='block';
		document.getElementsByTagName('html')[0].style.overflow="hidden";
		document.getElementsByTagName('html')[0].style.height="100%";
		document.getElementsByTagName('body')[0].style.overflow="hidden";
		document.getElementsByTagName('body')[0].style.height="100%";
		}
		
	}
//	弹出编辑框
	function Block2(oCom){
	   
		oCom.onclick=function(){
//			重新定义索引值
		for (let i=0;i<oCompile.length;i++) {
			oCompile[i].index=i;
		}
//		mark2=this.index;
		oBwrap[1].style.display='block';
//		找到要编辑的学号
		$("#number").html($(".num").eq(this.index).html());
		$("#oldNumber").val($(".num").eq(this.index).html());
//$(".num").eq(this.index).html();
//		console.log($(".num").eq(this.index).html());
        
		}
		
	}
    oCancel.onclick=function(){
		DisplayD();
	}
    oSure.onclick=function(){
		DisplayD();
		var oNum=document.getElementsByClassName("num")[mark1];  
		
//		获取到所要删除的学生的学号
		console.log(oNum.innerHTML);
		$(".info-wrap").eq(mark1).remove();   //移除该div中的所有节点
	}
    
//  点击X弹出框消失
    oX.onclick=function(){
    	DisplayC();
    }
//  让弹出来的删除框消失
	function DisplayD(){
		oBwrap[0].style.display='none';
		document.getElementsByTagName('html')[0].style.overflow="visible";
		document.getElementsByTagName('html')[0].style.height="auto";
		document.getElementsByTagName('body')[0].style.overflow="visible";
		document.getElementsByTagName('body')[0].style.height="auto";
    }
//	让编辑框消失
	function DisplayC(){
		oBwrap[1].style.display='none';		
    }
}

	


