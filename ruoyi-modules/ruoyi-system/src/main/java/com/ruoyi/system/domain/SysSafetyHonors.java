package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 安全荣誉管理对象 sys_safety_honors
 * 
 * @author lijun
 * @date 2024-08-06
 */
public class SysSafetyHonors extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 荣誉名称 */
    @Excel(name = "荣誉名称")
    private String honoraryName;

    /** 荣誉类型 */
    @Excel(name = "荣誉类型")
    private String honoraryType;

    /** 所属监控中心 */
    @Excel(name = "所属监控中心")
    private String belongMonitorCenter;

    @Excel(name = "所属监控中心")
    private String monitorCenterName;

    public String getMonitorCenterName() {
        return monitorCenterName;
    }

    public void setMonitorCenterName(String monitorCenterName) {
        this.monitorCenterName = monitorCenterName;
    }

    /** 颁发单位/报道单位 */
    @Excel(name = "颁发单位/报道单位")
    private String issuedUnits;

    /** 颁发人/报道人 */
    @Excel(name = "颁发人/报道人")
    private String issuedPerson;

    /** 颁发时间/报道时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "颁发时间/报道时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issuedTime;

    /** 荣誉图片 */
    @Excel(name = "荣誉图片")
    private String honorPictures;

    /**
     * 用户id
     */
    public Long userId;

    /**
     * 部门ID
     */
    public Long deptId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHonoraryName(String honoraryName) 
    {
        this.honoraryName = honoraryName;
    }

    public String getHonoraryName() 
    {
        return honoraryName;
    }
    public void setHonoraryType(String honoraryType) 
    {
        this.honoraryType = honoraryType;
    }

    public String getHonoraryType() 
    {
        return honoraryType;
    }
    public void setBelongMonitorCenter(String belongMonitorCenter) 
    {
        this.belongMonitorCenter = belongMonitorCenter;
    }

    public String getBelongMonitorCenter() 
    {
        return belongMonitorCenter;
    }
    public void setIssuedUnits(String issuedUnits) 
    {
        this.issuedUnits = issuedUnits;
    }

    public String getIssuedUnits() 
    {
        return issuedUnits;
    }
    public void setIssuedPerson(String issuedPerson) 
    {
        this.issuedPerson = issuedPerson;
    }

    public String getIssuedPerson() 
    {
        return issuedPerson;
    }
    public void setIssuedTime(Date issuedTime) 
    {
        this.issuedTime = issuedTime;
    }

    public Date getIssuedTime() 
    {
        return issuedTime;
    }
    public void setHonorPictures(String honorPictures) 
    {
        this.honorPictures = honorPictures;
    }

    public String getHonorPictures() 
    {
        return honorPictures;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("honoraryName", getHonoraryName())
            .append("honoraryType", getHonoraryType())
            .append("belongMonitorCenter", getBelongMonitorCenter())
            .append("issuedUnits", getIssuedUnits())
            .append("issuedPerson", getIssuedPerson())
            .append("issuedTime", getIssuedTime())
            .append("remark", getRemark())
            .append("honorPictures", getHonorPictures())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
