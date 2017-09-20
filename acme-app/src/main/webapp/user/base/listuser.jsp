<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <base href="<%=basePath%>">
<title>login</title>
<link href="<%=basePath%>/static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" />
<script  src="<%=basePath%>/static/js/jquery-2.1.1.min.js"></script>
<script  src="<%=basePath%>/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
    <div class="form">
        <form  class="form-inline" action="<%=basePath%>user/check" method="post">
            <div class="form-group">
                <label for="exampleInputName2">id</label>
                <input type="text" name="id" class="form-control" id="user_id" placeholder="请输入用户id">
                <button type="button" class="btn btn-default" id="button_search_user_id">查询</button>
            </div>
        </form>
    </div>
        <table class="table table-bordered search_user_form">
            <caption>用户列表</caption>
            <thead>
            <tr>
                <th class="text-center">用户id</th>
                <th class="text-center">用户电话</th>
                <th class="text-center">用户邮箱</th>
            </tr>
            </thead>
            <tbody id="user_list_tbody">

            </tbody>
        </table>

    </div>
</body>
<script language="JavaScript">
    var getuserbyid=function () {
    	var id=$('#user_id').val();
        $.ajax({
            url:'<%=basePath%>user/check',
            dataType:'json',
            type:'post',
            async:true,
            data:{
                id:id
            },
            success:function (response) {
                var user=response.data;
                if(user!=null){
                	clean_table_user();
                    $tr_userid=$('<tr class="text-center"></tr>');
	                $td_userid=$('<td class="text-center">'+user.id+'</td>');
	                $td_usermobile=$('<td class="text-center">'+user.mobile+'</td>');
	                $td_useremail=$('<td class="text-center">'+user.email+'</td>');
	                $tr_userid.append($td_userid).append($td_usermobile).append($td_useremail);
	                $('#user_list_tbody').append($tr_userid);
	            }else{
	            	alert(response.errMsg);
	            }
               
            },
            error:function (response) {
                alert(response.errMsg);
            }
        });
        return false;
    }

    
    $('#button_search_user_id').click(function () {
        getuserbyid();

    });
    var clean_table_user=function(){
    	$(".search_user_form").find("td").remove();
    }
</script>
</html>