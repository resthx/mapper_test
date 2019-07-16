$(document).ready(function() {
    var userVue = new Vue({
            el: '#userForm',
            data:{
                userList:[],
                page: 1,
                limit: 10,
                pageTotal: 1,
                count: 10
            },
            mounted: function () {
                this.searchUser();
            },
            methods :{
                searchUser:function() {
                    var data = $('#formData').serializeArray();
                    var objectToJson = dvs.objectToJson(data);
                    objectToJson[page] = userVue.page;
                    objectToJson[limit] = userVue.limit;
                    $.post("../user/find",JSON.stringify(objectToJson),function (json) {
                        if (json.code!=0){
                            alert("查询失败")
                            return;
                        }
                        userVue.userList = json.data.users;
                        userVue.count = json.data.count;
                        // var limit = userVue.limit;
                        // userVue.pageTotal = Math.ceil(count/limit);
                    })
                },
                changePage:function (page) {
                    userVue.page = page;
                    this.searchUser();
                },
                changeLimit:function (limit) {
                    userVue.limit = limit;
                    this.searchUser();
                }
            }
        })
    layui.use(['laydate', 'form', 'laypage'], function () {
        var vuecount = userVue.count;
        var laydate = layui.laydate;
        var form = layui.form;
        //分页
        var laypage = layui.laypage;
        //完整功能
        laypage.render({
            elem: 'pageClick',
            count: vuecount,
            layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
            jump: function (obj,first) {
                //首次不执行
                if(!first){
                    userVue.page = obj.curr;
                    userVue.limit = obj.limit;
                    userVue.searchUser();
                }
            }
        });
        /*//调用分页
    laypage.render({
        elem: '#pageClick'
        ,count: data.length
        ,jump: function(obj){
            //模拟渲染
            /!*document.getElementById('biuuu_city_list').innerHTML = function(){
                var arr = []
                    ,thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
                layui.each(thisData, function(index, item){
                    arr.push('<li>'+ item +'</li>');
                });
                return arr.join('');
            }();*!/
        }
    });*/
        // 监听全选
        form.on('checkbox(checkall)', function (data) {

            if (data.elem.checked) {
                $('tbody input').prop('checked', true);
            } else {
                $('tbody input').prop('checked', false);
            }
            form.render('checkbox');
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
})
/*用户-停用*/
function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){

        if($(obj).attr('title')=='启用'){

            //发异步把用户状态进行更改
            $(obj).attr('title','停用')
            $(obj).find('i').html('&#xe62f;');

            $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
            layer.msg('已停用!',{icon: 5,time:1000});

        }else{
            $(obj).attr('title','启用')
            $(obj).find('i').html('&#xe601;');

            $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
            layer.msg('已启用!',{icon: 5,time:1000});
        }

    });
}
/*用户-删除*/
function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        //发异步删除数据
        $(obj).parents("tr").remove();
        layer.msg('已删除!',{icon:1,time:1000});
    });
}
function delAll (argument) {
    var ids = [];

    // 获取选中的id
    $('tbody input').each(function(index, el) {
        if($(this).prop('checked')){
            ids.push($(this).val())
        }
    });

    layer.confirm('确认要删除吗？'+ids.toString(),function(index){
        //捉到所有被选中的，发异步进行删除
        layer.msg('删除成功', {icon: 1});
        $(".layui-form-checked").not('.header').parents('tr').remove();
    });
}


