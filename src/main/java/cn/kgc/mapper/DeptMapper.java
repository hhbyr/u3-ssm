package cn.kgc.mapper;

import cn.kgc.domain.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/29 09:32
 * @Description:
 */
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> selectDeptAll();
}
