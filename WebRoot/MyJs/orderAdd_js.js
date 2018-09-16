
/**
 * 
 */

$(function(){
	
	var url_geter = "geter-getAllForOneUser";
	var url_sc = "servicecompany-getAll";
	var args = {};
	$.getJSON(url_geter,args,function(data){

		for(var i=0;i<data.length;i++){
			var name = data[i].geterName;
			var address = data[i].geterAddress;
			var id = data[i].geterId;
			//填充收件人下拉菜单
			$("#selectGeter").append("<option value='"+ id +"'>"+ name + "(" + address + ")" +"</option>");
		}
	});
	$.getJSON(url_sc,args,function(data){
//		alert("1");
		for(var i=0;i<data.length;i++){
			var scname = data[i].scName;
			var scid = data[i].scId;
			//填充服务商
			$("#selectSC").append("<option value='"+ scid +"'>"+ scname +"</option>");
			
		}
	});
	//服务商与配送员的联动菜单
	$("#selectSC").change(function(){
		$("#selectSender option:not(:first)").remove();
		var id = $(this).val();
		var url_Sender = "sender-getForOneServicecompany";
		var args1 = {
			"scId" : id	
		};
		$.getJSON(url_Sender,args1,function(data){
			for(var i=0;i<data.length;i++){
				var senderName = data[i].senderName;
				var senderId = data[i].senderId;
				//填充配送员
				$("#selectSender").append("<option value='"+ senderId +"'>"+ senderName +"</option>");
				
			}
			
		});
		
	});
	
	// 添加收件人
	$("#addGeter").click(function(){
		var val = document.getElementById("addGeter").value;
		if(val == "+"){
//			$("#selectGeter").attr("disabled",true);
			$("#selectGeter").hide();
			$("#addGeter").val("X");
			$(".trDisplay").show();
		}else if(val == "X"){
//			$("#selectGeter").attr("disabled",false);
			$("#selectGeter").show();
			$("#addGeter").val("+");
			$(".trDisplay").hide();
			$("#geterName").val("");
			$("#geterPhone").val("");
			$("#geterAddress").val("");
		}
	});
	
	//确定按钮点击
	$("#addordersend").click(function(){
		//alert(1);
		var theform = document.orderSendAddForm;
		//alert(2);
//		var geterValue = $("#selectGeter").val();
//		if(geterValue == null){
//			alert("请选择收件人！");
//		}else{
			theform.submit();
//			alert("!");
//		}
	
	});
	
});