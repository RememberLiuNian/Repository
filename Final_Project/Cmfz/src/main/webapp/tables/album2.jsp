<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript">
        $(function () {

            //树形表格
            $('#albumTable').treegrid({
                url: '${pageContext.request.contextPath}/album/getAlbums',
                idField: 'id',
                //定义树节点的字段
                treeField: 'title',
                //显示分页
                pagination: true,
                method: "get",
                collapsible: true,
                //占据整个页面
                fitColumns: true,
                fit: true,
                columns: [[
                    {field: 'title', title: '名字', width: 60},
                    {field: 'url', title: '下载路径', width: 80},
                    {field: 'size', title: '章节大小', width: 80},
                    {field: 'duration', title: '章节时长', width: 80}
                ]],
                toolbar: toolbar,
                //双击事件
                onDblClickRow:function(row){
                    //console.log(row)
                    //先判断选中的是否是章节节点
                    if (row != null) {
                        //查看选中节点的等级
                        var level = $('#albumTable').treegrid("getLevel", row.id);
                        if (level != 1) {
                            //初始音频播放器参数
                            $('#audioMic').prop("src","${pageContext.request.contextPath}/tabs"+row.url);
                            $('#musicSpan').text(row.title);
                            //打开音频播放对话框
                            $('#musicDiv').dialog("open");
                        } else {
                            alert("请先选中一个章节");
                        }
                    } else {
                        alert("请先选中一个章节");
                    }
                }
            });


            //详情对话框
            $('#desDiv').dialog({
                title: '详情',
                width: 330,
                height: 450,
                closed: true,
                cache: false,
                modal: true,
                buttons: '#desButtons'
            });

            //添加专辑对话框
            $('#addAlbumDiv').dialog({
                title: '添加专辑',
                width: 330,
                height: 300,
                closed: true,
                cache: false,
                modal: true,
                buttons: '#addAlbumButtons'
            });

            //添加章节对话框
            $('#addChapterDiv').dialog({
                title: '添加章节',
                width: 330,
                height: 300,
                closed: true,
                cache: false,
                modal: true,
                buttons: '#addChapterButtons'
            });

            //音频播放对话框
            $('#musicDiv').dialog({
                title: '播放器',
                closed: true,
                cache: false,
                modal: true,
            });

        });

        //自定义工具栏
        var toolbar = [{
            iconCls: 'icon-search',
            text: '专辑详情',
            handler: function () {
                //获取选中行对象
                var value = $('#albumTable').treegrid("getSelected");
                if (value != null) {
                    //查看选中节点的等级
                    var level = $('#albumTable').treegrid("getLevel", value.id);
                    if (level == 1) {
                        //给详情对话框填充数据
                        $('#albumTitle').val(value.title);
                        $('#albumScore').val(value.score);
                        $('#albumAuthor').val(value.author);
                        $('#albumBroadcast').val(value.broadcast);
                        $('#albumCount').val(value.count);
                        $('#albumBrief').val(value.brief);
                        $('#albumPublishDate').val(value.publishDate);
                        $('#albumCoverImg').prop("src", "${pageContext.request.contextPath}/tabs" + value.coverImg);
                        $('#albumStatus').val(value.status);
                        $('#albumCreateDate').val(value.createDate);
                        //打开详情对话框
                        $('#desDiv').dialog("open");
                    } else {
                        alert("请先选中一个专辑");
                    }
                } else {
                    alert("请先选中一个专辑");
                }
            }
        }, '-',
            {
                iconCls: 'icon-add',
                text: '添加专辑',
                handler: function () {
                    //打开添加专辑对话框
                    $('#addAlbumDiv').dialog("open");
                }
            }, '-',
            {
                iconCls: 'icon-add',
                text: '添加章节',
                handler: function () {
                    //获取选中行对象
                    var value = $('#albumTable').treegrid("getSelected");
                    if (value != null) {
                        //查看选中节点的等级
                        var level = $('#albumTable').treegrid("getLevel", value.id);
                        if (level == 1) {
                          // alert("可以添加章节了");
                            //对话框一些属性初始化
                            $('#albumId').val(value.id);
                            $('#mySpan').text(value.title);
                            //打开添加章节对话框
                            $('#addChapterDiv').dialog("open");
                        } else {
                            alert("请先选中一个专辑");
                        }
                    } else {
                        alert("请先选中一个专辑");
                    }
                }
            }, '-',
            {
                iconCls: 'icon-lock',
                text: '下载音频',
                handler: function () {
                    //获取选中行对象
                    var value = $('#albumTable').treegrid("getSelected");
                    if (value != null) {
                        //查看选中节点的等级
                        var level = $('#albumTable').treegrid("getLevel", value.id);
                        if (level != 1) {
                            //alert("可以下载章节了");
                            window.location.href="${pageContext.request.contextPath}/chapter/downloadChapter?filename="+value.url+"&title="+value.title;
                        } else {
                            alert("请先选中一个章节");
                        }
                    } else {
                        alert("请先选中一个章节");
                    }
                }
            }
        ];

        //关闭详情对话框
        function closeDes() {
            $('#desDiv').dialog("close");
        }

        //关闭添加专辑对话框
        function closeAddAlbum(){
            $('#addAlbumDiv').dialog("close");
        }

        //发送添加专辑请求
        function doAddAlbum(){
            $('#addAlbumForm').form("submit",{
                url:"${pageContext.request.contextPath}/album/addAlbum",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    return isValid;	// 返回false终止表单提交
                },
                datatype:'JSON',
                success:function(data){
                    //添加成功后关闭添加对话框
                    $('#addAlbumDiv').dialog("close");
                    //刷新表格
                    $('#albumTable').treegrid("reload");
                }
            });
        }

        //关闭添加章节对话框
        function closeAddChapter(){
            $('#addChapterDiv').dialog("close");
        }

        //发送添加章节请求
        function doAddChapter(){
            $('#addChapterForm').form("submit",{
                url:"${pageContext.request.contextPath}/chapter/addChapter",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    return isValid;	// 返回false终止表单提交
                },
                datatype:'JSON',
                success:function(data){
                    //添加成功后关闭添加对话框
                    $('#addChapterDiv').dialog("close");
                    //刷新表格
                    $('#albumTable').treegrid("reload");
                }
            });
        }
    </script>
