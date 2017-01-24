# Apache Nutch

<blockquote>
  <p>Highly extensible, highly scalable Web crawler <sup id="fnref-1382-1"><a href="#fn-1382-1" rel="footnote">1</a></sup> Nutch is a well matured, production ready Web crawler. Nutch 1.x enables fine grained configuration, relying on Apache Hadoop™ data structures, which are great for batch processing.</p>
</blockquote>

### History

<p><img src="http://image.slidesharecdn.com/jnioche-apachecon-2012-121107041657-phpapp01/95/large-scale-crawling-with-apache-nutch-5-638.jpg?cb=1353925333" alt="" /></p>

<h3>Usecases</h3>

<p><img src="http://image.slidesharecdn.com/jnioche-apachecon-2012-121107041657-phpapp01/95/large-scale-crawling-with-apache-nutch-11-638.jpg?cb=1353925333" alt="" /></p>

<h3>1&#46; Features <sup id="fnref-1382-1"><a href="#fn-1382-1" rel="footnote">1</a></sup> <img src="http://www.yuml.me/diagram/scruffy/usecase/(Transparency)-(Understanding),%20(Understanding)-(Extensibility).png" alt="" /></h3>

<p><strong>1&#46; Transparency</strong> Nutch is open source, so anyone can see how the ranking algorithms work. With commercial search engines, the precise details of the algorithms are secret so you can never know why a particular search result is ranked as it is. Furthermore, some search engines allow rankings to be based on payments, rather than on the relevance of the site's contents. Nutch is a good fit for academic and government organizations, where the perception of fairness of rankings may be more important.</p>

<p><strong>2&#46; Understanding</strong> We don't have the source code to Google, so Nutch is probably the best we have. It's interesting to see how a large search engine works. Nutch has been built using ideas from academia and industry: for instance, core parts of Nutch are currently being re-implemented to use the <a href="http://research.google.com/archive/mapreduce.html">MapReduce</a>.</p>

<p>Map Reduce distributed processing model, which emerged from Google Labs last year. And Nutch is attractive for researchers who want to try out new search algorithms, since it is so easy to extend.</p>

<p><strong>3&#46; Extensibility</strong> Don't like the way other search engines display their results? Write your own search engine--using Nutch! Nutch is very flexible: it can be customized and incorporated into your application. For developers, Nutch is a great platform for adding search to heterogeneous collections of information, and being able to customize the search interface, or extend the out-of-the-box functionality through the plugin mechanism. For example, you can integrate it into your site to add a search capability.</p>

<h4>Process <sup id="fnref-1382-5"><a href="#fn-1382-5" rel="footnote">5</a></sup></h4>

<p><em>0&#46;</em> initialize CrawlDb, inject <code>seed</code> URLs Repeat <code>generate-fetch-update</code> cycle n times:</p>

<p><strong>1&#46;</strong> The <code>Injector</code> takes all the URLs of the nutch.txt file and adds them to the <code>CrawlDB</code>. As a central part of Nutch, the <code>CrawlDB</code> maintains information on all known URLs (fetch schedule, fetch status, metadata, …).</p>

<p><strong>2&#46;</strong> Based on the data of <code>CrawlDB</code>, the <code>Generator</code> creates a fetchlist and places it in a newly created <code>Segment directory</code>.</p>

<p><strong>3&#46;</strong> Next, the <code>Fetcher</code> gets the content of the URLs on the fetchlist and writes it back to the <code>Segment directory</code>. This step usually is the most time-consuming one.</p>

<p><strong>4&#46;</strong> Now the <code>Parser</code> processes the content of each web page and for example omits all html tags. If the crawl functions as an update or an extension to an already existing one (e.g. depth of 3), the <code>Updater</code> would add the new data to the <code>CrawlDB</code> as a next step.</p>

<p><strong>5&#46;</strong> Before indexing, all the links need to be inverted by <code>Link Inverter</code>, which takes into account that not the number of outgoing links of a web page is of interest, but rather the number of inbound links. This is quite similar to how Google PageRank works and is important for the scoring function. The inverted links are saved in the <code>Linkdb</code>.</p>

<p><strong>6-7.</strong> Using data from all possible sources (<code>CrawlDB</code>, <code>LinkDB</code> and <code>Segments</code>), the <code>Indexer</code> creates an index and saves it within the Solr directory. For indexing, the popular Lucene library is used. Now, the user can search for information regarding the crawled web pages via Solr.</p>

## Installation

**Requirements**

**1.** OpenJDK 7

**2.** Nutch 2.3 RC (yes, you need 2.3, 2.2 will not work)

```shell
wget https://archive.apache.org/dist/nutch/2.3/apache-nutch-2.3-src.tar.gz
tar -xzf apache-nutch-2.3-src.tar.gz
```

