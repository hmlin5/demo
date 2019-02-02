package com.hmlin5.demo.hrWagesDetail.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @ Author ：linhaomiao
 * @ Date   ：2018-11-21
 * @ Desc   ：封装基本查询参数的bean, 可以往里面添加查询字段, po类可以继承它
 */
public class BaseQueryBean {

    //分页参数
    private int pageIndex;  //当前页(miniui第一页为0)
    private int pageSize;   //页码大小

    //操作人参数
    private Integer changedCode;
    private String changedName;
    private Date ChangedTime;

    //HrWagesDetail 工资考勤明细查询参数
    HrWagesDetail hrWagesDetail ;
    List<HrWagesDetail> importList;
    private Date operationStartDate;
    private Date operationEndDate;
    private String payStartDate;
    private String payEndDate;
    private String empCodes;
    private String empNames;



    public int getPageIndex() {
        return pageIndex < 1 ? 1 : pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize < 0 ? 100 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getOperationStartDate() {
        return operationStartDate;
    }

    public void setOperationStartDate(Date operationStartDate) {
        this.operationStartDate = operationStartDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getOperationEndDate() {
        return operationEndDate;
    }

    public void setOperationEndDate(Date operationEndDate) {
        this.operationEndDate = operationEndDate;
    }

    public String getPayStartDate() {
        return payStartDate;
    }

    public void setPayStartDate(String payStartDate) {
        this.payStartDate = payStartDate;
    }

    public String getPayEndDate() {
        return payEndDate;
    }

    public void setPayEndDate(String payEndDate) {
        this.payEndDate = payEndDate;
    }

    public String getEmpCodes() {
        return empCodes;
    }

    public void setEmpCodes(String empCodes) {
        this.empCodes = empCodes;
    }

    public String getEmpNames() {
        return empNames;
    }

    public void setEmpNames(String empNames) {
        this.empNames = empNames;
    }

    public HrWagesDetail getHrWagesDetail() {
        return hrWagesDetail;
    }

    public void setHrWagesDetail(HrWagesDetail hrWagesDetail) {
        this.hrWagesDetail = hrWagesDetail;
    }

    public List<HrWagesDetail> getImportList() {
        return importList;
    }

    public void setImportList(List<HrWagesDetail> importList) {
        this.importList = importList;
    }

    public Integer getChangedCode() {
        return changedCode;
    }

    public void setChangedCode(Integer changedCode) {
        this.changedCode = changedCode;
    }

    public String getChangedName() {
        return changedName;
    }

    public void setChangedName(String changedName) {
        this.changedName = changedName;
    }

    public Date getChangedTime() {
        return ChangedTime;
    }

    public void setChangedTime(Date changedTime) {
        ChangedTime = changedTime;
    }
}
