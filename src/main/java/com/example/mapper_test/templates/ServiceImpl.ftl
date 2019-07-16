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
    public ${className} selectById(String id) {
        return ${classParamName}Mapper.selectById(id);
    }

    @Override
    public List<${className}> selectByPage(${className} ${classParamName}, int page, Integer limit) {
        return ${classParamName}Mapper.selectByPage(${classParamName},page,limit);
    }
}
