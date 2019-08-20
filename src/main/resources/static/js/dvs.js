var dvs = dvs || {};
dvs.objectToJson = function (o) {
    var serializeObj={};
    $.each(o, function(i, field){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
}
dvs.url = window.location.protocol+"//"+window.location.host;
