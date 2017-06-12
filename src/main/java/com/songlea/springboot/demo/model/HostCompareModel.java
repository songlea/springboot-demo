package com.songlea.springboot.demo.model;

import java.io.Serializable;

/**
 * CI_HOST主机表(只取差异数据,即需要更新的10个字段)
 *
 * @author Song Lea
 */
public class HostCompareModel extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id; // 主键
    private long hostId; // 对应CI_HOST表的ID字段
    private String name; // 名称
    private String manageIp;
    private String hostName;
    private String cpuFamily;
    private String operateSystem;
    private String osVersion;
    private String serialNumber;
    private String manufacturerText;
    private Integer physicalCpus;
    private Long memorySize;
    private Integer diskCount;
    private Long totalDiskSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManageIp() {
        return manageIp;
    }

    public void setManageIp(String manageIp) {
        this.manageIp = manageIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCpuFamily() {
        return cpuFamily;
    }

    public void setCpuFamily(String cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    public String getOperateSystem() {
        return operateSystem;
    }

    public void setOperateSystem(String operateSystem) {
        this.operateSystem = operateSystem;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturerText() {
        return manufacturerText;
    }

    public void setManufacturerText(String manufacturerText) {
        this.manufacturerText = manufacturerText;
    }

    public Integer getPhysicalCpus() {
        return physicalCpus;
    }

    public void setPhysicalCpus(Integer physicalCpus) {
        this.physicalCpus = physicalCpus;
    }

    public Long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    public Integer getDiskCount() {
        return diskCount;
    }

    public void setDiskCount(Integer diskCount) {
        this.diskCount = diskCount;
    }

    public Long getTotalDiskSize() {
        return totalDiskSize;
    }

    public void setTotalDiskSize(Long totalDiskSize) {
        this.totalDiskSize = totalDiskSize;
    }

    @Override
    public String toString() {
        return "HostCompareModel{" +
                "id=" + id +
                ", hostId=" + hostId +
                ", name='" + name + '\'' +
                ", manageIp='" + manageIp + '\'' +
                ", hostName='" + hostName + '\'' +
                ", cpuFamily='" + cpuFamily + '\'' +
                ", operateSystem='" + operateSystem + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturerText='" + manufacturerText + '\'' +
                ", physicalCpus=" + physicalCpus +
                ", memorySize=" + memorySize +
                ", diskCount=" + diskCount +
                ", totalDiskSize=" + totalDiskSize +
                '}';
    }
}