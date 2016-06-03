function parseForm2JSON(str) {
	var reqData = "";
	str = str.replace(/&/g, "','");
	str = str.replace(/=/g, "':'");
	str = "({'" + str + "'})";
	str = str.replace(/''/g,null);
	var tmp = eval(str);
	for(var name in tmp){
		 if(tmp[name] != null){
			 if(reqData != ""){
				 reqData = reqData + ",";
			 }
		 	reqData = reqData + "'"+name+"':'"+tmp[name]+"'";
		 }
	}
	reqData = "({" + reqData + "})";
	return eval(reqData);
}
var _url;
var _data;

function query(url,msg){
	$('#query-dlg').dialog('open').dialog('setTitle',msg);
	_url = url;
}
function doQuery(){
	_data = parseForm2JSON($('#query-fm').serialize());
	$('#query-dlg').dialog('close');	
	$('#dg').datagrid('load',_data);
}
function newItem(url,msg){
	$('#dlg').dialog('open').dialog('setTitle',msg);
	$('#fm').form('clear');
	_url = url;
}
function editItem(url,msg){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle',msg);
		$('#fm').form('load',row);
		_url = url+row.id;
	}
}
function saveItem(url,msg){
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			//var result = eval('('+result+')');
			if (result.success){
				$('#dlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user _data
			} else {
				$.messager.show({
					 title:msg,
					 msg:result.msg,
					 showType:'fade',
					 style:{
						 right:'',
						 bottom:''
					 }
				});
			}
		}
	});
}
function save(msg,url,restUrl){
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			//var result = eval('('+result+')');
			if (result.success){
				$.messager.show({
					 title:msg,
					 msg:"保存成功",
					 showType:'fade',
					 style:{
						 right:'',
						 bottom:''
					 }
				});
				$('#fm')[0].reset();
			} else {
				 $.messager.show({
					 title:msg,
					 msg:result.msg,
					 showType:'fade',
					 style:{
						 right:'',
						 bottom:''
					 }
				});

			}
			
		}
	});
}
function removeItem(url,titleMsg1,titleMsg2,altMsg){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm(titleMsg1,altMsg,function(r){
			if (r){
				$.post(url,{id:row.id},function(result){
					if (result.success){
						$('#dg').datagrid('reload');	// reload the user _data
					} else {
						$.messager.show({
							 title:titleMsg2,
							 msg:result.msg,
							 showType:'fade',
							 style:{
								 right:'',
								 bottom:''
							 }
						});
					}
				},'json');
			}
		});
	}
}
