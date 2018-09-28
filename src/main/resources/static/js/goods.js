layui.use('form', function () {
    var form = layui.form;

    form.render();

    form.on('submit(goodsForm)', function () {
        $.ajax({
            type: "POST",
            url: "record",
            async: false,
            data: $("#goodsForm").serialize(),
            success: function (data) {
                data = JSON.parse(data);
                parent.layer.msg(data.msg, {time: 2000});
            },
            error: function () {
                layer.msg("录入信息失败，请稍后重试", {time: 2000});
            }
        });
    });

    form.on('select(category)', function (data) {
        $.ajax({
            type: "GET",
            url: "item/" + data.value,
            async: false,
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                $("#code").html("");
                $("#code").append("<option value=''>请选择商品名称</option>");
                $.each(data.data, function (index, value) {
                    var $option = $("<option></option>").attr("value", value.code).text(value.name);
                    $("#code").append($option);
                });

                form.render();
            },
            error: function () {
                layer.msg("页面加载失败，请稍后重试", {time: 2000});
            }
        });
    });
});