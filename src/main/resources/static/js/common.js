/**
 * 加载页面
 * @param url   请求地址
 * @param icon  图标
 * @param name  当前菜单
 */
function loadPage(url, icon, name) {
    var $icon = $("<i></i>").addClass(icon);
    $("#location").html($icon).append(name);

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

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
//例子：
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function loadDialog(title, url, params, width, height) {
    if (width == null || width == "" || width == undefined) {
        width = "500px";
    }

    if (height == null || height == "" || height == undefined) {
        height = "60%";
    }

    layer.open({
        type: 2,
        title: title,
        shadeClose: true,
        shade: 0.8,
        area: [width, height],
        content: url
    });
}