package cn.kgc.domain;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/29 08:38
 * @Description:
 */
public class Dept {

    private Integer did;
    private String dname;
    private String dtel;

    public Dept() {
    }

    public Dept(Integer did, String dname, String dtel) {
        this.did = did;
        this.dname = dname;
        this.dtel = dtel;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dtel='" + dtel + '\'' +
                '}';
    }
}
