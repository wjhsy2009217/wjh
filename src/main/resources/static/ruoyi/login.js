var loginerror = 0;
$(function() {
    validateRule();
    $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green-login"});
	$('.imgcode').click(function() {
		var url = "system/user/getYZM";
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
		login();
    }
});

function login() {
    var yzm = $("#yzm").val();
    if(loginerror >= 3){
        $.ajax({
            type:"post",
            url:ctx +"checkYZM",
            data:{'yzm':yzm},
            dataType : "text",
            success:function(data){
                if(data=="error"){
                    alert("验证码错误");
                } else {
                    loginout();
                }
            }
        });
    } else {
        loginout();
    }

}
function loginout(){
    $.modal.loading($("#btnSubmit").data("loading"));
    var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
    var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "post",
        url: ctx + "doLogin",
        data: {
            "username": username,
            "password": password,
            "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            if (r.code == 0) {
                loginerror = 0;
                location.href = ctx + 'index';
            } else {
                loginerror += 1;
                $.modal.closeLoading();
                $('.imgcode').click();
                $.modal.msg(r.msg);
                if(r.code >= 3){
                    $('#che').html("");
                    var data = "<div class=\"row\">";
                    data += "<div class=\"col-xs-6\">";
                    data += "<li><input name=\"yzm\" id=\"yzm\" class=\"form-control code\" type=\"text\" placeholder=\"验证码\" maxlength=\"5\" >";
                    data += "</div>";
                    data += "<div class=\"col-xs-6\">";
                    data += "<a href=\"javascript:void(0);\" title=\"点击更换验证码\">"
                    data += "<li><img src="+ctx+"getYZM  id='yzmImg' class=\"imgcode\" width=\"85%\"/></li>";
                    data += "</a>"
                    data += "</div>";
                    data += "</div>";
                    $('#che').append(data);
                }
            }
        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            },
            yzm : {
                required: true
            },
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            },
            yzm: {
                required: icon + "请输入您的验证码",
            }
        }
    })
}
