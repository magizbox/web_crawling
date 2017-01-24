## Architectures

<p><img src="https://sites.google.com/site/nutch1936/_/rsrc/1427176500763/home/introduction/Nutch_Overview.png" alt="" /></p>

### Data Structure

<p><strong>The web database</strong> is a specialized persistent data structure for mirroring the structure and properties of the web graph being crawled. It persists as long as the web graph that is being crawled (and re-crawled) exists, which may be months or years. The WebDB is used only by the crawler and does not play any role during searching. The WebDB stores two types of entities: pages and links.</p>

<p><code>A page</code> represents a page on the Web, and is indexed by its URL and the MD5 hash of its contents. Other pertinent information is stored, too, including</p>

<ul>
<li>the number of links in the page (also called outlinks);</li>
<li>fetch information (such as when the page is due to be refetched);</li>
<li>the page's score, which is a measure of how important the page is (for example, one measure of importance awards high scores to pages that are linked to from many other pages).</li>
</ul>

<p><code>A link</code> represents a link from one web page (the source) to another (the target). In the WebDB web graph, the nodes are pages and the edges are links.</p>

<p><strong>A segment</strong> is a collection of pages fetched and indexed by the crawler in a single run. The fetchlist for a segment is a list of URLs for the crawler to fetch, and is generated from the WebDB. The fetcher output is the data retrieved from the pages in the fetchlist. The fetcher output for the segment is indexed and the index is stored in the segment. Any given segment has a limited lifespan, since it is obsolete as soon as all of its pages have been re-crawled. The default re-fetch interval is 30 days, so it is usually a good idea to delete segments older than this, particularly as they take up so much disk space. Segments are named by the date and time they were created, so it's easy to tell how old they are.</p>

<p><strong>The index</strong> is the inverted index of all of the pages the system has retrieved, and is created by merging all of the individual segment indexes. Nutch uses Lucene for its indexing, so all of the Lucene tools and APIs are available to interact with the generated index. Since this has the potential to cause confusion, it is worth mentioning that the Lucene index format has a concept of segments, too, and these are different from Nutch segments. A Lucene segment is a portion of a Lucene index, whereas a Nutch segment is a fetched and indexed portion of the WebDB.</p>

<p><a href="https://github.com/apache/nutch/blob/branch-2.3/conf/gora-hbase-mapping.xml">View <code>gora-hbase-mapping.xml</code> for more details</a></p>

