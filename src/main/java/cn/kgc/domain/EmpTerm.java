package cn.kgc.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/29 08:55
 * @Description: 封装页面上传递的参数=查询参数
 */
public class EmpTerm {

    /*searchName:一定要跟表单上的名字完全一样！*/
    private String searchName;
    private Float startEpay;
    private Float endEpay;
    /**
     * @DateTimeFormat(pattern = "yyyy-MM--dd"):表示把前台传递的string类型的
     * 日期，转换成Date格式的日期。
     * pattern = "yyyy-MM-dd":指定格式化的样式
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private Integer searchDid;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Float getStartEpay() {
        return startEpay;
    }

    public void setStartEpay(Float startEpay) {
        this.startEpay = startEpay;
    }

    public Float getEndEpay() {
        return endEpay;
    }

    public void setEndEpay(Float endEpay) {
        this.endEpay = endEpay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSearchDid() {
        return searchDid;
    }

    public void setSearchDid(Integer searchDid) {
        this.searchDid = searchDid;
    }
}
