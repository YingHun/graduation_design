/**
 * 退出系统
 */
function logout() {
    layer.confirm('您确定要退出吗？', {
        btn: ['确定', '取消']
    }, function () {
        $("#logout_form").submit();
    });
}