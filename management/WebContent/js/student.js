//function getFileContent(){
//	var reader=new FileReader();
//	var file=document.querySelector("#myFile").files;
//	reader.readAsDataURL(file[0]);
//	reader.onload=function(){
//		document.querySelector("#Img").src=reader.result;
//	}
//}
if(window.attachEvent)
{
window.attachEvent("onload",fn1)
}
else
{
window.addEventListener("load", fn1)
}
function fn1() { 
	var aItem=document.getElementsByClassName("item");
	var aItemBox=document.getElementsByClassName("itemBox");
	var aShow=document.getElementsByClassName("show");
	var oLeft=document.getElementById("left-list");
	var aLi=oLeft.getElementsByTagName("li");
	
	for (let i = 0; i < aItem.length; i++) {
		 List(aItem[i]);
	}
    for (let i=0;i<aLi.length;i++) {
    	aLi[i].index=i;
    	change(aLi[i]);
    }
  
    
    function change(aL){
    	var mark=aL.index;

    	aL.onclick=function(){
    		 for (let i=0;i<aLi.length;i++) {
		    	aLi[i].style.opacity='1'; 
		    	
		    }
//  	让全部中间内容全部不显示
	    	for (let i=0;i<aShow.length;i++) {
				
	    		aShow[i].style.display='none';
	    	}
	//  	显示对应的内容
	    	aShow[mark].style.display='block';
	    	this.style.opacity='0.5';    	
        }
    }
    
    
    
    function List(aItem){


    	var  oHeight=aItem.getElementsByClassName("itemBox")[0].children[0].offsetHeight;


//  	鼠标移上去
    	aItem.onmousemove=function(){
    	//  	清空所有ItemBox的高度
	        for (let i=0;i<aItemBox.length;i++) {
	        	aItemBox[i].style.height=0+'px';	
	        }	
    		
			this.getElementsByClassName("itemBox")[0].style.height=oHeight+'px';
	 	}
    	
    	aItem.parentNode.onmouseout=function(){
//      鼠标移开
	    	for (let i=0;i<aItemBox.length;i++) {
	        	aItemBox[i].style.height=0+'px';
	        }	
    		
    	}
    }
	


}


