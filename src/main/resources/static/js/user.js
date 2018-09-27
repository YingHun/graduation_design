layui.config({
    version: '1535898708529' //为了更新 js 缓存，可忽略
});

var table, laypage, page = 1, size = 10;
layui.use(['table', 'laypage'], function () {
    table = layui.table;
    laypage = layui.laypage;

    initTable();

    table.on('tool(test)', function (obj) {
        var layEvent = obj.event;
        if (layEvent === 'detail') {
            layer.msg('查看操作');
        } else if (layEvent === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (layEvent === 'edit') {
            layer.msg('编辑操作');
        }
    });
});

function initTable() {
    table.render({
        elem: "#user_detail",
        url: "http://localhost:8080/lilun/user/list",
        totalRow: false,
        toolbar: true,
        even: true,
        loading: true,
        page: true,
        limit: 10,
        limits: [10, 20, 30, 40, 50],
        cols: [
            [
                {field: 'id', title: '序号', width: 60},
                {field: 'account', title: '账号'},
                {field: 'username', title: '名称', sort: true},
                {field: 'gender', title: '性别', width: 60, align: 'center'},
                {field: 'birthday', title: '出生日期', sort: true},
                {field: 'telephone', title: '联系电话', sort: true},
                {field: 'email', title: '电子邮箱'},
                {field: 'address', title: '家庭住址'},
                {field: 'status', title: '状态', align: 'center', width: 60},
                {
                    field: 'createTime',
                    title: '创建时间',
                    width: 170,
                    templet: '<div>{{layui.util.toDateString(d.createTime, \'yyyy-MM-dd HH:mm:ss\')}}</div>'
                },
                {field: 'right', title: '操作', toolbar: "#operation"}
            ]
        ],
        done: doneCallback,
    });
}

function doneCallback(res, curr, count) {
    laypage.render({
        elem: "#user_detail",
        count: count,
        curr: page,
        limit: size,
        limits: [10, 20, 30],
        prev: "<<",
        next: ">>",
        theme: "#0099ff",
        layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
        jump: function (obj, first) {
            if (!first) {
                page = obj.curr;
                size = obj.limit;
                initTable();
            }
        }
    });
}