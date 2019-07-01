<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.mapper.${className}Mapper">
    <sql id="commonSql">
        <#assign i = 0>
<#--        <#if field.name?matches("^\\w*password\\w*")>-->
        <@compress single_line=true>
            <#--基础查询自动过滤不查找password-->
        <#list fields as field>
            <#if field_index==i>
                <#if field.name?matches("^\\w*password\\w*")>
                <#assign i=i+1>
                <#else>
                                ${field.name}
                </#if>
            <#else>
                <#if field.name?matches("^\\w*password\\w*")>
                <#else>
                    ,${field.name}
                </#if>
            </#if>
        </#list>
        </@compress>

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
        </where>
    </select>
</mapper>