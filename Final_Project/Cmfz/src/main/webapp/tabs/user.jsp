<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
        $(function () {

            //导入文件对话框
            $('#importDiv').dialog({
                title: '导入数据',
                buttons: '#importButtons',
                closed: true
            });
            //文件导入框
            $('#importInput').filebox({
                buttonText: '选择文件',
                required:true,
            });
            //导入框底部按钮
            $('.importButton').linkbutton({});
            //导出文件对话框
            $('#exportDiv').dialog({
                title: '导出数据',
                closed: true,
                width:500
            });
            //文件导出框
            $('#exportInput').combotree({
                url: '${pageContext.request.contextPath}/json/user.json',
                method:'get',
                required: true,
                valueField:'id',
                multiple:true,
                width:420,
                onlyLeafCheck:true,
                textField:'text'
            });
            //导出框按钮
            $('#exportButton').linkbutton({
                onClick:function(){
                    var fileds = $('#exportInput').combotree("getValues");
                    var text = $('#exportInput').combotree("getText");
                    var value = "";
                    $.each(fileds,function (index, filed) {
                        if (index == fileds.length - 1) {
                            value += filed;
                        } else {
                            value += filed + ",";
                        }
                    });
                    $('#exportForm').form("submit",{
                        url:'${pageContext.request.contextPath}/user/getUserPoi',
                        queryParams:{"title":text,"filed":value},
                        onSubmit: function(){
                            var isValid = $(this).form('validate');
                            return isValid;	// 返回false终止表单提交
                        },
                        success: function(){
                            //关闭导出文件对话框
                            $('#exportDiv').dialog("close")
                        }
                    });
                }
            });

            //自定义工具栏
            var toolbar3 = [{
                iconCls: 'icon-undo',
                text: '导入数据',
                handler: function () {
                    $('#importDiv').dialog("open");
                }
            }, '-',
                {
                    iconCls: 'icon-redo',
                    text: '自定义导出数据',
                    handler: function () {
                        //打开文件导出对话框
                        $('#exportDiv').dialog("open")
                    }
                },'-',
                {
                    iconCls: 'icon-redo',
                    text: '导出所有数据',
                    handler: function () {
                       window.location.href='${pageContext.request.contextPath}/user/getAllUserPoi';
                    }
                }
            ];

            //数据表格
            $('#userTable').datagrid({
                url: '${pageContext.request.contextPath}/user/showUserByPage',
                pagination: true,
                //占据整个页面
                fitColumns: true,
                fit: true,
                columns: [[
                    {field: 'name', title: '名字', width: 30},
                    {field: 'dharma', title: '法号', width: 30},
                    {field: 'photo', title: '头像路径', width: 100},
                    {field: 'password', title: '密码', width: 190},
                    {field: 'salt', title: '私盐', width: 50},
                    {
                        field: 'sex', title: '性别', width: 30,
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "女";
                            } else {
                                return "男";
                            }
                        }
                    },
                    {field: 'location', title: '地区', width: 100},
                    {field: 'sign', title: '签名', width: 100},
                    {field: 'status', title: '状态', width: 30},
                    {field: 'phoneNum', title: '手机号', width: 100},
                    {field: 'registDate', title: '注册时间', width: 80},
                ]],
                singleSelect: true,
                toolbar: toolbar3
            });
        });

        //导入添加按钮，发送请求
        function doImport(){
            $('#importForm').form("submit",{
                url:'${pageContext.request.contextPath}/user/addUserByPoi',
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    return isValid;	// 返回false终止表单提交
                },
                success:function(data){

                    //添加成功后关闭添加对话框
                    $('#importDiv').dialog("close");
                    //刷新表格
                    $('#userTable').datagrid("reload");
                }
            });
        }
        //导入取消按钮，关闭对话框
        function closeImport(){
            $('#importDiv').dialog("close");
        }

    </script>

<table id="userTable"></table>

<%--导入文件对话框--%>
<div id="importDiv">
    <form id="importForm" method="post" enctype="multipart/form-data">
        <input id="importInput" type="text"  name="poiFile" style="width:300px" />
    </form>
</div>

<!-- 导入对话框底部按钮 -->
<div id="importButtons">
    <a class="importButton" onclick="doImport()">添加</a>
    <a class="importButton" onclick="closeImport()">取消</a>
</div>

<%--导出文件对话框--%>
<div id="exportDiv">
    <form id="exportForm" method="post" >
        <input id="exportInput" type="text" style="width:300px" />
        <a id="exportButton" href="#"  data-options="iconCls:'icon-save'">导出</a>
    </form>
</div>