</head>
<body>
<table id="albumTable"></table>

<!--专辑详情-->
<div id="desDiv">
    <br/>
    标题：<input type="text" name="title" id="albumTitle" readonly/><br/>
    评分：<input type="text" name="score" id="albumScore" readonly/><br/>
    作者：<input type="text" name="author" id="albumAuthor" readonly/><br/>
    播音员：<input type="text" name="broadcast" id="albumBroadcast" readonly/><br/>
    章节数：<input type="text" name="count" id="albumCount" readonly/><br/>
    内容介绍：<input type="text" name="brief" id="albumBrief" readonly/><br/>
    发布日期：<input type="text" name="publishDate" id="albumPublishDate" readonly/><br/>
    封面：<img src="image/1.png" width="250px" height="150px" align="center" id="albumCoverImg" readonly/><br/>
    状态：<input type="text" name="status" id="albumStatus" readonly/><br/>
    创建日期：<input type="text" name="createDate" id="albumCreateDate" readonly/><br/>
</div>

<!-- 专辑详情对话框底部按钮 -->
<div id="desButtons">
    <a class="easyui-linkbutton" onclick="closeDes()">确定</a>
</div>


<!--添加专辑-->
<div id="addAlbumDiv">
    <br/>
    <form method="post" enctype="multipart/form-data" id="addAlbumForm">
        标题：<input type="text" name="title" class="easyui-validatebox" data-options="required:true"/><br/>
        评分：<input type="text" name="score" class="easyui-validatebox" data-options="required:true"/><br/>
        作者：<input type="text" name="author" class="easyui-validatebox" data-options="required:true"/><br/>
        播音员：<input type="text" name="broadcast" class="easyui-validatebox" data-options="required:true"/><br/>
        内容介绍：<input type="text" name="brief" class="easyui-validatebox" data-options="required:true"/><br/>
        封面：<input class="easyui-filebox" name="coverPic" data-options="required:true" style="width:200px"><br/>
        状态：<select id="cc" class="easyui-combobox" name="status" style="width:200px;">
                <option value="Y">展示</option>
                <option value="N">不展示</option>
            </select>
    </form>
</div>

<!-- 添加专辑对话框底部按钮 -->
<div id="addAlbumButtons">
    <a class="easyui-linkbutton" onclick="doAddAlbum()">确定</a>
    <a class="easyui-linkbutton" onclick="closeAddAlbum()">取消</a>
</div>


<!--添加章节-->
<div id="addChapterDiv">
    <br/>
    <form method="post" enctype="multipart/form-data" id="addChapterForm">
        <input type="hidden" name="albumId" id="albumId"/>
        所属专辑：<span id="mySpan"></span> <br/><br/>
        标题：<input type="text" name="title" class="easyui-validatebox" data-options="required:true"/><br/><br/>
        音频：<input class="easyui-filebox" name="voice" data-options="required:true" style="width:200px"><br/>
    </select>
    </form>
</div>

<!-- 添加章节对话框底部按钮 -->
<div id="addChapterButtons">
    <a class="easyui-linkbutton" onclick="doAddChapter()">确定</a>
    <a class="easyui-linkbutton" onclick="closeAddChapter()">取消</a>
</div>

<!--播放音频-->
<div  id="musicDiv">
    音频名字：<span id="musicSpan"></span><br/><br/>
    <audio src="source/Kelly Clarkson-Because Of You -1533133347831.mp3" controls id="audioMic">播放</audio>
</div>
    </body>
    </html>