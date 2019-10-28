package cn.kgc.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/27 11:41
 * @Description:
 */
public class Emp {

    private Integer eid;
    private String ename;
    private String esex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date estartime;
    private Float epay;
    private Integer deptDid;

    /*部门实体*/
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer eid, String ename, String esex, Date estartime, Float epay, Integer deptDid, Dept dept) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.estartime = estartime;
        this.epay = epay;
        this.deptDid = deptDid;
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Date getEstartime() {
        return estartime;
    }

    public void setEstartime(Date estartime) {
        this.estartime = estartime;
    }

    public Float getEpay() {
        return epay;
    }

    public void setEpay(Float epay) {
        this.epay = epay;
    }

    public Integer getDeptDid() {
        return deptDid;
    }

    public void setDeptDid(Integer deptDid) {
        this.deptDid = deptDid;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", estartime=" + estartime +
                ", epay=" + epay +
                ", deptDid=" + deptDid +
                ", dept=" + dept +
                '}';
    }
}
