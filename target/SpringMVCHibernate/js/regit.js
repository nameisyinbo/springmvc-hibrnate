$(function () {
    $("#btn").on("click",function () {
        var username = $(".userName").val();
        var password = $(".password").val();
        var repeatPassword = $(".verifyPassword").val();
        var email = $(".email").val();

        if (username == "") {
            alert("用户名不能为空");
            return false;
        } else if (password == "") {
            alert("密码不能为空");
            return false;
        } else if (repeatPassword == "") {
            alert("重复密码不能为空");
            return false;
        } else if (email == "") {
            alert("email不能为空");
            return false;
        }  else if (username == password || username == repeatPassword) {
            alert("用户名与密码不能一致");
            return false;
        }  else if (password != repeatPassword) {
            alert("两次密码必须一致");
            return false;
        }
    });

    $("#btn_add").on("click",function () {
        $(".userList_div").load('/user/form');
    });

    $(".checkbox0").on("click", function() {
        $("input[name='checkbox']").each(function() {
            //判断状态
            if ($(this).attr("checked")) {
                $(this).removeAttr("checked");
            } else {
                $(this).attr("checked", "true");
            }
        })
    });
    $("#btn_export").on("click",function () {
        var x = prompt("请输入文件名!");
        if(x!=null&&x!=""){
            $.ajax({
                url:"/user/export/x",
                type:post,
            });

        }
    })
})
