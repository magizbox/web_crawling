# Config nutch run intellij

Copy file

copy all the files in the `runtime/conf` on `out/test/apache-Nutch-2.3 and out/production/apache-Nutch-2.3`

add these lines to file `$NUTCH_SRC/out/test/nutch-site.xml`

```
<property>
   <name>plugin.folders</name>
   <value><nutch_src>/build/plugins</value>
 </property>
```

### Run nutch in intellij
```
Run->Edit Configurations...->add path agrs:path to file list links crawler
```

# Dev Nutch in Intellij

Receipts: `IntellIJ 14`, `Apache Nutch 2.3`

**1.** Get Nutch source

```shell
wget http://www.eu.apache.org/dist/nutch/2.3/apache-nutch-2.3-src.tar.gz
tar -xzf apache-nutch-2.3-src.tar.gz
```

**2.** Import Nutch source in IntellIJ

[wonderplugin_slider id="1"]

<div style="clear:both; height:80px;"></div>

**3.** Get Dependencies by Ant

[wonderplugin_slider id="3"]

<div style="clear:both; height:80px;"></div>

**4.** Import Dependencies to IntellIJ

[wonderplugin_slider id="4"]

<div style="clear:both; height:80px;"></div>

# Nutch Dev

1.Intasll java in ubuntu

-Downloads java version .zip
```xml
 http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
```

-Create folder jvm
```xml
 sudo mkdir /usr/lib/jvm/
```

-Cd to folder downloads java version .zip
```xml
 sudo mv jdk1.7.0_x/ /usr/lib/jvm/jdk1.7.0_x
```

-Run command line
```xml
  sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0_x/jre/bin/java 0
```

-Tets version java
```xml
  java -version
```

2.Intasll ant in ubuntu

-Downloads ant
```xml
http://ant.apache.org/manualdownload.cgi
```

-Add path ant vao file environment
```xml
 sudo nano /etc/environment
 $ANT_ROOT/bin
```

-Run command line
```xml
source /etc/environment
ant -version
```

3.Intasll hbase in ubuntu

-Downloads and extract hbase 0.94.27
```xml
  https://archive.apache.org/dist/hbase/hbase-0.94.27/
```

-Edit file $HABSE_ROOT/conf/hbase-site.xml
```xml
 <configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///$PATH_DATA_BASE/database</value>
  </property>
  <property>
    <name>hbase.cluster.distributed</name>
    <value>false</value>
  </property>
  <property>
    <name>hbase.zookeeper.quorum</name>
    <value>hbase.io</value>
  </property>
  <property>
    <name>zookeeper.znode.parent</name>
    <value>/hbase-unsecure</value>
  </property>
  <property>
    <name>hbase.rpc.timeout</name>
    <value>2592000000</value>
  </property>
</configuration>
```

-Edit file $HBASE_ROOT/conf/hbase-env.sh
```xml
  export JAVA_HOME=$PATH_JAVA_HOME
```

-Edit file $HBASE_ROOT/conf/regionservers
```xml
hbase.io.nutch
```

-Edit file hosts in ubuntu
```xml
  sudo nano /etc/hosts
  {ip} hbase.io.nutch
```

-Edit file hostname in ubuntu
```xml
 sudo nano /etc/hostname
 hbase.io.nutch
```

-Run and stop hbase in ubuntu
```
 Run hbase : cd $HBASE_ROOT/bin ./start-hbase.sh
 Stop hbase: cd $HBASE_ROOT/bin ./stop-hbase.sh
```

*Error in intasll hbase
```xml
- Error regionserver localhost(Edit file hosts and file host name)
- Error client no remote server intasll hbase(Turn off file firewall)
```

4.Build nutch in ant

-Downloads and extract nutch
```xml
  http://nutch.apache.org/
```

-Edit file $NUTCH_ROOT/ivy/ivy.xml
```xml
 <dependency org="org.apache.gora" name="gora-hbase" rev="0.5"
conf="*->default" />
```

-Edit file $NUTCH_ROOT/ivy/ivysettings.xml
```xml
 #<property name="repo.maven.org"
 #   value="http://repo1.maven.org/maven2/"
 #  override="false"/>

<property name = "repo.maven.org"
   value = "http://maven.oschina.net/content/groups/public/"
   override = "false" />
```

