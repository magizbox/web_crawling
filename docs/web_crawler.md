# Web Crawler

Static Crawler

- [Apache Nutch](http://magizbox.com/index.php/apache-nutch/)

Dynamic Crawler

- [nutch-selenium](https://github.com/momer/nutch-selenium)

Intelligent Extractor

- [boilerpipe](https://code.google.com/p/boilerpipe/)
- [Web Content Extraction Through Machine Learning](http://cs229.stanford.edu/proj2013/ZhouMashuq-WebContentExtractionThroughMachineLearning.pdf)

Priority Crawler, Social Crawler

## Features a crawler must provide

We list the desiderata for web crawlers in two categories: features that web crawlers must provide, followed by features they should provide.

**Robustness:**

The Web contains servers that create spider traps, which are generators of web pages that mislead crawlers into getting stuck fetching an infinite number of pages in a particular domain. Crawlers must be designed to be resilient to such traps. Not all such traps are malicious; some are the inadvertent side-effect of faulty website development.

**Politeness:**

Web servers have both implicit and explicit policies regulating the rate at which a crawler can visit them. These politeness policies must be respected.

##  Features a crawler should provide

**Distributed**
The crawler should have the ability to execute in a distributed fashion across multiple machines.

**Scalable**

The crawler architecture should permit scaling up the crawl rate by adding extra machines and bandwidth.

**Performance and efficiency**

The crawl system should make efficient use of various system resources including processor, storage and network bandwidth.

**Quality**

Given that a significant fraction of all web pages are of poor utility for serving user query needs, the crawler should be biased towards fetching ``useful'' pages first.

**Freshness**

In many applications, the crawler should operate in continuous mode: it should obtain fresh copies of previously fetched pages. A search engine crawler, for instance, can thus ensure that the search engine's index contains a fairly current representation of each indexed web page. For such continuous crawling, a crawler should be able to crawl a page with a frequency that approximates the rate of change of that page.

**Extensible**

Crawlers should be designed to be extensible in many ways - to cope with new data formats, new fetch protocols, and so on. This demands that the crawler architecture be modular.

