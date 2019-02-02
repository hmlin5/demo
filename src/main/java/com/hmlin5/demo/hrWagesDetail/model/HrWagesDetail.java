package com.hmlin5.demo.hrWagesDetail.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Table(name = "hr_wages_detail")
public class HrWagesDetail {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工资发放年月, 比如201809
     */
    @Column(name = "pay_date")
    private Integer payDate;

    /**
     * 员工编号
     */
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 姓名
     */
    @Column(name = "emp_name")
    private String empName;

    /**
     * 基本工资
     */
    @Column(name = "base_wages")
    private BigDecimal baseWages;

    /**
     * 浮动部分
     */
    @Column(name = "float_wages")
    private BigDecimal floatWages;

    /**
     * 其他
     */
    @Column(name = "other_wages")
    private BigDecimal otherWages;

    /**
     * 应发工资
     */
    @Column(name = "total_pay_amount")
    private BigDecimal totalPayAmount;

    /**
     * 代缴社会保险费(个人)
     */
    @Column(name = "social_security_fee")
    private BigDecimal socialSecurityFee;

    /**
     * 代缴公积金(个人)
     */
    @Column(name = "accumulation_fund")
    private BigDecimal accumulationFund;

    /**
     * 代扣个人所得税
     */
    @Column(name = "personal_income_tax")
    private BigDecimal personalIncomeTax;

    /**
     * 代扣水费
     */
    @Column(name = "water_charge")
    private BigDecimal waterCharge;

    /**
     * 代扣电费
     */
    @Column(name = "electric_charge")
    private BigDecimal electricCharge;

    /**
     * 其他代扣代缴项目合计
     */
    @Column(name = "other_total_charge")
    private BigDecimal otherTotalCharge;

    /**
     * 扣回往月欠款
     */
    @Column(name = "monthly_arears")
    private BigDecimal monthlyArears;

    /**
     * 本月产生欠款
     */
    @Column(name = "this_month_arears")
    private BigDecimal thisMonthArears;

    /**
     * 实发工资
     */
    @Column(name = "final_pay_amount")
    private BigDecimal finalPayAmount;

    /**
     * 补发补扣说明
     */
    private String remarks;

    /**
     * 操作人编码
     */
    @Column(name = "changed_code")
    private Integer changedCode;

    /**
     * 操作人姓名
     */
    @Column(name = "changed_name")
    private String changedName;

    /**
     * 操作时间
     */
    @Column(name = "changed_time")
    private Date changedTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取工资发放年月, 比如201809
     *
     * @return pay_date - 工资发放年月, 比如201809
     */
    public Integer getPayDate() {
        return payDate;
    }

    /**
     * 设置工资发放年月, 比如201809
     *
     * @param payDate 工资发放年月, 比如201809
     */
    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取员工编号
     *
     * @return emp_id - 员工编号
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置员工编号
     *
     * @param empId 员工编号
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取姓名
     *
     * @return emp_name - 姓名
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置姓名
     *
     * @param empName 姓名
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取基本工资
     *
     * @return base_wages - 基本工资
     */
    public BigDecimal getBaseWages() {
       // return baseWages;
        return numFormat(baseWages);
    }

    /**
     * 设置基本工资
     *
     * @param baseWages 基本工资
     */
    public void setBaseWages(BigDecimal baseWages) {
        this.baseWages = baseWages;
    }

    /**
     * 获取浮动部分
     *
     * @return float_wages - 浮动部分
     */
    public BigDecimal getFloatWages() {
       // return floatWages;
        return numFormat(floatWages);
    }

    /**
     * 设置浮动部分
     *
     * @param floatWages 浮动部分
     */
    public void setFloatWages(BigDecimal floatWages) {
        this.floatWages = floatWages;
    }

    /**
     * 获取其他
     *
     * @return other_wages - 其他
     */
    public BigDecimal getOtherWages() {
//        return otherWages;
        return numFormat(otherWages);
    }


    /**
     * 设置其他
     *
     * @param otherWages 其他
     */
    public void setOtherWages(BigDecimal otherWages) {
        this.otherWages = otherWages;
    }

    /**
     * 获取应发工资
     *
     * @return total_pay_amount - 应发工资
     */
    public BigDecimal getTotalPayAmount() {
        //return totalPayAmount;
        return numFormat(totalPayAmount);
    }

