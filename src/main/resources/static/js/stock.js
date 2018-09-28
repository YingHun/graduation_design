layui.config({
    version: '1535898708529' //为了更新 js 缓存，可忽略
});

var table, laypage, form, page = 1, size = 10;
layui.use(['table', 'laypage', 'form'], function () {
    table = layui.table;
    laypage = layui.laypage;
    form = layui.form;

    form.render();

    form.on('submit(stockForm)', function () {
        $.ajax({
            type: "POST",
            url: "/lilun/stock/append",
            async: false,
            data: $("#stockForm").serialize(),
            success: function (data) {
                data = JSON.parse(data);
                parent.layer.msg(data.msg, {time: 2000});
            },
            error: function () {
                layer.msg("录入信息失败，请稍后重试", {time: 2000});
            }
        });
    });

    initTable();

    table.on('tool(test)', function (obj) {
        var data = obj.data, layEvent = obj.event;
        if (layEvent === 'edit') {
            loadDialog("编辑商品信息", "stock/edit/" + data.code, null, null, "70%");
        }
    });
});

function initTable(params) {
    table.render({
        elem: "#stock_detail",
        url: "stock/list",
        method: "post",
        where: params,
        totalRow: true,
        toolbar: '#add',
        defaultToolbar: ['filter', 'print', 'exports'],
        even: true,
        loading: true,
        page: true,
        limit: 10,
        limits: [10, 15, 20, 30, 40, 50],
        cols: [
            [
                {field: 'code', title: '商品编码', sort: true, totalRowText: '合计：'},
                {field: 'name', title: '商品名称'},
                {field: 'category', title: '商品类别'},
                {field: 'stock', title: '库存', sort: true, totalRow: true, align: 'right'},
                {field: 'soldQuantity', title: '已售数量', sort: true, totalRow: true, align: 'right'},
                {field: 'unitPrice', title: '商品单价', sort: true, align: 'right'},
                {field: 'status', title: '状态', align: 'center'},
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
        elem: "#stock_detail",
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

$("#search").on("click", function () {
    var category = $("#category").val();
    var status = $("#status").val();
    var name = $("#name").val();

    var params = {};
    params.category = category;
    params.status = status;
    params.name = name;

    initTable(params);
});

function add() {
    loadDialog("添加商品", "stock/add", null, null, "90%");
}