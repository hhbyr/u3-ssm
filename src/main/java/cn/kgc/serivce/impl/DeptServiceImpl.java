package cn.kgc.serivce.impl;

import cn.kgc.domain.Dept;
import cn.kgc.mapper.DeptMapper;
import cn.kgc.serivce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/29 09:35
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findDeptAll() {
        return deptMapper.selectDeptAll();
    }
}
