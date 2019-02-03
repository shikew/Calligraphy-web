$('#jiziButton').click(function (){
        	var jiziContent = $('#jiziContent').val();
        	$.ajax({
    			type : "post",
    			url : "jiziServlet?method=querybyJizi",
    		    data:{"jiziContent":jiziContent},
    			dataType : "text",  
    			//contentType: 'text/json,charset=utf-8',
    			success : function(data) {
    				//返回的内容
    				data = eval(data);
    				//构造前先清空源节点
    				document.getElementById("image").innerHTML = "";
    				//设置一个文件碎片
    				var frag = document.createDocumentFragment();
    				for (var i = 0; i < data.length; i++) {
    					li = document.createElement("li");
    					li.className = "jizi-img";
    					li.innerHTML = "<img title='"+data[i].rname+"'src='"+data[i].wpath+"'/>";
    					frag.appendChild(li);
    				}
    				//此时文件碎片已经是一张表了，直接放网页就可以了
    				document.getElementById("image").appendChild(frag);
    			},
    			error : function() {
    				alert("出错了");
    			}
     
    		});
        });


var div = document.getElementById('jizi-result');
o_width = parseInt(div.style.width);
o_height = parseInt(div.style.height);
maxWidth = o_width * 1.2 *1.2 *1.2;
maxHeight = o_height *1.2 *1.2 *1.2;
minWidth = o_width * 0.8 *0.8 *0.8;
minHeight = o_height * 0.8 *0.8 *0.8;

$('#biggerButton').click(function (){
	if(parseInt(div.style.width) < maxWidth)
		{
		div.style.width = parseInt(div.style.width) * 1.2 +"px";
		div.style.height = parseInt(div.style.height) * 1.2 +"px"
		}
	});

$('#originalButton').click(function (){
	div.style.width = o_width +"px";
	div.style.height = o_height +"px"
	});

$('#smallerButton').click(function (){
	if(parseInt(div.style.width) > minWidth)
	{
	div.style.width = parseInt(div.style.width) * 0.8 +"px";
	div.style.height = parseInt(div.style.height) * 0.8 +"px"
	}
	});

$('#randomButton').click(function (){
	var jiziContent = $('#jiziContent').val();
	$.ajax({
		type : "post",
		url : "jiziServlet?method=querybyRandom",
	    data:{"jiziContent":jiziContent},
		dataType : "text",  
		//contentType: 'text/json,charset=utf-8',
		success : function(data) {
			//返回的内容
			data = eval(data);
			//构造前先清空源节点
			document.getElementById("image").innerHTML = "";
			//设置一个文件碎片
			var frag = document.createDocumentFragment();
			for (var i = 0; i < data.length; i++) {
				li = document.createElement("li");
				li.className = "jizi-img";
				li.innerHTML = "<img title='"+data[i].rname+"'src='"+data[i].wpath+"'/>";
				frag.appendChild(li);
			}
			//此时文件碎片已经是一张表了，直接放网页就可以了
			document.getElementById("image").appendChild(frag);
		},
		error : function() {
			alert("出错了");
		}

	});
});

