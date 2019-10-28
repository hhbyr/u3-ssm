package cn.kgc.serivce;

import cn.kgc.domain.Dept;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/29 09:35
 * @Description:
 */
public interface DeptService {

    List<Dept> findDeptAll();
}
