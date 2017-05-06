/**
 * Created by RL on 2017/4/11.
 */
var baseUrl=location.protocol+"//"+location.hostname+":"+location.port;

$(function () {
    $.ajax("/manage/getMenus",{
        method:"GET",
        contentType:"application/json ;charset=utf-8",
        success:function (res) {
            console.log(res);
            $(res.list).each(function () {
                $("#myMenu").append("<li class='treeview'><a href='#'> <i class='fa fa-edit'></i> <span>"+this.pathName+"</span> <span class='pull-right-container'> <i class='fa fa-angle-left pull-right'></i> </span> </a> <ul class='treeview-menu'>"+getSubMenu(this.menusList)+"</ul> </li>");
            });
        }
    });
});
//遍历子菜单
function getSubMenu(getSub) {
    var subM="";
    $(getSub).each(function () {
        subM+="<li onclick='loadPages("+JSON.stringify(this.pathValue)+",this)'><a href='#'><i class='"+this.iconValue+"'></i> "+this.pathName+"</a></li>";
    });
    return subM;
}
//动态加载页面
function loadPages(getPages,getPagesText){
    if(typeof(getPagesText)!="object" ){
        $("#pageDashboard").text(getPagesText);

    }else {
        $("#pageDashboard").text($(getPagesText).text());
    }
    $("#contentBody").load(baseUrl+getPages);
}
function logOff() {
    $.ajax("/logOff",{
        method:"GET",
        contentType:"application/json; charset=utf-8",
        success:function (res) {
            if(res.result){
                window.location.href = baseUrl + "/login";
            }
        }
    });
}
function alertWarning(content) {
    var uuid = guid();
    var selectorClass = "tm-warning-alert" + uuid;
    $("body").append('<div class="alert alert-warning ' + selectorClass + '" style="display: none;z-index: 999;top:50px;margin:auto;;left: 0;right:0;width: 500px;">' +
        '<a href="#" class="close" data-dismiss="alert">&times;</a>' +
        '<strong>' + content + '</strong>。' +
        '</div>');
    $("." + selectorClass).css("position", "fixed");
    $("." + selectorClass).show();
    $("." + selectorClass).fadeOut(5000);
    var i = setTimeout(function () {
        $("." + selectorClass).remove();
    }, 4000);
}