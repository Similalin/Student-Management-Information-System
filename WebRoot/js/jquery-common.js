var ajaxurl = 'Service/AjaxService.ashx'
var ajaxIndex = 0;
var loading;
var state = 0;

// 当前刷卡的会员
var global_mem = {};
var Member_AllowPwd = false;

jQuery(document).ready(function () {
    loading = jQuery('<div class="divLoading"></div>').appendTo("body").hide().ajaxStart(function () {
        ajaxIndex++;
    }).ajaxStop(function () {
        $(this).hide();
    })

    //    var t = $(document.body.scrollTop).height();
    //   

    //    $(".divContentBox").css({ height: t });
    //    //GridView列表中加上选择每页显示几行数据的下拉列表
    //    $("#NetPagerParameter_input").parent().append($("#spPageSize"));
    //    $("#NetPagerParameter_input").parent().append($("#drpPageSize"));
});



/*************************************************************************************************************
cookie操作 
**************************************************************************************************************/
function setCookie(name, value, exptime) {
    if (!exptime) {
        var days = 7; //此 cookie 将被保存 7 天
        exptime = new Date();    //new Date("December 31, 9998");
        exptime.setTime(exptime.getTime() + days * 24 * 60 * 60 * 1000);
    }
    document.cookie = name + "=" + escape(value) + ";path=/;expires=" + exptime.toGMTString();
}

function getCookie(name)//取cookies函数        
{
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]); return null;
}

function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 5);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";path=/;expires=" + exp.toGMTString();
}
// 执行AJAX调用请求
function doAjax(pageLevel, Method, jsonData, dataType, callBack, isAsync) {

    $.ajax({
        url: pageLevel + ajaxurl + "?Method=" + Method,
        data: jsonData,
        dataType: dataType,
        type: "POST",
        async: isAsync != "undefined" ? isAsync : true,
        success: function (data) {

            // 返回JSON时简单的错误处理
            //            if (dataType == "json" && data.msgOK == false) {
            //                alert(data.ex);
            //                if (typeof (data.msg.type) != "undefined" && data.msg.type == "unlogin") {
            //                    top.location.href = (baseURL != "" ? baseURL : "/") + "?back=" + data.msg.back;
            //                }
            //                return false;
            //            };

            //            if (dataType == "json" && data.msgOK == false) {
            //                alert(data.ex);
            //                if (typeof (data.msg.type) != "undefined" && data.msg.type == "unlogin") {
            //                    top.location.href = (baseURL != "" ? baseURL : "/") + "?back=" + data.msg.back;
            //                }
            //                return false;
            //            };
            callBack(data);
        }
    });

}


function GetGuid() {
    var now = new Date();
    var year = now.getFullYear(); //getFullYear getYear
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var mill = now.getMilliseconds();
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;

    var guid = month + date + hour + minu + sec + mill;

    return guid;
}

//表格显示
function JQDataList(TableControl, Method) {
    doAjax(
            ajaxURL,
            {
                "todo": Method
            },
              "json",
            function (json) {
                CreateTable()
            }
        );
}

// 写入表格数据
function CreateTable(obj) {
    var html = ''
            + '<tr class=\"repeterHeader\">'
            + ' <td>区域名称</td><td style="width:75px;">操作</td>'
            + '</tr>';
    if (obj.length > 0) {
        $.each(obj, function (index, item) {

            var bg = index % 2 == 0 ? "#eee" : "#fff";
            html += "<tr class=\"repeterItems\" style='background-color:" + bg + ";' onmouseover=\"this.style.background='#ddeeff'\" onmouseout=\"this.style.background='" + bg + "'\" >"
                   + '<td class="repeterTdRight" style="text-align:left">' + item.AreaName + '</td>'
                   + '<td class="repeterTdRight" style="text-align:center; "><a href="#" onclick="javascript:AddAreaUpdate(' + item.Id + ',\'' + item.AreaName + '\')">编辑</a>&nbsp;&nbsp;<a href="#" onclick="javascript:AddAreaDelete(' + item.Id + ',\'' + item.AreaName + '\')">删除</a></td></tr>'

        });
    }
    else {
        html += '<td style="height:50px; line-height:50px;padding-left:20px; background-color:#fff;" colspan="2">未找到符合此条件的数据！请重试！</td>';
    }
    $("#AddArea_ListTable").html(html);
}

