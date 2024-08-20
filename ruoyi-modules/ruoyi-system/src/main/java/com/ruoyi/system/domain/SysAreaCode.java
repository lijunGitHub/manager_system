package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 行政区划查询对象 sys_area_code
 *
 * @author lijun
 * @date 2024-08-14
 */
public class SysAreaCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;

    /** 级别 */
    @Excel(name = "级别")
    private String level;

    /** 父级编码 */
    @Excel(name = "父级编码")
    private String parentCode;

    /** 区域编码 */
    @Excel(name = "区域编码")
    private String areaCode;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private Integer zipCode;

    /** 区号 */
    @Excel(name = "区号")
    private String cityCode;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 简称 */
    @Excel(name = "简称")
    private String shortName;

    /** 组合名 */
    @Excel(name = "组合名")
    private String mergerName;

    /** 拼音 */
    @Excel(name = "拼音")
    private String pinyin;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal lat;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }
    public void setParentCode(String parentCode)
    {
        this.parentCode = parentCode;
    }

    public String getParentCode()
    {
        return parentCode;
    }
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setZipCode(Integer zipCode)
    {
        this.zipCode = zipCode;
    }

    public Integer getZipCode()
    {
        return zipCode;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getShortName()
    {
        return shortName;
    }
    public void setMergerName(String mergerName)
    {
        this.mergerName = mergerName;
    }

    public String getMergerName()
    {
        return mergerName;
    }
    public void setPinyin(String pinyin)
    {
        this.pinyin = pinyin;
    }

    public String getPinyin()
    {
        return pinyin;
    }
    public void setLng(BigDecimal lng)
    {
        this.lng = lng;
    }

    public BigDecimal getLng()
    {
        return lng;
    }
    public void setLat(BigDecimal lat)
    {
        this.lat = lat;
    }

    public BigDecimal getLat()
    {
        return lat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("level", getLevel())
                .append("parentCode", getParentCode())
                .append("areaCode", getAreaCode())
                .append("zipCode", getZipCode())
                .append("cityCode", getCityCode())
                .append("name", getName())
                .append("shortName", getShortName())
                .append("mergerName", getMergerName())
                .append("pinyin", getPinyin())
                .append("lng", getLng())
                .append("lat", getLat())
                .toString();
    }
}
