function onclick_a() {
		$.ajax({
			type : "post",
			url : "indexServlet?method=querybyA",
			dataType : "text",
			contentType: 'text/json,charset=utf-8',
			success : function(data) {
				data = eval(data);

				var map = {},
				    dest = [];
				for(var i = 0; i < data.length; i++){
				    var ai = data[i];
				    if(!map[ai.wname]){
				        dest.push({
				            wname: ai.wname,
				            element: [ai]
				        });
				        map[ai.wname] = ai;
				    }else{
				        for(var j = 0; j < dest.length; j++){
				            var dj = dest[j];
				            if(dj.wname == ai.wname){
				                dj.element.push(ai);
				                break;
				            }
				        }
				    }
				}
				
				//构造前先清空源节点
				document.getElementById("data").innerHTML = "";
				//设置一个文件碎片
				var frag = document.createDocumentFragment();
				//这是表头
				/*var tr = document.createElement("tr");
				tr.innerHTML = "<td>字编号</td><td>字</td><td>字体</td><td>字图片</td>";
				frag.appendChild(tr); */
				//利用循环构造表格的每一行，把其放在文件碎片上面
				for (var i = 0; i < dest.length; i++){
					tr = document.createElement("tr");
					tr.innerHTML = "<td style='font-size:30px;color:#FF6633'>" + dest[i].wname + "</td>";
					for(var j =0;j < dest[i].element.length;j++){
						tr.innerHTML += "<td>"
						+ "<img title='"+dest[i].element[j].rname+"'  alt='"+dest[i].wname+"' width='50%' src='"+dest[i].element[j].wpath+"'/>"+ "</td>";
					}
					frag.appendChild(tr);
				}  
				//此时文件碎片已经是一张表了，直接放网页就可以了
				document.getElementById("data").appendChild(frag);
			},
			error : function() {
				alert("出错了");
			}
 
		});
	}

function onclick_b() {
	$.ajax({
		type : "post",
		url : "indexServlet?method=querybyB",
		dataType : "text",
		contentType: 'text/json,charset=utf-8',
		success : function(data) {
			data = eval(data);

			var map = {},
			    dest = [];
			for(var i = 0; i < data.length; i++){
			    var ai = data[i];
			    if(!map[ai.wname]){
			        dest.push({
			            wname: ai.wname,
			            element: [ai]
			        });
			        map[ai.wname] = ai;
			    }else{
			        for(var j = 0; j < dest.length; j++){
			            var dj = dest[j];
			            if(dj.wname == ai.wname){
			                dj.element.push(ai);
			                break;
			            }
			        }
			    }
			}
			document.getElementById("data").innerHTML = "";
			var frag = document.createDocumentFragment();
			for (var i = 0; i < dest.length; i++){
				tr = document.createElement("tr");
				tr.innerHTML = "<td style='font-size:30px;color:#FF6633'>" + dest[i].wname + "</td>";
				for(var j =0;j < dest[i].element.length;j++){
					tr.innerHTML += "<td>"
					+ "<img title='"+dest[i].element[j].rname+"' alt='"+dest[i].wname+"' width='50%' src='"+dest[i].element[j].wpath+"'/>"+ "</td>";
				}
				frag.appendChild(tr);
			}  
			document.getElementById("data").appendChild(frag);
		},
		error : function() {
			alert("出错了");
		}

	});
}
	
function onclick_c() {
	$.ajax({
		type : "post",
		url : "indexServlet?method=querybyC",
		dataType : "text",
		contentType: 'text/json,charset=utf-8',
		success : function(data) {
			data = eval(data);

			var map = {},
			    dest = [];
			for(var i = 0; i < data.length; i++){
			    var ai = data[i];
			    if(!map[ai.wname]){
			        dest.push({
			            wname: ai.wname,
			            element: [ai]
			        });
			        map[ai.wname] = ai;
			    }else{
			        for(var j = 0; j < dest.length; j++){
			            var dj = dest[j];
			            if(dj.wname == ai.wname){
			                dj.element.push(ai);
			                break;
			            }
			        }
			    }
			}
			console.log(dest);
			document.getElementById("data").innerHTML = "";
			var frag = document.createDocumentFragment();
			for (var i = 0; i < dest.length; i++){
				tr = document.createElement("tr");
				tr.innerHTML = "<td style='font-size:30px;color:#FF6633'>" + dest[i].wname + "</td>";
				for(var j =0;j < dest[i].element.length;j++){
					tr.innerHTML += "<td>"
					+ "<img title='"+dest[i].element[j].rname+"' alt='"+dest[i].wname+"' width='50%' src='"+dest[i].element[j].wpath+"'/>"+ "</td>";
				}
				frag.appendChild(tr);
			}  
			document.getElementById("data").appendChild(frag);
		},
		error : function() {
			alert("出错了");
		}

	});
}
	
function onclick_h() {
	$.ajax({
		type : "post",
		url : "indexServlet?method=querybyH",
		dataType : "text",
		contentType: 'text/json,charset=utf-8',
		success : function(data) {
			data = eval(data);

			var map = {},
			    dest = [];
			for(var i = 0; i < data.length; i++){
			    var ai = data[i];
			    if(!map[ai.wname]){
			        dest.push({
			            wname: ai.wname,
			            element: [ai]
			        });
			        map[ai.wname] = ai;
			    }else{
			        for(var j = 0; j < dest.length; j++){
			            var dj = dest[j];
			            if(dj.wname == ai.wname){
			                dj.element.push(ai);
			                break;
			            }
			        }
			    }
			}
			document.getElementById("data").innerHTML = "";
			var frag = document.createDocumentFragment();
			for (var i = 0; i < dest.length; i++){
				tr = document.createElement("tr");
				tr.innerHTML = "<td style='font-size:30px;color:#FF6633'>" + dest[i].wname + "</td>";
				for(var j =0;j < dest[i].element.length;j++){
					tr.innerHTML += "<td>"
					+ "<img title='"+dest[i].element[j].rname+"' alt='"+dest[i].wname+"' width='50%' src='"+dest[i].element[j].wpath+"'/>"+ "</td>";
				}
				frag.appendChild(tr);
			}  
			document.getElementById("data").appendChild(frag);
		},
		error : function() {
			alert("出错了");
		}

	});
	}
	