/*************************************************************************************************************
AJAX分页导航HTML代码
调用方法：
var page = new CommonPager(
"MemList_ListPage",
pageSize, 
resCount,
currentPage,
function(p) {
currentPage = parseInt(p);
MemList_GetListPage();// 此函数调用AJAX方法读取数据
}
);
page.Show();
**************************************************************************************************************/
function CommonPager(pContainer, pSize, pRecordCount, pCurrentPage, pCallBack) {
    // 显示AJAX分页按钮
    this.Show = function () {

        if (pRecordCount > 0) {
            var html = "";
            var pageCount = Math.ceil(pRecordCount / pSize);
            var pstart = pCurrentPage > 2 ? (pCurrentPage - 2) : 1;
            var pend = pCurrentPage < pageCount - 2 ? (pCurrentPage + 2) : pageCount;
            var css = "";
            var selectp = pSize == 20 ? '<option selected>20</option><option>30</option><option>50</option>' : (pSize == 30 ? '<option>20</option><option selected>30</option><option>50</option>' : '<option>20</option><option>30</option><option selected>50</option>');
            html += "<span>共<font color='#0066FF'> " + pRecordCount + "</font> 条数据&nbsp;&nbsp;每页&nbsp;<select>" + selectp + "</select>&nbsp;条&nbsp;&nbsp;当前 " + pCurrentPage + " / " + pageCount + " 页</span>";
            if (pstart > 1) html += '<a href="javascript:void(0);" class="a_page" toPage="1">1</a><span>...</span>';
            for (var i = pstart; i <= pend; i++) {
                css = i == pCurrentPage ? "a_page_c" : "a_page";
                html += '<a href="javascript:void(0);" toPage="' + i + '" class="' + css + '">' + i + '</a>';
            }
            if (pend < pageCount) html += '<span>...</span><a href="javascript:void(0);" toPage="' + pageCount + '" class="a_page">' + pageCount + '</a>';
            html += '<span><input id="ListPage_Text" type="text" value="' + currentPage + '" style="border:1px solid #ccc;width:20px;float:left;margin:5px 5px 0px 0px;"/><a href="javascript:void(0);" toPage="go" id="ListPage_GO">GO</a></span>'
            $("#" + pContainer).html(html);
            $("#" + pContainer).css("display", "");

            $("#" + pContainer + " a").click(function () {
                var p = $(this).attr("toPage");

                if (p == "go") {
                    var goP = $("#ListPage_Text").val();
                    if (typeof (goP) == "string" && !goP.IsNumber()) { alert("页码输入错误，请重试！"); $("#ListPage_Text").select(); return; }
                    p = parseInt(goP);
                    if (p < 1 || p > pageCount) { alert("页数超出范围，请重新输入！"); $("#ListPage_Text").select(); return; }
                }
                pCallBack(p);
            });
            $("#" + pContainer + " select").change(function () {
                setCookie("pageSize", $(this).val());
                pageSize = $(this).val();
                pSize = pageSize;
                pCallBack(1);
            });
            $("#ListPage_Text").keydown(function (e) {
                var keyAscii = window.event ? e.keyCode : e.which;
                if (keyAscii == 13) {
                    $("#ListPage_GO").click();
                    return false;
                }
            });
        }
        else {
            $("#" + pContainer).css("display", "none");
        }
    };

    // 显示AJAX分页按钮
    this.ShowSimple = function () {

        if (pRecordCount > 0) {
            var html = "";
            var pageCount = Math.ceil(pRecordCount / pSize);
            var css = "";

            if (pageCount != 1) {
                html += "<span>共 " + pRecordCount + " 条数据  当前 " + pCurrentPage + " / " + pageCount + " 页</span>";
                if (pCurrentPage > 1) html += '<a href="javascript:void(0);" toPage="1">首页</a><a href="javascript:void(0);" toPage="' + (pCurrentPage - 1) + '">上一页</a>';
                if (pCurrentPage < pageCount) html += '<a href="javascript:void(0);" toPage="' + (pCurrentPage + 1) + '">下一页</a><a href="javascript:void(0);" toPage="' + pageCount + '">尾页</a>';
                $("#" + pContainer).html('<div class="listTablePage_simple">' + html + '</div>');
                $("#" + pContainer).show();
            } else {
                $("#" + pContainer).hide();
            }

            $("#" + pContainer + " a").click(function () {
                var p = $(this).attr("toPage");
                pCallBack(p);
            });
        }
        else {
            $("#" + pContainer).css("display", "none");
        }
    };
}


