<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
       $(function(){
           //数据表格
           $('#logTable').datagrid({
               url: '${pageContext.request.contextPath}/log/showLogByPage',
               pagination: true,
               //占据整个页面
               fitColumns: true,
               fit: true,
               columns: [[
                   {field: 'username', title: '管理员名字', width: 100},
                   {field: 'createDate', title: '操作时间', width: 100},
                   {field: 'method', title: '事件', width: 100},
                   {field: 'result', title: '执行结果', width: 100},
               ]],
               singleSelect: true,
           });
       });
    </script>
    <table id="logTable"></table>
