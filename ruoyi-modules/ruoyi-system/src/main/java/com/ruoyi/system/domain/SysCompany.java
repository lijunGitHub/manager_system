package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 公司信息对象 sys_company
 * 
 * @author ijun
 * @date 2024-08-03
 */
public class SysCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公司ID */
    private Long companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司别名/简称 */
    private String companyAlias;

    /** 公司类型 */
    @Excel(name = "公司类型")
    private String companyType;

    /** 行业分类 */
    @Excel(name = "行业分类")
    private String industry;

    /** 公司规模 */
    @Excel(name = "公司规模")
    private String companySize;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date establishmentDate;

    /** 注册地址 */
    @Excel(name = "注册地址")
    private String registeredAddress;

    /** 办公地址 */
    @Excel(name = "办公地址")
    private String officeAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String email;

    /** 网站URL */
    @Excel(name = "网站URL")
    private String website;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String legalRepresentative;

    /** 注册资本 */
    @Excel(name = "注册资本")
    private BigDecimal registeredCapital;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String creditCode;

    /** 营业期限 */
    @Excel(name = "营业期限")
    private String businessPeriod;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String businessScope;

    /** 简介 */
    @Excel(name = "简介")
    private String description;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;
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

    public void setCompanyId(Long companyId)
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyAlias(String companyAlias) 
    {
        this.companyAlias = companyAlias;
    }

    public String getCompanyAlias() 
    {
        return companyAlias;
    }
    public void setCompanyType(String companyType) 
    {
        this.companyType = companyType;
    }

    public String getCompanyType() 
    {
        return companyType;
    }
    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }
    public void setCompanySize(String companySize) 
    {
        this.companySize = companySize;
    }

    public String getCompanySize() 
    {
        return companySize;
    }
    public void setEstablishmentDate(Date establishmentDate) 
    {
        this.establishmentDate = establishmentDate;
    }

    public Date getEstablishmentDate() 
    {
        return establishmentDate;
    }
    public void setRegisteredAddress(String registeredAddress) 
    {
        this.registeredAddress = registeredAddress;
    }

    public String getRegisteredAddress() 
    {
        return registeredAddress;
    }
    public void setOfficeAddress(String officeAddress) 
    {
        this.officeAddress = officeAddress;
    }

    public String getOfficeAddress() 
    {
        return officeAddress;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public String getWebsite() 
    {
        return website;
    }
    public void setLegalRepresentative(String legalRepresentative) 
    {
        this.legalRepresentative = legalRepresentative;
    }

    public String getLegalRepresentative() 
    {
        return legalRepresentative;
    }
    public void setRegisteredCapital(BigDecimal registeredCapital) 
    {
        this.registeredCapital = registeredCapital;
    }

    public BigDecimal getRegisteredCapital() 
    {
        return registeredCapital;
    }
    public void setCreditCode(String creditCode) 
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode() 
    {
        return creditCode;
    }
    public void setBusinessPeriod(String businessPeriod) 
    {
        this.businessPeriod = businessPeriod;
    }

    public String getBusinessPeriod() 
    {
        return businessPeriod;
    }
    public void setBusinessScope(String businessScope) 
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope() 
    {
        return businessScope;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyAlias", getCompanyAlias())
            .append("companyType", getCompanyType())
            .append("industry", getIndustry())
            .append("companySize", getCompanySize())
            .append("establishmentDate", getEstablishmentDate())
            .append("registeredAddress", getRegisteredAddress())
            .append("officeAddress", getOfficeAddress())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("website", getWebsite())
            .append("legalRepresentative", getLegalRepresentative())
            .append("registeredCapital", getRegisteredCapital())
            .append("creditCode", getCreditCode())
            .append("businessPeriod", getBusinessPeriod())
            .append("businessScope", getBusinessScope())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
