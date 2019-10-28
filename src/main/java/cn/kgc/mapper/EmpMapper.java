package cn.kgc.mapper;

import cn.kgc.domain.Emp;
import cn.kgc.domain.EmpTerm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/27 11:47
 * @Description:
 */
public interface EmpMapper {

    @Select("select * from emp")
    List<Emp> selectAll();

    /*分页查询*/
    List<Emp> selectBySome(EmpTerm term);
}
