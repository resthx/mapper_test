<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.mapper.${className}Mapper">
    <sql id="commonSql">
        age,name,id,mobile,email,img
    </sql>
    <resultMap id="result${className}" type="${EntityClassPath}" autoMapping="true">
        <id property="id" column="id"></id>
    </resultMap>
    <select id="selectById" resultMap="result${className}">
        select <include refid="commonSql"></include> from ${classParamName} where id = ${r'#{id}'}
    </select>
    <select id="selectByPage" resultMap="result${className}">
        select <include refid="commonSql"></include>
        from ${classParamName}
        <where>
        <#list fields as field>
            <#if (field.type)=='String'>
            <if test="${classParamName}.${field.name}!=null and ${classParamName}.${field.name}!=''">
                ${field.name} = ${sqlPinJie}${classParamName}.${field.name}}
            </if>
            <#else >
            <if test="${classParamName}.${field.name}!=null">
                ${field.name} = ${sqlPinJie}${classParamName}.${field.name}}
            </if>
            </#if>
        </#list>
            <#--<if test="user.id!=null and user.id!=''">
                id = ${r'#{user.id}'}
            </if>
            <if test="user.name!=null and user.name!=''">
                name = ${r'#{user.id}'}
            </if>
            <if test="user.age!=null and user.age != 0">
                and age = ${r'#{user.id}'}
            </if>
            <if test="user.mobile!=null and user.mobile!=''">
                and mobile = ${r'#{user.id}'}
            </if>-->
        </where>
    </select>
</mapper>