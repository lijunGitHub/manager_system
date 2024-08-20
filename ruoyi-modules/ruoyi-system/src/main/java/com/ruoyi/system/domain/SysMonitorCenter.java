package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 监控中心管理对象 sys_monitor_center
 *
 * @author lijun
 * @date 2024-08-07
 */
public class SysMonitorCenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 监控中心名称 */
    @Excel(name = "监控中心名称")
    private String monitorCenterName;

    /** 地址区域 */
    @Excel(name = "地址区域")
    private String address;

    /** 上级监控中心 */
    @Excel(name = "上级监控中心")
    private Long monitorCenterParentId;

    /** 上级监控中心名称 */
    @Excel(name = "上级监控中心名称")
    private String monitorCenterParentName;

    /** 中心级别 */
    @Excel(name = "中心级别")
    private Long centerLevel;

    /** 是否为分公司 */
    @Excel(name = "是否为分公司")
    private Integer isBranchOffice;

    /** 所属分公司ID */
    @Excel(name = "所属分公司ID")
    private Long affiliatedBranches;

    /** 所属分公司名称 */
    @Excel(name = "所属分公司名称")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /** 监控中心电话 */
    @Excel(name = "监控中心电话")
    private String monitorCenterPhone;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String responsiblePersonName;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String responsiblePersonPhone;

    /** 守护人员 */
    @Excel(name = "守护人员")
    private Long guardians;

    /** 守护区域 */
    @Excel(name = "守护区域")
    private Long guardianArea;

    /** 镇街数量 */
    @Excel(name = "镇街数量")
    private Long townNumber;

    /** 社区数量 */
    @Excel(name = "社区数量")
    private Long communityNumber;

    /** 监控中心详址（可地图选点） */
    @Excel(name = "监控中心详址", readConverterExp = "可=地图选点")
    private String monitorCenterDetailAddress;

    /** 经纬度 */
    @Excel(name = "经纬度")
    private String latAndLon;

    /** 大屏地图层级 */
    @Excel(name = "大屏地图层级")
    private Long largeScreenMapLevel;

    /** 告警处置 */
    @Excel(name = "告警处置")
    private Integer handleAlarms;

    /** 设备统计 */
    @Excel(name = "设备统计")
    private Integer deviceStatistics;

    /** 全景图（图片上传） */
    @Excel(name = "全景图", readConverterExp = "图=片上传")
    private String panorama;

    /** 火灾处置单是否站内消息通知 */
    @Excel(name = "火灾处置单是否站内消息通知")
    private Integer fireDisposalOrderIsnotify;


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
    public void setMonitorCenterName(String monitorCenterName)
    {
        this.monitorCenterName = monitorCenterName;
    }

    public String getMonitorCenterName()
    {
        return monitorCenterName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setMonitorCenterParentId(Long monitorCenterParentId)
    {
        this.monitorCenterParentId = monitorCenterParentId;
    }

    public Long getMonitorCenterParentId()
    {
        return monitorCenterParentId;
    }
    public void setMonitorCenterParentName(String monitorCenterParentName)
    {
        this.monitorCenterParentName = monitorCenterParentName;
    }

    public String getMonitorCenterParentName()
    {
        return monitorCenterParentName;
    }
    public void setCenterLevel(Long centerLevel)
    {
        this.centerLevel = centerLevel;
    }

    public Long getCenterLevel()
    {
        return centerLevel;
    }
    public void setIsBranchOffice(Integer isBranchOffice)
    {
        this.isBranchOffice = isBranchOffice;
    }

    public Integer getIsBranchOffice()
    {
        return isBranchOffice;
    }
    public void setAffiliatedBranches(Long affiliatedBranches)
    {
        this.affiliatedBranches = affiliatedBranches;
    }

    public Long getAffiliatedBranches()
    {
        return affiliatedBranches;
    }
    public void setMonitorCenterPhone(String monitorCenterPhone)
    {
        this.monitorCenterPhone = monitorCenterPhone;
    }

    public String getMonitorCenterPhone()
    {
        return monitorCenterPhone;
    }
    public void setResponsiblePersonName(String responsiblePersonName)
    {
        this.responsiblePersonName = responsiblePersonName;
    }

    public String getResponsiblePersonName()
    {
        return responsiblePersonName;
    }
    public void setResponsiblePersonPhone(String responsiblePersonPhone)
    {
        this.responsiblePersonPhone = responsiblePersonPhone;
    }

    public String getResponsiblePersonPhone()
    {
        return responsiblePersonPhone;
    }
    public void setGuardians(Long guardians)
    {
        this.guardians = guardians;
    }

    public Long getGuardians()
    {
        return guardians;
    }
    public void setGuardianArea(Long guardianArea)
    {
        this.guardianArea = guardianArea;
    }

    public Long getGuardianArea()
    {
        return guardianArea;
    }
    public void setTownNumber(Long townNumber)
    {
        this.townNumber = townNumber;
    }

    public Long getTownNumber()
    {
        return townNumber;
    }
    public void setCommunityNumber(Long communityNumber)
    {
        this.communityNumber = communityNumber;
    }

    public Long getCommunityNumber()
    {
        return communityNumber;
    }
    public void setMonitorCenterDetailAddress(String monitorCenterDetailAddress)
    {
        this.monitorCenterDetailAddress = monitorCenterDetailAddress;
    }

    public String getMonitorCenterDetailAddress()
    {
        return monitorCenterDetailAddress;
    }
    public void setLatAndLon(String latAndLon)
    {
        this.latAndLon = latAndLon;
    }

    public String getLatAndLon()
    {
        return latAndLon;
    }
    public void setLargeScreenMapLevel(Long largeScreenMapLevel)
    {
        this.largeScreenMapLevel = largeScreenMapLevel;
    }

    public Long getLargeScreenMapLevel()
    {
        return largeScreenMapLevel;
    }
    public void setHandleAlarms(Integer handleAlarms)
    {
        this.handleAlarms = handleAlarms;
    }

    public Integer getHandleAlarms()
    {
        return handleAlarms;
    }
    public void setDeviceStatistics(Integer deviceStatistics)
    {
        this.deviceStatistics = deviceStatistics;
    }

    public Integer getDeviceStatistics()
    {
        return deviceStatistics;
    }
    public void setPanorama(String panorama)
    {
        this.panorama = panorama;
    }

    public String getPanorama()
    {
        return panorama;
    }
    public void setFireDisposalOrderIsnotify(Integer fireDisposalOrderIsnotify)
    {
        this.fireDisposalOrderIsnotify = fireDisposalOrderIsnotify;
    }

    public Integer getFireDisposalOrderIsnotify()
    {
        return fireDisposalOrderIsnotify;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("monitorCenterName", getMonitorCenterName())
                .append("address", getAddress())
                .append("monitorCenterParentId", getMonitorCenterParentId())
                .append("monitorCenterParentName", getMonitorCenterParentName())
                .append("centerLevel", getCenterLevel())
                .append("isBranchOffice", getIsBranchOffice())
                .append("affiliatedBranches", getAffiliatedBranches())
                .append("monitorCenterPhone", getMonitorCenterPhone())
                .append("responsiblePersonName", getResponsiblePersonName())
                .append("responsiblePersonPhone", getResponsiblePersonPhone())
                .append("guardians", getGuardians())
                .append("guardianArea", getGuardianArea())
                .append("townNumber", getTownNumber())
                .append("communityNumber", getCommunityNumber())
                .append("monitorCenterDetailAddress", getMonitorCenterDetailAddress())
                .append("latAndLon", getLatAndLon())
                .append("largeScreenMapLevel", getLargeScreenMapLevel())
                .append("handleAlarms", getHandleAlarms())
                .append("deviceStatistics", getDeviceStatistics())
                .append("panorama", getPanorama())
                .append("fireDisposalOrderIsnotify", getFireDisposalOrderIsnotify())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }
}
