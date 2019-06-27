package ${classPath};

import ${EntityClassPath};
import java.util.List;

/**
* ClassName: ${className}Service
* Description:
* date: ${date}
*/
public interface ${className}Service {
    ${className} selectById(String id);
    List<${className}> selectByPage(${className} ${classParamName},int page,Integer limit);
}