-Edit file $NUTCH_ROOT/conf/nutch-site.xml
```xml
<configuration>
<property>
   <name>plugin.folders</name>
   <value>$NUTCH_ROOT/build/plugins</value>
 </property>
<property>
        <name>http.agent.name</name>
        <value>mycrawlername</value>
        <!-- this can be changed to something more sane if you like -->
    </property>
    <property>
        <name>http.robots.agents</name>
        <value>mycrawlername</value>
        <!-- this is the robot name we're looking for in robots.txt files -->
    </property>
    <property>
        <name>storage.data.store.class</name>
        <value>org.apache.gora.hbase.store.HBaseStore</value>
    </property>
    <property>
        <name>plugin.includes</name>
        <!-- do \*\*NOT\*\* enable the parse-html plugin, if you want proper HTML parsing. Use something like parse-tika! -->
        <value>
            protocol-http|protocol-httpclient|urlfilter-regex|parse-(text|tika|js)|index-(basic|anchor)|query-(basic|site|url)|response-(json|xml)|summary-basic|scoring-opic|urlnormalizer-(pass|regex|basic)|indexer-elastic|index-metadata|index-more
        </value>
    </property>
    <property>
        <name>db.ignore.external.links</name>
        <value>true</value>
        <!-- do not leave the seeded domains (optional) -->
    </property>


<!-- elasticsearch index properties -->
<property>
  <name>elastic.host</name>
  <value>localhost</value>
  <description>The hostname to send documents to using TransportClient.
  Either host and port must be defined or cluster.
  </description>
</property>

<property>
  <name>elastic.port</name>
  <value>9300</value>
  <description>
  The port to connect to using TransportClient.
  </description>
</property>
<property>
  <name>elastic.index</name>
  <value>nutch</value>
  <description>
  The name of the elasticsearch index. Will normally be autocreated if it
  doesn't exist.
  </description>
</property>
<!-- end index -->

<property>
        <name>http.proxy.host</name>
        <value>192.168.80.1</value>
    </property>
    <property>
        <name>http.proxy.port</name>
        <value>8080</value>
    </property>
    <property>
        <name>http.proxy.username</name>
        <value>user1</value>
    </property>
    <property>
        <name>http.proxy.password</name>
        <value>user1</value>
    </property>
</configuration>
```

-Edit file file $NUTCH_ROOT/conf/gora.property
```xml
 gora.datastore.default=org.apache.gora.hbase.store.HBaseStore
```

-Build nucth
```xml
 ant runtime
 or
 ant eclipse -verbose
```

-Create file links

-Run nutch

```xml
 cd $NUTCH_ROOT/runtime/local/bin
 run inject : ./nutch inject file:///$PATH_LIKNS
 run generate : ./nutch generate -topN 10
 run fetch : ./nutch fetch -all
 run parse : ./nutch parse -all
 run updatedb : ./nutch updatedb -all
```

-Downloads and extract elastic

```xml
 https://www.elastic.co/downloads/elasticsearch
```

-Run elastic

```xml
cd $ELASTIC/bin
./elasticsearch
```

-Index data in elastic

```xml
 cd $NUTCH_ROOT/runtime/bin
 run index : ./nutch index -all
```

5.Run nutch intellij

Change `$NUTCH_ROOT/runtime/local/conf/hbase-site.xml`

```xml
<configuration>
<property>
<name>hbase.rootdir</name>
<value>file:///home/hainv/Downloads/crawler/data</value>
</property>
<property>
<name>hbase.cluster.distributed</name>
<value>false</value>
</property>
<property>
<name>hbase.zookeeper.quorum</name>
<value>hbase.io</value>
</property>
<property>
<name>zookeeper.znode.parent</name>
<value>/hbase-unsecure</value>
</property>
<property>
<name>hbase.rpc.timeout</name>
<value>2592000000</value>
</property>
</configuration>
```

# Nutch plugin intellij

### 1.Structure nutch :<a href="https://fossies.org/dox/apache-nutch-2.3-src/classorg_1_1apache_1_1nutch_1_1parse_1_1html_1_1DOMBuilder.html">[1]</a>

### 2.Run nutch intellij
 Downloads nucth2.3:<a href ="http://nutch.apache.org/downloads.html">http://nutch.apache.org/downloads.html</a>
 Editing file $NUTCH_ROOT/ivy/ivysettings.xml
