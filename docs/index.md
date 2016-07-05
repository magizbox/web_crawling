# Java

I can code Java, but... <sup id="fnref-1452-2"><a href="#fn-1452-2" rel="footnote">1</a></sup>

<img src="http://i.imgur.com/9FD6bRh.png" alt="" />

Best Programming languages <sup id="fnref-1452-3"><a href="#fn-1452-3" rel="footnote">2</a></sup>

<img src="https://lh3.googleusercontent.com/I0vhc1CY8e7wIzUFw4D9bdv6q3xN3fMX5muciRQKGRuDJVwvYeGI=w591-h960-no" alt="" />

<h3>Installation <sup id="fnref-1452-1"><a href="#fn-1452-1" rel="footnote">3</a></sup></h3>

```
# cent os 6.5
yum install java-1.7.0-openjdk-devel
```

<h3>Concepts</h3>

Annotations

<h3>Tools</h3>

<table>
<tbody>
<tr>
<td style="text-align:center;width:50%;"><img src="https://cdn2.iconfinder.com/data/icons/ballicons-2-free/100/wrench-32.png" alt="" />
Build Tool</td>
<td style="text-align:center;width:50%;"><img src="http://icons.iconarchive.com/icons/graphicloads/polygon/32/check-2-icon.png" alt="" />
Test</td>
</tr>
<tr>
<td style="text-align:center;"><a href="https://gradle.org/" target="_blank">Gradle</a></td>
<td style="text-align:center;"><a href="http://junit.org/" target="_blank">JUnit</a></td>
</tr>
</tbody>
</table>

<div class="footnotes">
<hr />
<ol>

<li id="fn-1452-2">
<a href="http://www.codeproject.com/Articles/29036/Patterns-in-Real-Life">Patterns in Real Life</a>&#160;<a href="#fnref-1452-2" rev="footnote">&#8617;</a>
</li>

<li id="fn-1452-3">
<a href="http://biblipole.com/top-rated/best-programming-languages-771">Funny Story | Best Programming languages</a>&#160;<a href="#fnref-1452-3" rev="footnote">&#8617;</a>
</li>

<li id="fn-1452-1">
<a href="https://www.digitalocean.com/community/tutorials/how-to-install-java-on-centos-and-fedora">How To Install Java on CentOS and Fedora</a>&#160;<a href="#fnref-1452-1" rev="footnote">&#8617;</a>
</li>

</ol>
</div>

# Java: 101

# 1. Install

## Ubuntu

Step 1. Download sdk

```
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
```

Step 2. Create folder jvm

```
sudo mkdir /usr/lib/jvm/
```

Step 3. cd to folder downloads jdk and run command

```
sudo mv jdk1.7.0_x/ /usr/lib/jvm/jdk1.7.0_x
```

### Run install java
```
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0_x/jre/bin/java 0
```

Add path jdk : /usr/lib/jvm/jdk1.7.0_x

```
su -
nano /etc/environment
```

# 2. Hello World [^1]

```java
public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
    }

}
```

