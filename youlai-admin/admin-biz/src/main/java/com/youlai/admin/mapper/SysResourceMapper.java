package com.youlai.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.admin.pojo.SysResource;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SysResourceMapper extends BaseMapper<SysResource> {


    @Select(" select id,name,url from sys_resource ")
    @Results({
            @Result(id=true, column="id", property="id"),
            @Result(property = "roleIds",column="id",many = @Many(select="com.youlai.admin.mapper.SysRoleResourceMapper.listByResourceId"))
    })
    List<SysResource> listForResourceRoles();
}