```xml
<ivysettings>
  <property name="oss.sonatype.org"
    value="http://oss.sonatype.org/content/repositories/releases/"
    override="false"/>
  <property name = "repo.maven.org"
      value = "http://maven.oschina.net/content/groups/public/"
      override = "false" />
  <property name="repository.apache.org"
    value="https://repository.apache.org/content/repositories/snapshots/"
    override="false"/>
  <property name="maven2.pattern"
    value="[organisation]/[module]/[revision]/[module]-[revision]"/>
  <property name="maven2.pattern.ext"
    value="${maven2.pattern}.[ext]"/>
  <!-- pull in the local repository -->
  <include url="${ivy.default.conf.dir}/ivyconf-local.xml"/>
  <settings defaultResolver="default"/>
  <resolvers>
    <ibiblio name="maven2"
      root="${repo.maven.org}"
      pattern="${maven2.pattern.ext}"
      m2compatible="true"
      />
    <ibiblio name="apache-snapshot"
      root="${repository.apache.org}"
      changingPattern=".*-SNAPSHOT"
      m2compatible="true"
      />
    <ibiblio name="restlet"
      root="http://maven.restlet.org"
      pattern="${maven2.pattern.ext}"
      m2compatible="true"
      />
     <ibiblio name="sonatype"
      root="${oss.sonatype.org}"
      pattern="${maven2.pattern.ext}"
      m2compatible="true"
      />

    <chain name="default" dual="true">
      <resolver ref="local"/>
      <resolver ref="maven2"/>
      <resolver ref="sonatype"/>
      <resolver ref="apache-snapshot"/>
    </chain>
    <chain name="internal">
      <resolver ref="local"/>
    </chain>
    <chain name="external">
      <resolver ref="maven2"/>
      <resolver ref="sonatype"/>
    </chain>
    <chain name="external-and-snapshots">
      <resolver ref="maven2"/>
      <resolver ref="apache-snapshot"/>
      <resolver ref="sonatype"/>
    </chain>
    <chain name="restletchain">
      <resolver ref="restlet"/>
    </chain>
  </resolvers>
  <modules>
    <module organisation="org.apache.nutch" name=".*" resolver="internal"/>
    <module organisation="org.restlet" name=".*" resolver="restletchain"/>
    <module organisation="org.restlet.jse" name=".*" resolver="restletchain"/>
  </modules>
</ivysettings>
```

Editing file $NUTCH_ROOT/ivy/ivy.xml
```xml
<dependency org="org.apache.gora" name="gora-hbase" rev="0.5" conf="*->default" />
```

Editing file $NUCTH_ROOT/conf/gora.properties
```xml
gora.datastore.default=org.apache.gora.hbase.store.HBaseStore
```

Editing file $NUTCH_ROOT/conf/nutch_site.xml
```xml
<configuration>
<property>
   <name>plugin.folders</name>
   <value>$NUTCH_ROOT/build/plugins</value>
 </property>
<property>
        <name>http.agent.name</name>
        <value>mycrawlername</value>
        <!-- this can be changed to something more sane if you like -->
    </property>
    <property>
        <name>http.robots.agents</name>
        <value>mycrawlername</value>
        <!-- this is the robot name we're looking for in robots.txt files -->
    </property>
    <property>
        <name>storage.data.store.class</name>
        <value>org.apache.gora.hbase.store.HBaseStore</value>
    </property>
    <property>
        <name>plugin.includes</name>
        <!-- do \*\*NOT\*\* enable the parse-html plugin, if you want proper HTML parsing. Use something like parse-tika! -->
        <value>
            protocol-httpclient|urlfilter-regex|parse-(text|tika|js)|index-(basic|anchor)|query-(basic|site|url)|response-(json|xml)|summary-basic|scoring-opic|urlnormalizer-(pass|regex|basic)|indexer-elastic
        </value>
    </property>
    <property>
        <name>db.ignore.external.links</name>
        <value>true</value>
        <!-- do not leave the seeded domains (optional) -->
    </property>
    <property>
        <name>elastic.host</name>
        <value>localhost</value>
        <!-- where is ElasticSearch listening -->
    </property>

<property>
        <name>http.proxy.host</name>
        <value>192.168.80.1</value>
        <description>The proxy hostname. If empty, no proxy is used.</description>
    </property>
    <property>
        <name>http.proxy.port</name>
        <value>8080</value>
        <description>The proxy port.</description>
    </property>
    <property>
        <name>http.proxy.username</name>
        <value>user1</value>
        <description>Username for proxy. This will be used by 'protocol-httpclient', if the proxy server requests basic,
            digest
            and/or NTLM authentication. To use this, 'protocol-httpclient' must be present in the value of
            'plugin.includes'
            property. NOTE: For NTLM authentication, do not prefix the username with the domain, i.e. 'susam' is correct
            whereas
            'DOMAINsusam' is incorrect.
        </description>
    </property>
    <property>
        <name>http.proxy.password</name>
        <value>user1</value>
        <description>Password for proxy. This will be used by 'protocol-httpclient', if the proxy server requests basic,
            digest
            and/or NTLM authentication. To use this, 'protocol-httpclient' must be present in the value of
            'plugin.includes'
            property.
        </description>
    </property>
</configuration>
```

