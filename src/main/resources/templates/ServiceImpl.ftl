package ${classPath};

import ${EntityClassPath};
import ${packageName}.service.${className}Service;
import ${packageName}.mapper.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ClassName: ${className}ServiceImpl
* Description:
* date: ${date}
*/
@Service
public class ${className}ServiceImpl implements ${className}Service{
    @Autowired
    private ${className}Mapper ${classParamName}Mapper;
    @Override
    public List<${className}> find${className}All(${className} ${classParamName}) {
        return ${classParamName}Mapper.select${className}(${classParamName});
    }

    @Override
    public ${className} select${className}ById(String id) {
        return ${classParamName}Mapper.select${className}ById(id);
    }

    @Override
    public List<${className}> select${className}ByPage(${className} ${classParamName}, int page, Integer limit) {
        return ${classParamName}Mapper.select${className}ByPage(${classParamName},page,limit);
    }
}
