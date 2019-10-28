package cn.kgc.serivce.impl;

import cn.kgc.domain.Emp;
import cn.kgc.domain.EmpTerm;
import cn.kgc.mapper.EmpMapper;
import cn.kgc.serivce.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/27 11:49
 * @Description:
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Emp> findAll() {
        return empMapper.selectAll();
    }

    @Override
    public List<Emp> findBySome(EmpTerm term) {
        return empMapper.selectBySome(term);
    }
}
