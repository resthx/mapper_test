package generator;

import com.example.mapper_test.entity.User;
import freemarker.template.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: GeneratorCode
 * Description:
 * date: 2019/6/27 10:10
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class GeneratorCode {
    private static String TEMPLATE_PATH = "src\\main\\resources\\templates";
    private static Configuration configuration = null;
    private static Map<String,String> fieldNameTypeMap = new HashMap<>();
    //项目主包名称
    private static String packageName = "com.example.mapper_test";
    public static void main(String[] args) {
        GeneratorCode.generatorCode(User.class);
    }
    public static void generatorCode(Class entityClass) {
        //初始化查找实体类属性信息
        fieldNameTypeMap = getFieldInfo(entityClass);
        //得到对应渲染数据
        Map serviceClassInfo = getClassInfo(entityClass,"Service");
        Map implClassInfo = getClassInfo(entityClass,"ServiceImpl");
        //Configuration
        initConfiguration();
        generatorFile(serviceClassInfo);
        generatorFile(implClassInfo);
   }
    private static void initConfiguration() {
        configuration = new Configuration(Configuration.getVersion());
        try {
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Map<String, String> getFieldInfo(Class entityClass) {
        //得到属性名
        Field[] declaredFields = entityClass.getDeclaredFields();
        Map<String,String> fieldNameTypeMap = new HashMap<>();
        for (Field field : declaredFields){
            String type = field.getType().getSimpleName();
            String name = field.getName();
            //将属性名和对应类型放入map中
            fieldNameTypeMap.put(name,type);
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
        if ("Service".equals(typeName)){
            realPath = "src.main.java.com.example.mapper_test"+".service";
            classPath = "com.example.mapper_test"+".service";
            classTypeName = className+"Service";
        }else if ("ServiceImpl".equals(typeName)){
            realPath = "src.main.java.com.example.mapper_test.service"+".impl";
            classPath = "com.example.mapper_test.service"+".impl";
            classTypeName = className+"ServiceImpl";
        }
        map.put("classTypeName",classTypeName);
        map.put("realPath",realPath);
        map.put("classPath",classPath);
        //日期
        map.put("date",new Date().toString());
        map.put("field",fieldNameTypeMap);
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
           File docFile = new File(filePath + "\\" + classInfo.get("classTypeName")+".java");
           out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
           // step6 输出文件
           template.process(classInfo, out);
       } catch (IOException e) {
           e.printStackTrace();
       } catch (TemplateException e) {
           e.printStackTrace();
       }
       System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^User.java 文件创建成功 !");
   }
    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