function SetWebSkin() {
    $("#Skin").getCookie("skin")
}

/*************************************************************************************************************
数据加载时的loading文字
**************************************************************************************************************/
function ListLoading() {
    var html = '<div class="listLoading">数据正在加载，请稍候……&nbsp;&nbsp;<a href="javascript:void(0);" onclick="javascript:location.reload();">您可以刷新页面重试！</a></div>';
    document.write(html);
}
/*************************************************************************************************************
*全选
*************************************************************************************************************/
function SelectAll() {
    if ($(".chkAll").attr("checked") == true) {
        $(".chk").each(function () { //遍历html中class为chk的复选框标签        
            $(this).attr("checked", true);
        })
    }
    else {
        $(".chk").each(function () {
            $(this).attr("checked", false);
        })
    }
}

/*************************************************************************************************************
*批量发送短信 (item.MemName + ":" + item.MemMobile + ";")
*************************************************************************************************************/
function MemListSendSMS() {
    var mobile = "";
    var mobiles = "";
    var name = "";
    var memcard = "";
    var index = 0;
    var strErrorMsg = "";
        $(".chk").each(function () {
            if ($(this).attr("checked") == true) {
                mobile = $(this).attr("mobiles");
                name = $(this).attr("memname");
                memcard = $(this).attr("memcard");
                if (mobile == "") {
                    strErrorMsg += "<li>卡号:[" + memcard + "]会员没有手机号,请重新选择;" + "</li>";
                }
                else {
                    mobiles += name + ":" + mobile + ";";
                }
                index++;
            }
            
        });

    if (index <= 0) {
        strErrorMsg += "<li>请选择要发短信的会员;" + "</li>";
    }
    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            icon: 'error', //图标
            content: strErrorMsg,
            lock: true
        });
        return false;
    }
    location.href = "../ExtraService/SendMessage.aspx?PID=46&modiles=" + mobiles + "";
}

/*************************************************************************************************************
系统常用字符串数据类型验证 
**************************************************************************************************************/
String.prototype.IsEmpty = function () {
    return this == null || typeof (this) == "undefined" || this == "";
}

String.prototype.IsNumber = function () {
    var reg = /^[0-9]+$/;
    return reg.test(this);
}


String.prototype.IsDecimal = function () {
    var reg = /^[0-9]+(.[0-9]{1,4})?$/;
    return reg.test(this);
}
///
//添加验证0~1之间小数
String.prototype.isPercernt = function () {
    var reg = /^[0]+(.[0-9]{1,4})?$|1$/;
    return reg.test(this);
}

String.prototype.IsEnglish = function () {
    var reg = /^C_\w+$/;
    return reg.test(this);
}

String.prototype.IsDate = function () {
    var regex = new RegExp("^(?:(?:([0-9]{4}(-|\/)(?:(?:0?[1,3-9]|1[0-2])(-|\/)(?:29|30)|((?:0?[13578]|1[02])(-|\/)31)))|([0-9]{4}(-|\/)(?:0?[1-9]|1[0-2])(-|\/)(?:0?[1-9]|1\\d|2[0-8]))|(((?:(\\d\\d(?:0[48]|[2468][048]|[13579][26]))|(?:0[48]00|[2468][048]00|[13579][26]00))(-|\/)0?2(-|\/)29))))$");
    return regex.test(this);
}

