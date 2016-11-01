# Java: Build Tool

# Apache Ant

![](https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Apache-Ant-logo.svg/554px-Apache-Ant-logo.svg.png)

Apache Ant is a Java library and command-line tool whose mission is to drive processes described in build files as targets and extension points dependent upon each other. The main known usage of Ant is the build of Java applications. Ant supplies a number of built-in tasks allowing to compile, assemble, test and run Java applications. Ant can also be used effectively to build non Java applications, for instance C or C++ applications. More generally, Ant can be used to pilot any type of process which can be described in terms of targets and tasks. [^1]

### Install Ant

Download and extract Apache Ant 1.9.6

```
wget http://mirrors.viethosting.vn/apache//ant/binaries/apache-ant-1.9.6-bin.tar.gz
tar -xzf apache-ant-1.9.6-bin.tar.gz
```

Set path to ant folder

<h3>Build Ant through proxy</h3>

<strong>Requirement: 1.9.5+</strong>

Add the following lines into <code>build.xml</code>

```
<target name="ivy-init" depends="ivy-proxy, ivy-probe-antlib, ivy-init-antlib" description="--> initialise Ivy settings">
  <ivy:settings file="${ivy.dir}/ivysettings.xml" />
  </target>
 <target name="ivy-proxy" description="-->Proxy Ivy settings">
  <property name="proxy.host" value="proxy.com" />
  <property name="proxy.port" value="8080" />
  <property name="proxy.user" value="user" />
  <property name="proxy.password" value="password" />
  <setproxy
    proxyhost="${proxy.host}"
    proxyport="${proxy.port}"
    proxyuser="${proxy.user}"
    proxypassword="${proxy.password}" />
 </target>
```

[^1]: [Apache Ant™](http://ant.apache.org/)

