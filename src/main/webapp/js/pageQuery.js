$(function(){
	var path = $("#basepath").val();
	$("#pageQueryTable").bootstrapTable({
		 url: path+'/auv/main',         			 //请求后台的URL（*）
		 method: 'post',                      //请求方式（*）
//		 toolbar: '#toolbar',                //工具按钮用哪个容器
//		 striped: true,                      //是否显示行间隔色
//		 cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		 pagination: true,                   //是否显示分页（*）
		 locale:'zh-CN',					 //中文支持
//		 sortable: false,                     //是否启用排序
//		 sortOrder: "asc",                   //排序方式
		 queryParamsType: '',					 //传递参数（*）
		 queryParams:function queryParams(params) {  
	          var param = {  
	                  pageNumber: params.pageNumber,    
	                  pageSize: params.pageSize
	              }; 
	              /*for(var key in searchArgs){
	                  param[key]=searchArgs[key]
	              } */ 
	              return param;                   
         }, 
		 sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
		 pageNumber: 1,                       //初始化加载第一页，默认第一页
		 pageSize: 5,                       //每页的记录行数（*）
		 pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
//		 search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		 contentType: "application/x-www-form-urlencoded",
//		 strictSearch: true,
//		 showColumns: true,                  //是否显示所有的列
//		 showRefresh: true,                  //是否显示刷新按钮
//		 minimumCountColumns: 2,             //最少允许的列数
//		 clickToSelect: true,                //是否启用点击选中行
		 height: 400,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
//		 uniqueId: "no",                     //每一行的唯一标识，一般为主键列
//		 showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
//		 cardView: false,                    //是否显示详细视图
//		 detailView: false,                   //是否显示父子表
		 columns: [
		 {
		     field: 'id',
		     title: 'ID'
		 }, {
		    field: 'name',
		    title: '名字'
		 }, {
		     field: 'age',
		     title: '年龄'
		 },{
		     field: 'deptment',
		     title: '部门'
		 },		 
		 {
		     field: 'operate',
		     title: '操作',
		     formatter: function(value,row,index){//自定义方法，添加操作按钮
	                		var element = 
                			"<a class='edit' data-id='"+row.id +"'>编辑</a> "+ 
                			"<a class='delet' data-id='"+row.id +"'>删除</a> ";
	                		return element;  
	                }
		 }
		 ],
		 rowStyle: function (row, index) {
		     var classesArr = ['success', 'info'];
		     var strclass = "";
			 if (index % 2 === 0) {//偶数行
			     strclass = classesArr[0];
			 }else{//奇数行
			     strclass = classesArr[1];
			 }
			 return { classes: strclass };
		 },//隔行变色
	});
})
