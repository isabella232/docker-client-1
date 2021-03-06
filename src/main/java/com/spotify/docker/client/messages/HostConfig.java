/*
 * Copyright (c) 2014 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class HostConfig {

  @JsonProperty("Binds") private ImmutableList<String> binds;
  @JsonProperty("ContainerIDFile") private String containerIDFile;
  @JsonProperty("LxcConf") private ImmutableList<LxcConfParameter> lxcConf;
  @JsonProperty("Privileged") private Boolean privileged;
  @JsonProperty("PortBindings") private Map<String, List<PortBinding>> portBindings;
  @JsonProperty("Links") private ImmutableList<String> links;
  @JsonProperty("PublishAllPorts") private Boolean publishAllPorts;
  @JsonProperty("Dns") private ImmutableList<String> dns;
  @JsonProperty("DnsSearch") private ImmutableList<String> dnsSearch;
  @JsonProperty("ExtraHosts") private ImmutableList<String> extraHosts;
  @JsonProperty("VolumesFrom") private ImmutableList<String> volumesFrom;
  @JsonProperty("CapAdd") private ImmutableList<String> capAdd;
  @JsonProperty("CapDrop") private ImmutableList<String> capDrop;
  @JsonProperty("NetworkMode") private String networkMode;
  @JsonProperty("SecurityOpt") private ImmutableList<String> securityOpt;
  @JsonProperty("Devices") private ImmutableList<Device> devices;
  @JsonProperty("Memory") private Long memory;
  @JsonProperty("MemorySwap") private Long memorySwap;
  @JsonProperty("CpuShares") private Long cpuShares;
  @JsonProperty("CpusetCpus") private String cpusetCpus;
  @JsonProperty("CpuQuota") private Long cpuQuota;
  @JsonProperty("CgroupParent") private String cgroupParent;
  @JsonProperty("RestartPolicy") private RestartPolicy restartPolicy;
  @JsonProperty("LogConfig") private LogConfig logConfig;
  @JsonProperty("IpcMode") private String ipcMode;

  private HostConfig() {
  }

  private HostConfig(final Builder builder) {
    this.binds = builder.binds;
    this.containerIDFile = builder.containerIDFile;
    this.lxcConf = builder.lxcConf;
    this.privileged = builder.privileged;
    this.portBindings = builder.portBindings;
    this.links = builder.links;
    this.publishAllPorts = builder.publishAllPorts;
    this.dns = builder.dns;
    this.dnsSearch = builder.dnsSearch;
    this.extraHosts = builder.extraHosts;
    this.volumesFrom = builder.volumesFrom;
    this.capAdd = builder.capAdd;
    this.capDrop = builder.capDrop;
    this.networkMode = builder.networkMode;
    this.securityOpt = builder.securityOpt;
    this.devices = builder.devices;
    this.memory = builder.memory;
    this.memorySwap = builder.memorySwap;
    this.cpuShares = builder.cpuShares;
    this.cpusetCpus = builder.cpusetCpus;
    this.cpuQuota = builder.cpuQuota;
    this.cgroupParent = builder.cgroupParent;
    this.restartPolicy = builder.restartPolicy;
    this.logConfig = builder.logConfig;
    this.ipcMode = builder.ipcMode;
  }

  public List<String> binds() {
    return binds;
  }

  public String containerIDFile() {
    return containerIDFile;
  }

  public List<LxcConfParameter> lxcConf() {
    return lxcConf;
  }

  public Boolean privileged() {
    return privileged;
  }

  public Map<String, List<PortBinding>> portBindings() {
    return (portBindings == null) ? null : Collections.unmodifiableMap(portBindings);
  }

  public List<String> links() {
    return links;
  }

  public Boolean publishAllPorts() {
    return publishAllPorts;
  }

  public List<String> dns() {
    return dns;
  }

  public List<String> dnsSearch() {
    return dnsSearch;
  }

  public List<String> extraHosts() {
    return extraHosts;
  }

  public List<String> volumesFrom() {
    return volumesFrom;
  }

  public List<String> capAdd() {
    return capAdd;
  }

  public List<String> capDrop() {
    return capDrop;
  }

  public String networkMode() {
    return networkMode;
  }

  public List<String> securityOpt() {
    return securityOpt;
  }

  public List<Device> devices() {
    return devices;
  }

  public Long memory() {
    return memory;
  }

  public Long memorySwap() {
    return memorySwap;
  }

  public Long cpuShares() {
    return cpuShares;
  }

  public String cpusetCpus() {
    return cpusetCpus;
  }

  public Long cpuQuota() {
    return cpuQuota;
  }

  public String cgroupParent() {
    return cgroupParent;
  }

  public RestartPolicy restartPolicy() {
    return restartPolicy;
  }

  public LogConfig logConfig() {
    return logConfig;
  }

  public String ipcMode() {
    return ipcMode;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final HostConfig that = (HostConfig) o;

    if (binds != null ? !binds.equals(that.binds) : that.binds != null) {
      return false;
    }
    if (containerIDFile != null ? !containerIDFile.equals(that.containerIDFile)
                                : that.containerIDFile != null) {
      return false;
    }
    if (dns != null ? !dns.equals(that.dns) : that.dns != null) {
      return false;
    }
    if (dnsSearch != null ? !dnsSearch.equals(that.dnsSearch) : that.dnsSearch != null) {
      return false;
    }
    if (extraHosts != null ? !extraHosts.equals(that.extraHosts) : that.extraHosts != null) {
      return false;
    }
    if (links != null ? !links.equals(that.links) : that.links != null) {
      return false;
    }
    if (lxcConf != null ? !lxcConf.equals(that.lxcConf) : that.lxcConf != null) {
      return false;
    }
    if (networkMode != null ? !networkMode.equals(that.networkMode) : that.networkMode != null) {
      return false;
    }
    if (portBindings != null ? !portBindings.equals(that.portBindings)
                             : that.portBindings != null) {
      return false;
    }
    if (privileged != null ? !privileged.equals(that.privileged) : that.privileged != null) {
      return false;
    }
    if (publishAllPorts != null ? !publishAllPorts.equals(that.publishAllPorts)
                                : that.publishAllPorts != null) {
      return false;
    }
    if (volumesFrom != null ? !volumesFrom.equals(that.volumesFrom) : that.volumesFrom != null) {
      return false;
    }
    if (capAdd != null ? !capAdd.equals(that.capAdd) : that.capAdd != null) {
      return false;
    }
    if (capDrop != null ? !capDrop.equals(that.capDrop) : that.capDrop != null) {
      return false;
    }
    if (securityOpt != null ? !securityOpt.equals(that.securityOpt) : that.securityOpt != null) {
      return false;
    }
    if (devices != null ? !devices.equals(that.devices) : that.devices != null) {
      return false;
    }

    if (memory != null ? !memory.equals(that.memory) : that.memory != null) {
      return false;
    }

    if (memorySwap != null ? !memorySwap.equals(that.memorySwap) : that.memorySwap != null) {
      return false;
    }

    if (cpuShares != null ? !cpuShares.equals(that.cpuShares) : that.cpuShares != null) {
      return false;
    }

    if (cpusetCpus != null ? !cpusetCpus.equals(that.cpusetCpus) : that.cpusetCpus != null) {
      return false;
    }

    if (cpuQuota != null ? !cpuQuota.equals(that.cpuQuota) : that.cpuQuota != null) {
      return false;
    }

    if (cgroupParent != null ? !cgroupParent.equals(that.cgroupParent)
                             : that.cgroupParent != null) {
      return false;
    }

    if (restartPolicy != null ? !restartPolicy.equals(that.restartPolicy)
                              : that.restartPolicy != null) {
      return false;
    }

    if (logConfig != null ? !logConfig.equals(that.logConfig) : that.logConfig != null) {
      return false;
    }

    if (ipcMode != null ? !ipcMode.equals(that.ipcMode)
            : that.ipcMode != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(binds, containerIDFile, lxcConf, privileged, portBindings, links,
                        publishAllPorts, dns, dnsSearch, extraHosts, volumesFrom, capAdd,
                        capDrop, networkMode, securityOpt, devices, memory, memorySwap,
                        cpuShares, cpusetCpus, cpuQuota, cgroupParent, restartPolicy, logConfig,
                        ipcMode);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("binds", binds)
        .add("containerIDFile", containerIDFile)
        .add("lxcConf", lxcConf)
        .add("privileged", privileged)
        .add("portBindings", portBindings)
        .add("links", links)
        .add("publishAllPorts", publishAllPorts)
        .add("dns", dns)
        .add("dnsSearch", dnsSearch)
        .add("extraHosts", extraHosts)
        .add("volumesFrom", volumesFrom)
        .add("capAdd", capAdd)
        .add("capDrop", capDrop)
        .add("networkMode", networkMode)
        .add("securityOpt", securityOpt)
        .add("devices", devices)
        .add("memory", memory)
        .add("memorySwap", memorySwap)
        .add("cpuShares", cpuShares)
        .add("cpusetCpus", cpusetCpus)
        .add("cpuQuota", cpuQuota)
        .add("cgroupParent", cgroupParent)
        .add("restartPolicy", restartPolicy)
        .add("logConfig", logConfig)
        .add("ipcMode", ipcMode)
        .toString();
  }

  public static class LxcConfParameter {

    @JsonProperty("Key") private String key;
    @JsonProperty("Value") private String value;

    public LxcConfParameter(final String key, final String value) {
      this.key = key;
      this.value = value;
    }

    public String key() {
      return key;
    }

    public String value() {
      return value;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final LxcConfParameter that = (LxcConfParameter) o;

      if (key != null ? !key.equals(that.key) : that.key != null) {
        return false;
      }
      if (value != null ? !value.equals(that.value) : that.value != null) {
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("key", key)
          .add("value", value)
          .toString();
    }
  }

  public static class RestartPolicy {

    @JsonProperty("Name") private String name;
    @JsonProperty("MaximumRetryCount") private Integer maxRetryCount;

    public static RestartPolicy always() {
      return new RestartPolicy("always", null);
    }

    public static RestartPolicy unlessStopped() {
      return new RestartPolicy("unless-stopped", null);
    }

    public static RestartPolicy onFailure(Integer maxRetryCount) {
      return new RestartPolicy("on-failure", maxRetryCount);
    }

    // for mapper
    private RestartPolicy() {
    }

    private RestartPolicy(String name, Integer maxRetryCount) {
      this.name = name;
      this.maxRetryCount = maxRetryCount;
    }

    public String name() {
      return name;
    }

    public Integer maxRetryCount() {
      return maxRetryCount;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final RestartPolicy that = (RestartPolicy) o;

      if (name != null ? !name.equals(that.name) : that.name != null) {
        return false;
      }
      return maxRetryCount != null ?
             maxRetryCount.equals(that.maxRetryCount) : that.maxRetryCount == null;
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, maxRetryCount);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", name)
          .add("maxRetryCount", maxRetryCount)
          .toString();
    }
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private ImmutableList<String> binds;
    private String containerIDFile;
    private ImmutableList<LxcConfParameter> lxcConf;
    private Boolean privileged;
    private Map<String, List<PortBinding>> portBindings;
    private ImmutableList<String> links;
    private Boolean publishAllPorts;
    private ImmutableList<String> dns;
    private ImmutableList<String> dnsSearch;
    private ImmutableList<String> extraHosts;
    private ImmutableList<String> volumesFrom;
    private ImmutableList<String> capAdd;
    private ImmutableList<String> capDrop;
    private String networkMode;
    private ImmutableList<String> securityOpt;
    private ImmutableList<Device> devices;
    public Long memory;
    public Long memorySwap;
    public Long cpuShares;
    public String cpusetCpus;
    public Long cpuQuota;
    public String cgroupParent;
    public RestartPolicy restartPolicy;
    public LogConfig logConfig;
    public String ipcMode;

    private Builder() {
    }

    private Builder(final HostConfig hostConfig) {
      this.binds = hostConfig.binds;
      this.containerIDFile = hostConfig.containerIDFile;
      this.lxcConf = hostConfig.lxcConf;
      this.privileged = hostConfig.privileged;
      this.portBindings = hostConfig.portBindings;
      this.links = hostConfig.links;
      this.publishAllPorts = hostConfig.publishAllPorts;
      this.dns = hostConfig.dns;
      this.dnsSearch = hostConfig.dnsSearch;
      this.extraHosts = hostConfig.extraHosts;
      this.volumesFrom = hostConfig.volumesFrom;
      this.capAdd = hostConfig.capAdd;
      this.capDrop = hostConfig.capDrop;
      this.networkMode = hostConfig.networkMode;
      this.securityOpt = hostConfig.securityOpt;
      this.devices = hostConfig.devices;
      this.memory = hostConfig.memory;
      this.memorySwap = hostConfig.memorySwap;
      this.cpuShares = hostConfig.cpuShares;
      this.cpusetCpus = hostConfig.cpusetCpus;
      this.cpuQuota = hostConfig.cpuQuota;
      this.cgroupParent = hostConfig.cgroupParent;
      this.restartPolicy = hostConfig.restartPolicy;
      this.logConfig = hostConfig.logConfig;
      this.ipcMode = hostConfig.ipcMode;
    }

    /**
     * Set the list of binds to the parameter, replacing any existing value.
     * <p>To append to the list instead, use one of the appendBinds() methods.</p>
     */
    public Builder binds(final List<String> binds) {
      if (binds != null && !binds.isEmpty()) {
        this.binds = copyWithoutDuplicates(binds);
      }

      return this;
    }

    /**
     * Set the list of binds to the parameter, replacing any existing value.
     * <p>To append to the list instead, use one of the appendBinds() methods.</p>
     */
    public Builder binds(final String... binds) {
      if (binds != null && binds.length > 0) {
        return binds(Lists.newArrayList(binds));
      }

      return this;
    }

    /**
     * Set the list of binds to the parameter, replacing any existing value.
     * <p>To append to the list instead, use one of the appendBinds() methods.</p>
     */
    public Builder binds(final Bind... binds) {
      if (binds == null || binds.length == 0) {
        return this;
      }

      return binds(toStringList(binds));
    }

    private static List<String> toStringList(final Bind[] binds) {
      final List<String> bindStrings = Lists.newArrayList();
      for (final Bind bind : binds) {
        bindStrings.add(bind.toString());
      }
      return bindStrings;
    }

    /** Append binds to the existing list in this builder. */
    public Builder appendBinds(final Iterable<String> newBinds) {
      final List<String> list = new ArrayList<>();
      if (this.binds != null) {
        list.addAll(this.binds);
      }
      list.addAll(Lists.newArrayList(newBinds));
      this.binds = copyWithoutDuplicates(list);

      return this;
    }

    /** Append binds to the existing list in this builder. */
    public Builder appendBinds(final Bind... binds) {
      appendBinds(toStringList(binds));
      return this;
    }

    /** Append binds to the existing list in this builder. */
    public Builder appendBinds(final String... binds) {
      appendBinds(Lists.newArrayList(binds));
      return this;
    }

    private static <T> ImmutableList<T> copyWithoutDuplicates(final List<T> input) {
      final List<T> list = new ArrayList<>(input.size());
      for (final T element : input) {
        if (!list.contains(element)) {
          list.add(element);
        }
      }
      return ImmutableList.copyOf(list);
    }

    public List<String> binds() {
      return binds;
    }

    public Builder containerIDFile(final String containerIDFile) {
      this.containerIDFile = containerIDFile;
      return this;
    }

    public String containerIDFile() {
      return containerIDFile;
    }

    public Builder lxcConf(final List<LxcConfParameter> lxcConf) {
      if (lxcConf != null && !lxcConf.isEmpty()) {
        this.lxcConf = ImmutableList.copyOf(lxcConf);
      }
      return this;
    }

    public Builder lxcConf(final LxcConfParameter... lxcConf) {
      if (lxcConf != null && lxcConf.length > 0) {
        this.lxcConf = ImmutableList.copyOf(lxcConf);
      }

      return this;
    }

    public List<LxcConfParameter> lxcConf() {
      return lxcConf;
    }

    public Builder privileged(final Boolean privileged) {
      this.privileged = privileged;
      return this;
    }

    public Boolean privileged() {
      return privileged;
    }

    public Builder portBindings(final Map<String, List<PortBinding>> portBindings) {
      if (portBindings != null && !portBindings.isEmpty()) {
        this.portBindings = Maps.newHashMap(portBindings);
      }
      return this;
    }

    public Map<String, List<PortBinding>> portBindings() {
      return portBindings;
    }

    public Builder links(final List<String> links) {
      if (links != null && !links.isEmpty()) {
        this.links = ImmutableList.copyOf(links);
      }

      return this;
    }

    public Builder links(final String... links) {
      if (links != null && links.length > 0) {
        this.links = ImmutableList.copyOf(links);
      }

      return this;
    }

    public List<String> links() {
      return links;
    }

    public Builder publishAllPorts(final Boolean publishAllPorts) {
      this.publishAllPorts = publishAllPorts;
      return this;
    }

    public Boolean publishAllPorts() {
      return publishAllPorts;
    }

    public Builder dns(final List<String> dns) {
      if (dns != null && !dns.isEmpty()) {
        this.dns = ImmutableList.copyOf(dns);
      }

      return this;
    }

    public Builder dns(final String... dns) {
      if (dns != null && dns.length > 0) {
        this.dns = ImmutableList.copyOf(dns);
      }

      return this;
    }

    public List<String> dns() {
      return dns;
    }

    public Builder dnsSearch(final List<String> dnsSearch) {
      if (dnsSearch != null && !dnsSearch.isEmpty()) {
        this.dnsSearch = ImmutableList.copyOf(dnsSearch);
      }

      return this;
    }

    public Builder dnsSearch(final String... dnsSearch) {
      if (dnsSearch != null && dnsSearch.length > 0) {
        this.dnsSearch = ImmutableList.copyOf(dnsSearch);
      }

      return this;
    }

    public List<String> dnsSearch() {
      return dnsSearch;
    }

    public Builder extraHosts(final List<String> extraHosts) {
      if (extraHosts != null && !extraHosts.isEmpty()) {
        this.extraHosts = ImmutableList.copyOf(extraHosts);
      }

      return this;
    }

    public Builder extraHosts(final String... extraHosts) {
      if (extraHosts != null && extraHosts.length > 0) {
        this.extraHosts = ImmutableList.copyOf(extraHosts);
      }

      return this;
    }

    public List<String> extraHosts() {
      return extraHosts;
    }

    public Builder volumesFrom(final List<String> volumesFrom) {
      if (volumesFrom != null && !volumesFrom.isEmpty()) {
        this.volumesFrom = ImmutableList.copyOf(volumesFrom);
      }

      return this;
    }

    public Builder volumesFrom(final String... volumesFrom) {
      if (volumesFrom != null && volumesFrom.length > 0) {
        this.volumesFrom = ImmutableList.copyOf(volumesFrom);
      }

      return this;
    }

    public List<String> volumesFrom() {
      return volumesFrom;
    }

    public Builder capAdd(final List<String> capAdd) {
      if (capAdd != null && !capAdd.isEmpty()) {
        this.capAdd = ImmutableList.copyOf(capAdd);
      }

      return this;
    }

    public Builder capAdd(final String... capAdd) {
      if (capAdd != null && capAdd.length > 0) {
        this.capAdd = ImmutableList.copyOf(capAdd);
      }

      return this;
    }

    public List<String> capAdd() {
      return capAdd;
    }

    public Builder capDrop(final List<String> capDrop) {
      if (capDrop != null && !capDrop.isEmpty()) {
        this.capDrop = ImmutableList.copyOf(capDrop);
      }

      return this;
    }

    public Builder capDrop(final String... capDrop) {
      if (capDrop != null && capDrop.length > 0) {
        this.capDrop = ImmutableList.copyOf(capDrop);
      }

      return this;
    }

    public List<String> capDrop() {
      return capDrop;
    }

    public Builder networkMode(final String networkMode) {
      this.networkMode = networkMode;
      return this;
    }

    public String networkMode() {
      return networkMode;
    }

    public Builder securityOpt(final List<String> securityOpt) {
      if (securityOpt != null && !securityOpt.isEmpty()) {
        this.securityOpt = ImmutableList.copyOf(securityOpt);
      }

      return this;
    }

    public Builder securityOpt(final String... securityOpt) {
      if (securityOpt != null && securityOpt.length > 0) {
        this.securityOpt = ImmutableList.copyOf(securityOpt);
      }

      return this;
    }

    public List<String> securityOpt() {
      return securityOpt;
    }

    public Builder devices(final List<Device> devices) {
      if (devices != null && !devices.isEmpty()) {
        this.devices = ImmutableList.copyOf(devices);
      }
      return this;
    }

    public Builder devices(final Device... devices) {
      if (devices != null && devices.length > 0) {
        this.devices = ImmutableList.copyOf(devices);
      }

      return this;
    }

    public List<Device> devices() {
      return devices;
    }

    public Builder memory(final Long memory) {
      this.memory = memory;
      return this;
    }

    public Long memory() {
      return memory;
    }

    public Builder memorySwap(final Long memorySwap) {
      this.memorySwap = memorySwap;
      return this;
    }

    public Long memorySwap() {
      return memorySwap;
    }

    public Builder cpuShares(final Long cpuShares) {
      this.cpuShares = cpuShares;
      return this;
    }

    public Long cpuShares() {
      return cpuShares;
    }

    public Builder cpusetCpus(final String cpusetCpus) {
      this.cpusetCpus = cpusetCpus;
      return this;
    }

    public String cpusetCpus() {
      return cpusetCpus;
    }

    public Builder cpuQuota(final Long cpuQuota) {
      this.cpuQuota = cpuQuota;
      return this;
    }

    public Long cpuQuota() {
      return cpuQuota;
    }

    public Builder cgroupParent(final String cgroupParent) {
      this.cgroupParent = cgroupParent;
      return this;
    }

    public String cgroupParent() {
      return cgroupParent;
    }

    public Builder restartPolicy(final RestartPolicy restartPolicy) {
      this.restartPolicy = restartPolicy;
      return this;
    }

    public Builder logConfig(final LogConfig logConfig) {
      this.logConfig = logConfig;
      return this;
    }

    public RestartPolicy restartPolicy() {
      return restartPolicy;
    }

    public LogConfig logConfig() {
      return logConfig;
    }

    public Builder ipcMode(final String ipcMode) {
      this.ipcMode = ipcMode;
      return this;
    }

    public String ipcMode() {
      return ipcMode;
    }

    public HostConfig build() {
      return new HostConfig(this);
    }
  }

  public static class Bind {
    private String to;
    private String from;
    private Boolean readOnly;

    private Bind(final Builder builder) {
      this.to = builder.to;
      this.from = builder.from;
      this.readOnly = builder.readOnly;
    }

    public static BuilderTo to(final String to) {
      return new BuilderTo(to);
    }

    public static BuilderFrom from(final String from) {
      return new BuilderFrom(from);
    }

    public String toString() {
      if (to == null || to.equals("")) {
        return "";
      } else if (from == null || from.equals("")) {
        return to;
      } else if (readOnly == null || !readOnly) {
        return from + ":" + to;
      } else {
        return from + ":" + to + ":ro";
      }
    }

    public static class BuilderTo {
      private String to;

      public BuilderTo(final String to) {
        this.to = to;
      }

      public Builder from(final String from) {
        return new Builder(this, from);
      }
    }

    public static class BuilderFrom {
      private String from;

      public BuilderFrom(final String from) {
        this.from = from;
      }

      public Bind.Builder to(final String to) {
        return new Builder(this, to);
      }
    }

    public static class Builder {
      private String to;
      private String from;
      private Boolean readOnly = false;

      private Builder() {}

      private Builder(final BuilderTo toBuilder, final String from) {
        this.to = toBuilder.to;
        this.from = from;
      }

      private Builder(final BuilderFrom fromBuilder, final String to) {
        this.to = to;
        this.from = fromBuilder.from;
      }

      public Builder to(final String to) {
        this.to = to;
        return this;
      }

      public String to() {
        return to;
      }

      public Builder from(final String from) {
        this.from = from;
        return this;
      }

      public String from() {
        return from;
      }

      public Builder readOnly(final Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
      }

      public Boolean readOnly() {
        return readOnly;
      }

      public Bind build() {
        return new Bind(this);
      }
    }
  }
}
