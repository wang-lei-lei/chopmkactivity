package com.cmos.chopmkactivity.beans.emp;

import com.cmos.common.bean.GenericBean;
import java.math.BigDecimal;
import java.util.Date;

public class Emp extends GenericBean {
    private Long empno;

    private String ename;

    private String job;

    private Long mgr;

    private Date hiredate;

    private BigDecimal sal;

    private BigDecimal comm;

    private BigDecimal deptno;

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Long getMgr() {
        return mgr;
    }

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public BigDecimal getDeptno() {
        return deptno;
    }

    public void setDeptno(BigDecimal deptno) {
        this.deptno = deptno;
    }
}