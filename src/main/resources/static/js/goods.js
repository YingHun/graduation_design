layui.use('form', function () {
    var form = layui.form;

    form.render();

    form.on('submit(goodsForm)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });

    form.on('select(category)', function (data) {
        $.ajax({
            type: "GET",
            url: "item/" + data.value,
            async: false,
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                $.each(data.data, function (index, value) {
                    console.log(value + "-------" + value.code);
                    var $option = $("<option></option>").attr("value", value.code).text(value.name);
                    $("#code").parent().append($option);
                });
            },
            error: function () {
                layer.msg("页面加载失败，请稍后重试", {time: 2000});
            }
        });
    });
});