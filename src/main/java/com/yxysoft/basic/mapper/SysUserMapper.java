package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.QueryVo3;
import com.yxysoft.basic.model.SysUser;
import com.yxysoft.basic.model.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);





    //条件查询list
	List<SysUser> queryUserList(QueryVo2 vo);
    //條件查询统计表
	List<QueryVo3> queryStatementList(QueryVo2 vo);

	int deleteserinfo(Integer userId);

	SysUser selectuserinfo(String cardNo);

	SysUser selectuserinfocode(String userCode);

	SysUser selectByOpenId(String openid);

	SysUser userlogining(SysUser bean);


	
}