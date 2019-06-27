package ${classPath};

import ${EntityClassPath};
import ${packageName}.service.${className}Service;
import ${packageName}.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* ClassName: ${className}Controller
* Description:
* date: ${date}
*/
@RestController
@RequestMapping("${classParamName}")
public class ${className}Controller {
    @Autowired
    private ${className}Service ${classParamName}Service;
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id){
        ${className} ${classParamName} = ${classParamName}Service.selectById(id);
        return RespDate.set(0,${classParamName},null);
    }
    @RequestMapping("find")
    public RespDate find(${className} ${classParamName},@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
    List<${className}> ${classParamName}s = ${classParamName}Service.selectByPage(${classParamName}, page, limit);
        return RespDate.set(0,${classParamName}s,null);
    }
}