String.prototype.IsMobile = function () {
    var reg = /^1[3|4|5|8]\d{9}$/;
    return reg.test(this);
}
String.prototype.IsTelePhone = function () {
    var reg = /^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
    return reg.test(this);
}

String.prototype.IsEmail = function () {
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    return reg.test(this);
}

String.prototype.ToNumber = function () {
    return (this == null || this == "NaN" || this == "undefined" || this == "") ? 0 : parseFloat(this);
}

String.prototype.ToFloat = function () {
    return (this == null || this == "NaN" || this == "undefined" || this == "") ? 0 : parseFloat(this);
}

String.prototype.ToDate = function () {
    var ars = new Array();
    if (this.indexOf('-') < 0) {
        ars = this.split(" ")[0].split('/');
    }
    else {
        ars = this.split(" ")[0].split('-')
    }
    var newDate = new Date(ars[0], ars[1], ars[2]);
    return newDate.Format(1);
}
String.prototype.ToDateTime = function () {
    var ars = new Array();
    if (this.indexOf('-') < 0) {
        ars = this.split(" ")[0].split('/');
    }
    else {
        ars = this.split(" ")[0].split('-')
    }
    var newDate = new Date(ars[0], ars[1], ars[2]);
    return newDate;
}



// 日期处理所需的公用函数
function appendZero(n) {
    return (("00" + n).substr(("00" + n).length - 2));
}

//取得指定日期的年月日时分秒
//参数：dateValue 是格式形如：2007/04/05 
function TimeCom(dateValue) {
    var newCom = new Date(dateValue);
    this.year = newCom.getFullYear();
    this.month = newCom.getMonth() + 1;
    this.day = newCom.getDate();
    this.hour = newCom.getHours();
    this.minute = newCom.getMinutes();
    this.second = newCom.getSeconds();
    this.msecond = newCom.getMilliseconds();
    this.week = newCom.getDay();
}

// 日期格式化（0：2000年10月20日    1：2000-10-20     2:2000-10-20 30:24:00）
Date.prototype.Format = function (formattype) {
    var day = this;
    var dateString = "";

    var thisyear = day.FormatYear();
    var thismonth = appendZero(day.getMonth());
    var thisday = appendZero(day.getDate());
    var thishour = appendZero(day.getHours());
    var thismin = appendZero(day.getMinutes());
    var thissec = appendZero(day.getSeconds());

    switch (formattype) {
        case 0:
            dateString = thisyear + "年" + thismonth + "月" + thisday + "日";
            if (dateString == "2900年01月01日") {
                dateString = "永久有效";
            }
            if (dateString == "1900年01月01日") {
                dateString = "未设置";
            }
            break;
        case 1:
            dateString = thisyear + "-" + thismonth + "-" + thisday;
            if (dateString == "2900-01-01") {
                dateString = "永久有效";
            }
            if (dateString == "1900-01-01") {
                dateString = "未设置";
            }
            break;
        case 2:
            dateString = thisyear + "-" + thismonth + "-" + thisday + " " + appendZero(thishour) + ":" + appendZero(thismin) + ":" + appendZero(thissec);
            if (dateString == "2900-01-01 00:00:00") {
                dateString = "永久有效";
            }
            if (dateString == "1900-01-01 00:00:00") {
                dateString = "未设置";
            }
            break;
        default:
            dateString = thisyear + "-" + thismonth + "-" + thisday;
            if (dateString == "2900-01-01") {
                dateString = "永久有效";
            }
            if (dateString == "1900-01-01") {
                dateString = "未设置";
            }
    }
    return dateString;
}

Date.prototype.FormatYear = function () {
    var theYear = this.getFullYear();
    var tmpYear = parseInt(theYear, 10);
    if (tmpYear < 100) {
        tmpYear += 1900;
        if (tmpYear < 1940) {
            tmpYear += 100;
        }
    }
    if (tmpYear < this.MinYear) {
        tmpYear = this.MinYear;
    }
    if (tmpYear > this.MaxYear) {
        tmpYear = this.MaxYear;
    }
    return (tmpYear);
}


