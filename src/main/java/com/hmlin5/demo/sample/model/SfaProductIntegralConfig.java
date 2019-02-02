package com.hmlin5.demo.sample.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sfa_product_integral_config")
public class SfaProductIntegralConfig {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品编码
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 标准命名
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 单价下限
     */
    @Column(name = "lower_limit")
    private Double lowerLimit;

    /**
     * 单价上限
     */
    @Column(name = "upper_limit")
    private Double upperLimit;

    /**
     * 总经理积分标准
     */
    @Column(name = "top_leader_integral")
    private Double topLeaderIntegral;

    /**
     * 总经理积分标准单位
     */
    @Column(name = "top_leader_unit")
    private String topLeaderUnit;

    /**
     * 经理积分标准
     */
    @Column(name = "manager_integral")
    private Double managerIntegral;

    /**
     * 经理积分标准单位
     */
    @Column(name = "manager_unit")
    private String managerUnit;

    /**
     * 主任积分标准
     */
    @Column(name = "director_integral")
    private Double directorIntegral;

    /**
     * 主任积分标准单位
     */
    @Column(name = "director_unit")
    private String directorUnit;

    /**
     * 组长积分标准
     */
    @Column(name = "group_leader_integral")
    private Double groupLeaderIntegral;

    /**
     * 组长积分标准单位
     */
    @Column(name = "group_leader_unit")
    private String groupLeaderUnit;

    /**
     * 组员积分标准
     */
    @Column(name = "member_integral")
    private Double memberIntegral;

    /**
     * 组员积分标准单位
     */
    @Column(name = "member_unit")
    private String memberUnit;

    /**
     * 开始时间
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 修改人编码
     */
    @Column(name = "changed_code")
    private Integer changedCode;

    /**
     * 修改人姓名
     */
    @Column(name = "changed_name")
    private String changedName;

    /**
     * 修改时间
     */
    @Column(name = "changed_time")
    private Date changedTime;

    /**
     * 删除标识 0-有效 1-删除
     */
    @Column(name = "del_flag")
    private Integer delFlag;

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
     * 获取产品编码
     *
     * @return product_id - 产品编码
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品编码
     *
     * @param productId 产品编码
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取标准命名
     *
     * @return product_name - 标准命名
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置标准命名
     *
     * @param productName 标准命名
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取单价下限
     *
     * @return lower_limit - 单价下限
     */
    public Double getLowerLimit() {
        return lowerLimit;
    }

    /**
     * 设置单价下限
     *
     * @param lowerLimit 单价下限
     */
    public void setLowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     * 获取单价上限
     *
     * @return upper_limit - 单价上限
     */
    public Double getUpperLimit() {
        return upperLimit;
    }

    /**
     * 设置单价上限
     *
     * @param upperLimit 单价上限
     */
    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * 获取总经理积分标准
     *
     * @return top_leader_integral - 总经理积分标准
     */
    public Double getTopLeaderIntegral() {
        return topLeaderIntegral;
    }

    /**
     * 设置总经理积分标准
     *
     * @param topLeaderIntegral 总经理积分标准
     */
    public void setTopLeaderIntegral(Double topLeaderIntegral) {
        this.topLeaderIntegral = topLeaderIntegral;
    }

    /**
     * 获取总经理积分标准单位
     *
     * @return top_leader_unit - 总经理积分标准单位
     */
    public String getTopLeaderUnit() {
        return topLeaderUnit;
    }

    /**
     * 设置总经理积分标准单位
     *
     * @param topLeaderUnit 总经理积分标准单位
     */
    public void setTopLeaderUnit(String topLeaderUnit) {
        this.topLeaderUnit = topLeaderUnit;
    }

    /**
     * 获取经理积分标准
     *
     * @return manager_integral - 经理积分标准
     */
    public Double getManagerIntegral() {
        return managerIntegral;
    }

    /**
     * 设置经理积分标准
     *
     * @param managerIntegral 经理积分标准
     */
    public void setManagerIntegral(Double managerIntegral) {
        this.managerIntegral = managerIntegral;
    }

