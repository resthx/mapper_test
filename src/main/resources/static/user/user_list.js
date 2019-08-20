$(document).ready(function() {
    var userVue = new Vue({
        el: '#userForm',
        data:{
            userList:[],
            page: 1,
            limit: 10,
            count: 10
        },
        mounted: function () {
            layui.use(['laydate', 'form'], function () {
                var laydate = layui.laydate;
                var form = layui.form;
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
            var load = layer.load(1);
            $.post("../user/find",{page:'1'},function (json) {
                if (json.code!=0){
                    alert("查询失败")
                    return;
                }
                userVue.userList = json.data.users;
                userVue.count = json.data.count;
                userVue.flushPage(userVue.count);
            })
            layer.close(load);
        },
        methods :{
            searchUser:function() {
                var index = layer.load(1)
                var data = $('#formData').serializeArray();
                data.push({
                    name:'page',
                    value: this.page
                });
                data.push({
                    name:'limit',
                    value: this.limit
                });
                var objectToJson = dvs.objectToJson(data);
                $.post("../user/find",objectToJson,function (json) {
                    if (json.code!=0){
                        alert("查询失败")
                        return;
                    }
                    userVue.userList = json.data.users;
                    //总条数改变的话刷新page插件
                    if (userVue.count!=json.data.count) {
                        userVue.flushPage(json.data.count)
                    }
                    userVue.count = json.data.count;
                    layer.close(index);
                })
            },
            searchUserBy :function(){
                userVue.page = 1;
                userVue.searchUser();
            },
            flushPage(count){
                layui.use(['laypage'], function () {
                    //分页
                    var laypage = layui.laypage;
                    //完整功能
                    laypage.render({
                        elem: 'pageClick',
                        count: count,
                        limit: 10,
                        limits: [5, 10, 20, 50, 100,200],
                        layout: ['prev', 'page', 'next', 'limit', 'refresh', 'skip'],
                        jump: function (obj,first) {
                            //首次不执行
                            if(!first){
                                userVue.page = obj.curr;
                                userVue.limit = obj.limit;
                                userVue.searchUser();
                            }
                        }
                    });
                });
            }
        }
    })
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