[^1]: [HelloWorld.java](http://introcs.cs.princeton.edu/java/11hello/HelloWorld.java.html)

# Java: Data Structure

# Java: datetime

```
Calendar c = Calendar.getInstance();
```

# Java: string, number

Convert [^1]

```java
String.valueOf(1000)
```

Make a random

```java
// create a random number from 0 to 99
(new Random()).nextInt(100)
```

[^1]: [How to convert from int to String?](http://stackoverflow.com/questions/4105331/how-to-convert-from-int-to-string)

# Java: collection

# Set

```java

import java.util.HashSet;
import java.util.Set;

public class HelloWorld{

     public static void main(String []args){
         Set<Dog> dogs = new  HashSet<Dog>();
         Dog dog1 = new Dog("a", 1);
         Dog dog2 = new Dog("a", 2);
         Dog dog3 = new Dog("a", 1);
         Dog dog4 = new Dog("b", 1);
         dogs.add( dog1);
         dogs.add( dog2);
         dogs.add( dog3);
         dogs.add( dog4);
        System.out.println(dogs.size());
     }
}

// 3
```

```java
public class Dog {
    public String name;
    public int age;
    public int value;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
        value = (this.name + String.valueOf(this.age)).hashCode();
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Dog && ((Dog) obj).value == this.value);
    }
}
```

## List [^1]

```
List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
```

[^1]: [Initialization of an ArrayList in one line](http://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line)

# Java: Parallel

Thread

### [Timer](https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html)

# Java: Configuration

-VM options : VM options are loaded from the IDE_HOME\bin\<product>[bits][.exe].vmoptions file.<a href="https://intellij-support.jetbrains.com/hc/en-us/articles/206827537-Configuring-JVM-options-and-platform-properties">[1]</a>
-ea : enable assertions
```
-ea -D[FILE_NAME]="$PATH_DATA"
```

# Java: Web with Spring

![](http://www.javatpoint.com/images/spimages/spring1.png)

<blockquote>
  <p>Spring helps development teams everywhere build simple, portable, fast and flexible JVM-based systems and applications.</p>
</blockquote>

<h3>Components</h3>

<p><strong>Spring Boot</strong>: Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.</p>

# Spring: Database

### Database Migration

[Flyway](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html)

# Java: IDE

# IntellIJ

```
├── 1. Project Manager
├── 2. Search & Replace
├── 3. Navigation
├── 4. Formatting
├── 5. Debugging
├── 6. Build & Release
└── 7. Git Integration
```

### 1. Project Manager

1.1 Create New Project

1.2 Import Maven Project

https://www.jetbrains.com/help/idea/2016.1/importing-project-from-maven-model.html

### 2. Search & Replace

<table>
<tr>
<td>Global Search</td>
<td><code>Shift Shift</code></td>
</tr>
</table>

### 3. Navigation

<table>
<tr>
<td>Next/Previous Error</td>
<td><code>F2</code> / <code>Shift + F2</code></td>
</tr>
</table>

### 4. Formatting

<table>
<tr>
<td>Auto Format</td>
<td><code>Ctrl + Alt + L</code></td>
</tr>
</table>

# Java: Package Manager

# Gradle

![](http://www.agilearts.nl/wp-content/uploads/2013/03/gradle.png)

### Plugins

#### [Application plugin](https://docs.gradle.org/current/userguide/application_plugin.html)

**Usages**

**1.** Using the application plugin

Add this line in `build.gradle`

```
apply plugin: 'application'
```

**2.**  Configure the application main class

```
mainClassName = "org.gradle.sample.Main"
```

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

# Java: Errors

# Two Many Open Files [^1] [^2]

Edit  `/etc/sysctl.conf`

```
fs.file-max = 100000
```

Spring, http://www.tomcatexpert.com/blog/2010/04/01/configuring-jdbc-pool-high-concurrency


[^1]: [Linux Increase The Maximum Number Of Open Files / File Descriptors (FD)](http://www.cyberciti.biz/faq/linux-increase-the-maximum-number-of-open-files/)
[^2]: [java 1="Too" 2="many" 3="open" 4="files" 5="Spring" 6="Hibernate" 7="Tomcat" language=".net.SocketException:"][/java](http://stackoverflow.com/questions/23252974/java-net-socketexception-too-many-open-files-spring-hibernate-tomcat)

# Java: Production (Docker)

Production with `java`

Base Image: [java][/java](https://hub.docker.com/_/java/)

Docker Folder

```
your-app/
├── app
│   ├── bin
│   ├───── your_app.sh
│   └── lib
├── Dockerfile
└── run.sh
```

`Dockerfile`

```
FROM java:7

COPY run.sh run.sh
```

`run.sh`

```
cd /app/bin
chmod u+x your_app.sh
./your_app.sh
```

Compose

```
 service:
  build: ./your_app
  command: 'bash run.sh'
```
