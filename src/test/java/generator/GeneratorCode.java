package generator;

import com.example.mapper_test.entity.Account;
import com.example.mapper_test.entity.Directory;
import com.example.mapper_test.entity.News;
import com.example.mapper_test.entity.User;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * ClassName: GeneratorCode
 * Description:
 * date: 2019/6/27 10:10
 *
 * @author JiLiugang
 * @version 1.0
 * @since JDK 1.8
 */
public class GeneratorCode {
    private final static String TEMPLATE_PATH = "src\\main\\java\\com\\example\\mapper_test\\templates";
    private static Configuration configuration = null;
    private static List<Map<String,String>> fieldNameTypeMap = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(GeneratorCode.class);
    //项目主包名称
    private final static String packageName = "com.example.mapper_test";
    public static void main(String[] args) {
        GeneratorCode.generatorCode(Directory.class);
    }
    public static void generatorCode(Class entityClass) {
        //Configuration
        initConfiguration();
        //初始化查找实体类属性信息
        fieldNameTypeMap = getFieldInfo(entityClass);
        //得到对应渲染数据
        Map<String,Object> serviceClassInfo = getClassInfo(entityClass,"Service");
        Map<String,Object> implClassInfo = getClassInfo(entityClass,"ServiceImpl");
        Map<String,Object> mapperClassInfo = getClassInfo(entityClass,"Mapper");
        Map<String,Object> controllerClassInfo = getClassInfo(entityClass,"Controller");
        Map<String,Object> mapperXml = getClassInfo(entityClass,"MapperXml");
        generatorFile(mapperClassInfo);
        generatorFile(serviceClassInfo);
        generatorFile(implClassInfo);
        generatorFile(controllerClassInfo);
        generatorFile(mapperXml);
   }
    private static void initConfiguration() {
        configuration = new Configuration(Configuration.getVersion());
        try {
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Map<String, String>> getFieldInfo(Class entityClass) {
        //得到属性名
        Field[] declaredFields = entityClass.getDeclaredFields();
        List<Map<String, String>> fieldNameTypeMap = new ArrayList<>();
        for (Field field : declaredFields){
            Map<String, String> fieldMap = new HashMap<>();
            String type = field.getType().getSimpleName();
            String name = field.getName();
            //将属性名和对应类型放入map中
            fieldMap.put("name",name);
            fieldMap.put("type",type);
            fieldNameTypeMap.add(fieldMap);
        }
        return fieldNameTypeMap;
    }

    private static Map getClassInfo(Class entity,String typeName) {
        Map<String,Object> map = new HashMap<>();
        map.put("templateName",typeName+".ftl");
        map.put("packageName",packageName);
        //实体对象名称
        String className = entity.getSimpleName();
        map.put("className",className);
        map.put("classParamName",toLowerCaseFirstOne(className));
        map.put("EntityClassPath",entity.getName());
        //得到路径
        String realPath = null;
        String classPath = null;
        String classTypeName = null;
        Boolean isXml = false;
        if ("Service".equals(typeName)){
            realPath = "src.main.java."+packageName+".service";
            classPath = packageName+".service";
            classTypeName = className+"Service";
        }else if ("ServiceImpl".equals(typeName)){
            realPath = "src.main.java."+packageName+".service.impl";
            classPath = packageName+".service.impl";
            classTypeName = className+"ServiceImpl";
        }else if ("Mapper".equals(typeName)){
            realPath = "src.main.java."+packageName+".mapper";
            classPath = packageName+".mapper";
            classTypeName = className+"Mapper";
        }else if ("Controller".equals(typeName)){
            realPath = "src.main.java."+packageName+".controller";
            classPath = packageName+".controller";
            classTypeName = className+"Controller";
        }else if ("MapperXml".equals(typeName)){
            realPath = "src.main.resources.mapper";
            classTypeName = className+"Mapper";
            //应对嵌套渲染问题
            map.put("sqlPinJie","#{");
            isXml = true;
        }
        map.put("isXml",isXml);
        map.put("classTypeName",classTypeName);
        map.put("realPath",realPath);
        map.put("classPath",classPath);
        //日期
        map.put("date",new Date().toString());
        map.put("fields",fieldNameTypeMap);
        return map;
    }

    public static void generatorFile(Map<String,Object> classInfo){
       Writer out = null;
       // step4 加载模版文件
       Template template = null;
       try {
           template = configuration.getTemplate((String) classInfo.get("templateName"));
           // step5 生成数据
           String filePath = (String) classInfo.get("realPath");
           filePath = filePath.replaceAll("\\.","\\\\");
           File directory = new File(filePath);
           if (!directory.exists()){
               directory.mkdirs();
           }
           File docFile = null;
           if ((Boolean) classInfo.get("isXml")){
               docFile = new File(filePath + "\\" + classInfo.get("classTypeName")+".xml");
           }else {
               docFile = new File(filePath + "\\" + classInfo.get("classTypeName")+".java");
           }
           out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
           // step6 输出文件
           template.process(classInfo, out);
       } catch (IOException e) {
           e.printStackTrace();
       } catch (TemplateException e) {
           e.printStackTrace();
       }
        if ((Boolean) classInfo.get("isXml")){
            logger.info("----------------"+classInfo.get("classTypeName")+".xml 文件创建成功 !");
        }else {
            logger.info("----------------"+classInfo.get("classTypeName")+".java 文件创建成功 !");
        }
   }
    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