Editing file $NUCTH_ROOT/conf/hbase-site.xml
```xml
<configuration>
	<property>
		<name>hbase.rootdir</name>
		<value>file:///home/rombk/Downloads/database</value>
	</property>
	<property>
		<name>hbase.cluster.distributed</name>
		<value>false</value>
	</property>
	<property>
		<name>hbase.zookeeper.quorum</name>
		<value>hbase.io</value>
	</property>
	<property>
		<name>zookeeper.znode.parent</name>
		<value>/hbase-unsecure</value>
	</property>
	<property>
		<name>hbase.rpc.timeout</name>
		<value>2592000000</value>
	</property>
</configuration>
```

Run terminal
```xml
 ant eclipse -verbose
```

Import nucth intellij
```xml

```

### 3.Run plugin creativecommons
Sample plugins that parse and index Creative Commons medadata.<a href="https://nutch.apache.org/apidocs/apidocs-1.7/org/creativecommons/nutch/package-summary.html">1</a>
Step 1. Create folder creativecommons in path `$NUTCH_HOME/out/test/`

Step 2. Create file `nutch-site.xml` in folder `$NUTCH_HOME/out/test/creativecommons`  and add content

```xml
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<!-- Put site-specific property overrides in this file. -->
<configuration>
<property>
   <name>plugin.folders</name>
   <value>$NUTCH_HOME/build/plugins</value>
 </property>
<property>
   <name>http.agent.name</name>
   <value>mycrawlername</value>
<!-- this can be changed to something more sane if you like -->
</property>
<property>
   <name>http.robots.agents</name>
   <value>mycrawlername</value>
<!-- this is the robot name we're looking for in robots.txt files -->
</property>
<property>
   <name>storage.data.store.class</name>
   <value>org.apache.gora.hbase.store.HBaseStore</value>
</property>
<property>
   <name>plugin.includes</name>
  <!-- do \*\*NOT\*\* enable the parse-html plugin, if you want proper HTML parsing. Use something like parse-tika! -->
  <value>indexer-elastic|creativecommons|parse-html</value>
</property>
<property>
   <name>db.ignore.external.links</name>
   <value>true</value>
<!-- do not leave the seeded domains (optional) -->
</property>
<property>
   <name>elastic.host</name>
   <value>localhost</value>
<!-- where is ElasticSearch listening -->
</property>
<!-- config proxy-->
<property>
   <name>http.proxy.host</name>
   <value><hosts></value>
   <description>The proxy hostname. If empty, no proxy is used.</description>
</property>
<property>
   <name>http.proxy.port</name>
   <value><port></value>
   <description>The proxy port.</description>
</property>
<property>
   <name>http.proxy.username</name>
   <value><user1></value>
   <description>Username for proxy. This will be used by 'protocol-httpclient', if the proxy server requests basic,
digest
and/or NTLM authentication. To use this, 'protocol-httpclient' must be present in the value of
'plugin.includes'
property. NOTE: For NTLM authentication, do not prefix the username with the domain, i.e. 'susam' is correct
whereas
'DOMAINsusam' is incorrect.
     </description>
</property>
<property>
   <name>http.proxy.password</name>
   <value><user1></value>
   <description>Password for proxy. This will be used by 'protocol-httpclient', if the proxy server requests basic,
digest
and/or NTLM authentication. To use this, 'protocol-httpclient' must be present in the value of
'plugin.includes'
property.
    </description>
</property>
</configuration>
```

### 2.Run plugin feed
Plugin feed parsing of rss
Error : Parsing of RSS feeds fails (tejasp) <a href = "https://issues.apache.org/jira/browse/NUTCH-1053"> [2] </a> and read file $NUTCH_ROOT/CHANFES.txt

