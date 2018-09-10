<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            //底部按钮
            $(".buttons").linkbutton({

            });

            //添加对话框
            $('#myDiv').dialog({
                title: '添加图片',
                width: 330,
                height: 220,
                closed: true,
                cache: false,
                modal: true,
                buttons:'#dialogButtons',
            });

            //自定义工具栏
            var toolbar= [{
                    iconCls: 'icon-add',
                    text: '添加按钮',
                    handler: function(){
                        //首先清空用户输入信息
                        $('#desInput').val("");
                        $('#titleInput').val("");
                        $('#fileInput').val("");

                        $('#myDiv').dialog("open");
                    }
                },'-',
                {
                    iconCls: 'icon-edit',
                    text: '修改按钮',
                    handler: function(){
                        //alert('修改按钮')
                        //获取选中行对象
                        var value = $('#myTable').datagrid("getSelected");
                        //根据行对象获取下标
                        var index = $('#myTable').datagrid("getRowIndex",value);
                        //编辑指定下标的行
                        $('#myTable').edatagrid("editRow",index);
                    }
                },'-',
                {
                    iconCls: 'icon-remove',
                    text: '删除按钮',
                    handler: function(){
                        //alert('删除按钮')
                        $('#myTable').edatagrid('destroyRow');

                    }
                },'-',
                {
                    iconCls: 'icon-save',
                    text: '保存按钮',
                    handler: function(){
                        //alert('保存按钮')
                        $('#myTable').edatagrid('saveRow');
                    }
                }
            ];


            //数据表格
            $('#myTable').edatagrid({
                //请求地址
                url:"${pageContext.request.contextPath}/banner/getBanners.do",
                //显示分页
                pagination:true,
                method: "get",
                //工具栏
                toolbar:toolbar,
                //占据整个页面
                fitColumns: true,
                fit: true,
                columns:[[
                    {field:'title',title:'名称',width:100},
                    {field:'status',title:'状态',width:100, editor: {
                        type: "text",
                        options: {
                            required: true
                        }
                    }
                    },
                    {field:'url',title:'路径',width:100},
                    {field:'createDate',title:'时间',width:100},
                ]],
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="' + "http://192.168.36.142/" + rowData.url + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Attribute: ' + rowData.createDate + '</p>' +
                        '<p>Status: ' + rowData.status + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },

                //通过URL将'id'参数发送到服务器以销毁行。
                destroyUrl:'${pageContext.request.contextPath}/banner/deleteBanner',
                //通过URL更新数据到服务器并返回更新的行。
                updateUrl: '${pageContext.request.contextPath}/banner/updateBanner',
            });
        });

        //表单提交，添加图片
        function doAdd(){
            $('#myForm').form('submit',{
                url:"${pageContext.request.contextPath}/banner/addBanner",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    return isValid;	// 返回false终止表单提交
                },
                success:function(data){
                    //添加成功后关闭添加对话框
                    $('#myDiv').dialog("close");
                    //刷新表格
                    $('#myTable').datagrid("reload");
                }
            });
        }
        //取消按钮
        function closeDia(){
            $('#myDiv').dialog("close");
        }

    </script>

    <table id="myTable"></table>

    <div id="myDiv">
        <form id="myForm" method="post" enctype="multipart/form-data">
            <br/>
            标题：<input type="text" name="title" id="titleInput" class="easyui-validatebox" data-options="required:true"/><br/><br/>
            上传图片：<input type="file" name="photo" id="fileInput" class="easyui-validatebox" data-options="required:true"/><br/><br/>
            描述：<input type="text" name="description" id="desInput" class="easyui-validatebox" data-options="required:true"/><br/>
        </form>
    </div>

    <!-- 添加对话框底部按钮 -->
    <div id="dialogButtons">
        <a class="buttons" onclick="doAdd()">添加</a>
        <a class="buttons" onclick="closeDia()">取消</a>
    </div>
