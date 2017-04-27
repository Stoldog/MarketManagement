/**
 * Created by RL on 2017/4/11.
 */
var baseUrl=location.protocol+"//"+location.hostname+":"+location.port;
//动态加载页面
function loadPages(getPages,getPagesText){
    if(typeof(getPagesText)!="object" ){
        $("#pageDashboard").text(getPagesText);

    }else {
        $("#pageDashboard").text($(getPagesText).text());
    }
    $("#contentBody").load(baseUrl+getPages);
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