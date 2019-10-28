package cn.kgc.serivce;

import cn.kgc.domain.Emp;
import cn.kgc.domain.EmpTerm;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/27 11:48
 * @Description:
 */
public interface EmpService {

    List<Emp> findAll();

    List<Emp> findBySome(EmpTerm term);
}
