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


# Java: Errors

# Two Many Open Files [^1] [^2]

Edit  `/etc/sysctl.conf`

```
fs.file-max = 100000
```

Spring, http://www.tomcatexpert.com/blog/2010/04/01/configuring-jdbc-pool-high-concurrency


[^1]: [Linux Increase The Maximum Number Of Open Files / File Descriptors (FD)](http://www.cyberciti.biz/faq/linux-increase-the-maximum-number-of-open-files/)
[^2]: [java 1="Too" 2="many" 3="open" 4="files" 5="Spring" 6="Hibernate" 7="Tomcat" language=".net.SocketException:"][/java](http://stackoverflow.com/questions/23252974/java-net-socketexception-too-many-open-files-spring-hibernate-tomcat)

