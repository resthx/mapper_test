package ${classPath};

import ${EntityClassPath};
import java.util.List;

/**
* ClassName: ${className}Service
* Description:
* date: ${date}
*/
public interface ${className}Service {
    List<${className}> find${className}All(${className} ${classParamName});
    ${className} select${className}ById(String id);
    List<${className}> select${className}ByPage(${className} ${classParamName},int page,Integer limit);
}
