/**
 * 加载页面
 * @param url   请求地址
 * @param icon  图标
 * @param name  当前菜单
 */
function loadPage(url, icon, name) {
    var $icon = $("<i></i>").addClass(icon).text(name);
    $("#location").html($icon);

    $.ajax({
        type: "GET",
        url: url,
        async: false,
        contentType: "application/json",
        dataType: "html",
        success: function (data) {
            $("#container").html(data);
        },
        error: function () {
            layer.msg("页面加载失败，请稍后重试", {time: 2000});
        }
    });
}

/**
 * 加载首页
 * @param url   首页地址
 */
function loadIndex(url) {
    $.ajax({
        type: "GET",
        url: url,
        async: false,
        contentType: "application/json",
        dataType: "html",
        success: function (data) {
            $("#container").html(data);
        },
        error: function () {
            layer.msg("页面加载失败，请稍后重试", {time: 2000});
        }
    });
}