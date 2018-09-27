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
            loadDialog("商品出货", "goods/add", null, null, "90%");
        }
    });
});

function initTable() {
    table.render({
        elem: "#invoicing_detail",
        url: "http://localhost:8080/lilun/goods/outbound/list",
        totalRow: true,
        toolbar: true,
        even: true,
        loading: true,
        page: true,
        limit: 10,
        limits: [10, 15, 20, 30, 40, 50],
        cols: [
            [
                {field: 'id', title: '序号', width: 60, totalRowText: '合计：'},
                {field: 'category', title: '商品类别'},
                {field: 'code', title: '商品名称', sort: true},
                {field: 'contact', title: '联系人'},
                {field: 'telephone', title: '联系电话'},
                {field: 'address', title: '联系地址'},
                {field: 'quantity', title: '数量', sort: true, align: 'right', totalRow: true},
                {field: 'unitPrice', title: '商品单价', sort: true, align: 'right'},
                {field: 'discount', title: '折扣率', sort: true, align: 'right'},
                {field: 'discountedPrice', title: '优惠金额', sort: true, align: 'right', totalRow: true},
                {field: 'totalPrice', title: '总金额', sort: true, align: 'right', totalRow: true},
                {field: 'type', title: '类型', sort: true, align: 'center'},
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
        elem: "#invoicing_detail",
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