    /**
     * 获取经理积分标准单位
     *
     * @return manager_unit - 经理积分标准单位
     */
    public String getManagerUnit() {
        return managerUnit;
    }

    /**
     * 设置经理积分标准单位
     *
     * @param managerUnit 经理积分标准单位
     */
    public void setManagerUnit(String managerUnit) {
        this.managerUnit = managerUnit;
    }

    /**
     * 获取主任积分标准
     *
     * @return director_integral - 主任积分标准
     */
    public Double getDirectorIntegral() {
        return directorIntegral;
    }

    /**
     * 设置主任积分标准
     *
     * @param directorIntegral 主任积分标准
     */
    public void setDirectorIntegral(Double directorIntegral) {
        this.directorIntegral = directorIntegral;
    }

    /**
     * 获取主任积分标准单位
     *
     * @return director_unit - 主任积分标准单位
     */
    public String getDirectorUnit() {
        return directorUnit;
    }

    /**
     * 设置主任积分标准单位
     *
     * @param directorUnit 主任积分标准单位
     */
    public void setDirectorUnit(String directorUnit) {
        this.directorUnit = directorUnit;
    }

    /**
     * 获取组长积分标准
     *
     * @return group_leader_integral - 组长积分标准
     */
    public Double getGroupLeaderIntegral() {
        return groupLeaderIntegral;
    }

    /**
     * 设置组长积分标准
     *
     * @param groupLeaderIntegral 组长积分标准
     */
    public void setGroupLeaderIntegral(Double groupLeaderIntegral) {
        this.groupLeaderIntegral = groupLeaderIntegral;
    }

    /**
     * 获取组长积分标准单位
     *
     * @return group_leader_unit - 组长积分标准单位
     */
    public String getGroupLeaderUnit() {
        return groupLeaderUnit;
    }

    /**
     * 设置组长积分标准单位
     *
     * @param groupLeaderUnit 组长积分标准单位
     */
    public void setGroupLeaderUnit(String groupLeaderUnit) {
        this.groupLeaderUnit = groupLeaderUnit;
    }

    /**
     * 获取组员积分标准
     *
     * @return member_integral - 组员积分标准
     */
    public Double getMemberIntegral() {
        return memberIntegral;
    }

    /**
     * 设置组员积分标准
     *
     * @param memberIntegral 组员积分标准
     */
    public void setMemberIntegral(Double memberIntegral) {
        this.memberIntegral = memberIntegral;
    }

    /**
     * 获取组员积分标准单位
     *
     * @return member_unit - 组员积分标准单位
     */
    public String getMemberUnit() {
        return memberUnit;
    }

    /**
     * 设置组员积分标准单位
     *
     * @param memberUnit 组员积分标准单位
     */
    public void setMemberUnit(String memberUnit) {
        this.memberUnit = memberUnit;
    }

    /**
     * 获取开始时间
     *
     * @return start_date - 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始时间
     *
     * @param startDate 开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束时间
     *
     * @return end_date - 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取修改人编码
     *
     * @return changed_code - 修改人编码
     */
    public Integer getChangedCode() {
        return changedCode;
    }

    /**
     * 设置修改人编码
     *
     * @param changedCode 修改人编码
     */
    public void setChangedCode(Integer changedCode) {
        this.changedCode = changedCode;
    }

    /**
     * 获取修改人姓名
     *
     * @return changed_name - 修改人姓名
     */
    public String getChangedName() {
        return changedName;
    }

    /**
     * 设置修改人姓名
     *
     * @param changedName 修改人姓名
     */
    public void setChangedName(String changedName) {
        this.changedName = changedName;
    }

    /**
     * 获取修改时间
     *
     * @return changed_time - 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    public Date getChangedTime() {
        return changedTime;
    }

    /**
     * 设置修改时间
     *
     * @param changedTime 修改时间
     */
    public void setChangedTime(Date changedTime) {
        this.changedTime = changedTime;
    }

    /**
     * 获取删除标识 0-有效 1-删除
     *
     * @return del_flag - 删除标识 0-有效 1-删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标识 0-有效 1-删除
     *
     * @param delFlag 删除标识 0-有效 1-删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}