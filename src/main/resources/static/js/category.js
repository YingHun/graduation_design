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
        elem: "#category_detail",
        url: "http://localhost:8080/lilun/goods/category/list",
        totalRow: false,
        even: true,
        loading: true,
        page: true,
        limit: 14,
        limits: [10, 14, 15, 20, 30, 40, 50],
        cols: [
            [
                {field: 'id', title: '序号', width: 40},
                {field: 'code', title: '商品分类编码', sort: true},
                {field: 'name', title: '商品分类名称', sort: true},
                {field: 'status', title: '状态', align: 'center'},
                {
                    field: 'createTime',
                    title: '创建时间',
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
        elem: "#category_detail",
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