    /**
     * 设置应发工资
     *
     * @param totalPayAmount 应发工资
     */
    public void setTotalPayAmount(BigDecimal totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    /**
     * 获取代缴社会保险费(个人)
     *
     * @return social_security_fee - 代缴社会保险费(个人)
     */
    public BigDecimal getSocialSecurityFee() {
       // return socialSecurityFee;
        return numFormat(socialSecurityFee);
    }

    /**
     * 设置代缴社会保险费(个人)
     *
     * @param socialSecurityFee 代缴社会保险费(个人)
     */
    public void setSocialSecurityFee(BigDecimal socialSecurityFee) {
        this.socialSecurityFee = socialSecurityFee;
    }

    /**
     * 获取代缴公积金(个人)
     *
     * @return accumulation_fund - 代缴公积金(个人)
     */
    public BigDecimal getAccumulationFund() {
       // return accumulationFund;
        return numFormat(accumulationFund);
    }

    /**
     * 设置代缴公积金(个人)
     *
     * @param accumulationFund 代缴公积金(个人)
     */
    public void setAccumulationFund(BigDecimal accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    /**
     * 获取代扣个人所得税
     *
     * @return personal_income_tax - 代扣个人所得税
     */
    public BigDecimal getPersonalIncomeTax() {
       // return personalIncomeTax;
        return numFormat(personalIncomeTax);
    }

    /**
     * 设置代扣个人所得税
     *
     * @param personalIncomeTax 代扣个人所得税
     */
    public void setPersonalIncomeTax(BigDecimal personalIncomeTax) {
        this.personalIncomeTax = personalIncomeTax;
    }

    /**
     * 获取代扣水费
     *
     * @return water_charge - 代扣水费
     */
    public BigDecimal getWaterCharge() {
       // return waterCharge;
        return numFormat(waterCharge);
    }

    /**
     * 设置代扣水费
     *
     * @param waterCharge 代扣水费
     */
    public void setWaterCharge(BigDecimal waterCharge) {
        this.waterCharge = waterCharge;
    }

    /**
     * 获取代扣电费
     *
     * @return electric_charge - 代扣电费
     */
    public BigDecimal getElectricCharge() {
       // return electricCharge;
        return numFormat(electricCharge);
    }

    /**
     * 设置代扣电费
     *
     * @param electricCharge 代扣电费
     */
    public void setElectricCharge(BigDecimal electricCharge) {
        this.electricCharge = electricCharge;
    }

    /**
     * 获取其他代扣代缴项目合计
     *
     * @return other_total_charge - 其他代扣代缴项目合计
     */
    public BigDecimal getOtherTotalCharge() {
        //return otherTotalCharge;
        return numFormat(otherTotalCharge);
    }

    /**
     * 设置其他代扣代缴项目合计
     *
     * @param otherTotalCharge 其他代扣代缴项目合计
     */
    public void setOtherTotalCharge(BigDecimal otherTotalCharge) {
        this.otherTotalCharge = otherTotalCharge;
    }

    /**
     * 获取扣回往月欠款
     *
     * @return monthly_arears - 扣回往月欠款
     */
    public BigDecimal getMonthlyArears() {
       // return monthlyArears;
        return numFormat(monthlyArears);
    }

    /**
     * 设置扣回往月欠款
     *
     * @param monthlyArears 扣回往月欠款
     */
    public void setMonthlyArears(BigDecimal monthlyArears) {
        this.monthlyArears = monthlyArears;
    }

    /**
     * 获取本月产生欠款
     *
     * @return this_month_arears - 本月产生欠款
     */
    public BigDecimal getThisMonthArears() {
        //return thisMonthArears;
        return numFormat(thisMonthArears);
    }

    /**
     * 设置本月产生欠款
     *
     * @param thisMonthArears 本月产生欠款
     */
    public void setThisMonthArears(BigDecimal thisMonthArears) {
        this.thisMonthArears = thisMonthArears;
    }

    /**
     * 获取实发工资
     *
     * @return final_pay_amount - 实发工资
     */
    public BigDecimal getFinalPayAmount() {
       // return finalPayAmount;
        return numFormat(finalPayAmount);
    }

    /**
     * 设置实发工资
     *
     * @param finalPayAmount 实发工资
     */
    public void setFinalPayAmount(BigDecimal finalPayAmount) {
        this.finalPayAmount = finalPayAmount;
    }

    /**
     * 获取补发补扣说明
     *
     * @return remarks - 补发补扣说明
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置补发补扣说明
     *
     * @param remarks 补发补扣说明
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取操作人编码
     *
     * @return changed_code - 操作人编码
     */
    public Integer getChangedCode() {
        return changedCode;
    }

    /**
     * 设置操作人编码
     *
     * @param changedCode 操作人编码
     */
    public void setChangedCode(Integer changedCode) {
        this.changedCode = changedCode;
    }

    /**
     * 获取操作人姓名
     *
     * @return changed_name - 操作人姓名
     */
    public String getChangedName() {
        return changedName;
    }

    /**
     * 设置操作人姓名
     *
     * @param changedName 操作人姓名
     */
    public void setChangedName(String changedName) {
        this.changedName = changedName;
    }

    /**
     * 获取操作时间
     *
     * @return changed_time - 操作时间
     */
    public Date getChangedTime() {
        return changedTime;
    }

    /**
     * 设置操作时间
     *
     * @param changedTime 操作时间
     */
    public void setChangedTime(Date changedTime) {
        this.changedTime = changedTime;
    }

    private BigDecimal numFormat(BigDecimal num){

        if((num+"").endsWith(".00")){
            DecimalFormat df = new DecimalFormat("#.##");
            String format = df.format(num);
            return new BigDecimal(format);
        }

        return num;
    }
}