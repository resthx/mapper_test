package ${classPath};

import ${EntityClassPath};
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* ClassName: ${className}Mapper
* Description:
* date: ${date}
*/
public interface ${className}Mapper extends BaseMapper<${className}> {
    List<${className}> selectByPage(${className} ${classParamName},@Param("page") int page,@Param("limit") Integer limit);
    ${className} selectById(@Param("id") String id);
}