**3.** HBase 0.94.27 (HBase 0.98 won't work)

```shell
wget https://www.apache.org/dist/hbase/hbase-0.94.27/hbase-0.94.27.tar.gz
tar -xzf hbase-0.94.27.tar.gz
```

**4.** ElasticSearch 1.7

```sh
wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-1.7.0.tar.gz
tar -xzf elasticsearch-1.7.0.tar.gz
```

Other Options: `nutch-2.3`, `hbase-0.94.26`, `ElasticSearch 1.4`

#### Setup HBase

<p><em>1&#46;</em> edit <code>$HBASE_ROOT/conf/hbase-site.xml</code> and add</p>

```xml
<configuration>
    <property>
        <name>hbase.rootdir</name>
        <value>file:///full/path/to/where/the/data/should/be/stored</value>
    </property>
    <property>
        <name>hbase.cluster.distributed</name>
        <value>false</value>
    </property>
</configuration>
```

<p><em>2&#46;</em> edit <code>$HBASE_ROOT/conf/hbase-env.sh</code> and enable <code>JAVA_HOME</code> and set it to the proper path:</p>

```diff
-# export JAVA_HOME=/usr/java/jdk1.6.0/
+export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
```

<p>This step might seem redundant, but even with <code>JAVA_HOME</code> being set in my shell, HBase just didn't recognize it.</p>

<p><em>3&#46;</em> kick off HBase:</p>

```
$ $HBASE_ROOT/bin/start-hbase.sh
```

#### Configure Nutch

**1.** Enable the HBase dependency in `$NUTCH_ROOT/ivy/ivy.xml` by uncommenting the line

```
<dependency org="org.apache.gora" name="gora-hbase" rev="0.5" conf="*->default" />
```

**2.** Configure the HBase adapter by editing the `$NUTCH_ROOT/conf/gora.properties`

```diff
-#gora.datastore.default=org.apache.gora.mock.store.MockDataStore
+gora.datastore.default=org.apache.gora.hbase.store.HBaseStore
```

**3.** Build Nutch

```
$ cd $NUTCH_ROOT && ant clean && ant runtime
```

<p>This can take a while and creates <code>$NUTCH_ROOT/runtime/local</code>.</p>

**4.** configure Nutch by editing `$NUTCH_ROOT/runtime/local/conf/nutch-site.xml`

```xml
<configuration>
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
</configuration>
```

or you configure Nutch by editing `$NUTCH_ROOT/runtime/local/conf/nutch-site.xml`

```xml
<configuration>
    <property>
        <name>plugin.includes</name>
        <!-- do \*\*NOT\*\* enable the parse-html plugin, if you want proper HTML parsing. Use something like parse-tika! -->
        <value>
            protocol-http|protocol-httpclient|urlfilter-regex|
parse-(text|tika|js)|index-(basic|anchor)|query-(basic|site|url)|response-(json|xml)|
summary-basic|scoring-opic|urlnormalizer-(pass|regex|basic)|indexer-elastic|
index-metadata|index-more
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
</configuration>
```


**5.** configure HBase integration by editing <code>$NUTCH_ROOT/runtime/local/conf/hbase-site.xml</code>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
   <property>
      <name>hbase.rootdir</name>
      <value>file:///full/path/to/where/the/data/should/be/stored</value>
      <!-- same path as you've given for HBase above -->
   </property>
   <property>
      <name>hbase.cluster.distributed</name>
      <value>false</value>
   </property>
</configuration>
```

or you configure HBase integration by editing <code>$NUTCH_ROOT/runtime/local/conf/hbase-site.xml</code>:</p>

```xml
<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///$PATH/database</value>
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

<p>That's it. Everything is now setup to crawl websites.</p>

## Run Nutch

**1.** Create an empty directory. Add a textfile containing a list of seed URLs

```shell
$ mkdir seed
$ echo "https://www.website.com" >> seed/urls.txt
$ echo "https://www.another.com" >> seed/urls.txt
$ echo "https://www.example.com" >> seed/urls.txt
```

Inject them into Nutch by giving a file URL (!)

```
$ $NUTCH_ROOT/runtime/local/bin/nutch inject file:///path/to/seed/
```

**2.** Generate a new set of URLs to fetch.

This is is based on both the injected URLs as well as outdated URLs in the Nutch crawl db.

```
$ $NUTCH_ROOT/runtime/local/bin/nutch generate -topN 10
```

The above command will create job batches for 10 URLs.

**3.** Fetch the URLs. We are not clustering, so we can simply fetch all batches:

```
$ $NUTCH_ROOT/runtime/local/bin/nutch fetch -all
```


**4.** Now we parse all fetched pages:

```
$ $NUTCH_ROOT/runtime/local/bin/nutch parse -all
```

**5.** Last step: Update Nutch's internal database:

```
$ $NUTCH_ROOT/runtime/local/bin/nutch updatedb -all
```

<p>On the first run, this will only crawl the injected URLs. The procedure above is supposed to be repeated regulargy to keep the index up to date.</p>

**6.** Putting Documents into ElasticSearch

```
$ $NUTCH_ROOT/runtime/local/bin/nutch index -all
```

## Configuration

<p><strong>Crawl nutch via proxy</strong></p>

<p>Change <code>$NUTCH_ROOT/runtime/local/conf/nutch-site.xml</code></p>

```xml
<configuration>
    <property>
        <name>http.proxy.host</name>
        <value>192.168.80.1</value>
        <description>The proxy hostname. If empty, no proxy is used.</description>
    </property>
    <property>
        <name>http.proxy.port</name>
        <value>port</value>
        <description>The proxy port.</description>
    </property>
    <property>
        <name>http.proxy.username</name>
        <value>username</value>
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
        <value>password</value>
        <description>Password for proxy. This will be used by 'protocol-httpclient', if the proxy server requests basic,
            digest
            and/or NTLM authentication. To use this, 'protocol-httpclient' must be present in the value of
            'plugin.includes'
            property.
        </description>
    </property>
</configuration>
```

## Nutch Plugins

#### Extension Points

In writing a plugin, you're actually providing one or more extensions of the existing extension-points . The core Nutch extension-points are themselves defined in a plugin, the NutchExtensionPoints plugin (they are listed in the NutchExtensionPoints plugin.xml file). Each extension-point defines an interface that must be implemented by the extension. The core extension points are:

<table>
  <tr>
    <td>
      Point
    </td>

    <td>
      Description
    </td>

    <td>
      Example
    </td>
  </tr>

  <tr>
    <td>
      IndexWriter
    </td>

    <td>
      Writes crawled data to a specific indexing backends (Solr, ElasticSearch, a CVS file, etc.).
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      IndexingFilter
    </td>

    <td>
      Permits one to add metadata to the indexed fields. All plugins found which implement this extension point are run sequentially on the parse (from javadoc).
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      Parser
    </td>

    <td>
      Parser implementations read through fetched documents in order to extract data to be indexed. This is what you need to implement if you want Nutch to be able to parse a new type of content, or extract more data from currently parseable content.
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      HtmlParseFilter
    </td>

    <td>
      Permits one to add additional metadata to HTML parses (from javadoc).
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      Protocol
    </td>

    <td>
      Protocol implementations allow Nutch to use different protocols (ftp, http, etc.) to fetch documents.
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      URLFilter
    </td>

    <td>
      URLFilter implementations limit the URLs that Nutch attempts to fetch. The RegexURLFilter distributed with Nutch provides a great deal of control over what URLs Nutch crawls, however if you have very complicated rules about what URLs you want to crawl, you can write your own implementation.
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      URLNormalizer
    </td>

    <td>
      Interface used to convert URLs to normal form and optionally perform substitutions.
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      ScoringFilter
    </td>

    <td>
      A contract defining behavior of scoring plugins. A scoring filter will manipulate scoring variables in CrawlDatum and in resulting search indexes. Filters can be chained in a specific order, to provide multi-stage scoring adjustments.
    </td>

    <td>
    </td>
  </tr>

  <tr>
    <td>
      SegmentMergeFilter
    </td>

    <td>
      Interface used to filter segments during segment merge. It allows filtering on more sophisticated criteria than just URLs. In particular it allows filtering based on metadata collected while parsing page.
    </td>

    <td>
    </td>
  </tr>
</table>

#### Getting Nutch to Use a Plugin

<p>In order to get Nutch to use a given plugin, you need to edit your conf/nutch-site.xml file and add the name of the plugin to the list of plugin.includes. Additionally we are required to add the various build configurations to build.xml in the plugin directory.</p>


## Develop nutch plugins

#### Project structure of a plugin

```
plugin-name
  plugin.xml
  build.xml
  ivy.xml
  src
    org
      apache
        nutch
          indexer
            uml-meta # source folder
              URLMetaIndexingFilter.java
          scoring
            uml-meta # source folder
              URLMetaScoringFilter.java
  test
    org
      apache
        nutch
          indexer
            uml-meta # test folder
              URLMetaIndexingFilterTest.java
          scoring
            uml-meta # test folder
              URLMetaScoringFilterTest.java
```

Follow [this link](http://florianhartl.com/nutch-plugin-tutorial.html) to read develop nutch plugins