// 在当前日期基础上增加指定的值
//参数：interval : y或year-表示取得相差的年份 n或month-表示相差的月份 d或day表示相差的天数 h或hour-表示相差的小时 m或minute-表示相差的分钟 s或second-表示相差的秒数 ms或msecond-表示相差的毫秒数 w或week-表示相差的周数
//      num是偏移值，-表示向前推，+向后推
//	    dateValue 指定的日期
//	    formattype是返回的时间类型
//返回：返回时间串
Date.prototype.Add = function (interval, num) {
    var newCom = new TimeCom(this);
    switch (String(interval).toLowerCase()) {
        case "y": case "year": newCom.year += num; break;
        case "n": case "month": newCom.month += num; break;
        case "d": case "day": newCom.day += num; break;
        case "h": case "hour": newCom.hour += num; break;
        case "m": case "minute": newCom.minute += num; break;
        case "s": case "second": newCom.second += num; break;
        case "ms": case "msecond": newCom.msecond += num; break;
        case "w": case "week": newCom.day += num * 7; break;
        default: return ("invalid");
    }
    var now = newCom.year + "/" + newCom.month + "/" + newCom.day + " " + newCom.hour + ":" + newCom.minute + ":" + newCom.second;
    return new Date(now);
}


// 指定小数位数的四舍五入
Number.prototype.Round = function (v) {
    var vv = Math.pow(10, v);
    return Math.round(this * vv) / vv;
}

// 检测文本框输入只能是正数Float类型
function isFloatPositive(jQuerySelector) {
    var numFloatPositive = /^\d+(\.\d+)?|[0-9]*[1-9][0-9]*$/; //^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$正浮点数(8位小数)^\d+(\.\d+)?$

    //确保用户输入的是正实数
    if (isNaN($(jQuerySelector).val())) { $(jQuerySelector).val(''); return false; }
    if (!numFloatPositive.test($(jQuerySelector).val()) && $(jQuerySelector).val() != '') {
        document.execCommand('undo'); //确保用户输入的是正实数
        return false;
    }
    return true;
}

//绑定空列表
function BindNullList(controlID) {
    if ($("#" + controlID) != null) {
        var ControlList = $("#" + controlID);
        var intTdNumber = ControlList.find("th").length;
        var trLength = ControlList.find("tr").length;
        if (trLength == 1) {
            ControlList.append("<tr><td colspan='" + intTdNumber + "' style='text-align:center'><font color='#00000'>暂无数据显示！</font></td></tr>");
        }
        var pager = $("#NetPagerParameter").length;
        if (pager > 0) {
            ControlList.append("<tr  class='th' style='height:20px;'><th id='tdfoot' colspan='" + intTdNumber + "'><div style='margin-right: 5px;width:60%;float:right;text-align:right;height:18px' id='divpage'></div></th>");
            $("#tdfoot").append($(".results"))
            $("#divpage").append($("#spPageSize")).append($("#drpPageSize")).append(($("#NetPagerParameter").find("td"))[1].innerHTML);
            $(".results").attr("style", "margin-left: 5px;width:30%;float:left;text-align:left;height:17px");
            $("#tabPager").remove();
        }
    }
}

document.onkeydown = check;
function check(e) {
    var code;
    if (!e) var e = window.event;
    if (e.keyCode) code = e.keyCode;
    else if (e.which) code = e.which;
    if (((event.keyCode == 8) &&                                                    //BackSpace   
         ((event.srcElement.type != "text" &&
         event.srcElement.type != "textarea" &&
         event.srcElement.type != "password") ||
         event.srcElement.readOnly == true)) ||
        ((event.ctrlKey) && ((event.keyCode == 78) || (event.keyCode == 82)))) {                                                   //F5   
        event.keyCode = 0;
        event.returnValue = false;
    }
    return true;
}