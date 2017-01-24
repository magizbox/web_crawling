# Scrapy

An open source and collaborative framework for extracting the data you need from websites. In a fast, simple, yet extensible way.

## Build and run your web spiders

```
$ pip install scrapy
$ cat > myspider.py <<EOF
import scrapy

class BlogSpider(scrapy.Spider):
    name = 'blogspider'
    start_urls = ['https://blog.scrapinghub.com']

    def parse(self, response):
        for title in response.css('h2.entry-title'):
            yield {'title': title.css('a ::text').extract_first()}

        next_page = response.css('div.prev-post > a ::attr(href)').extract_first()
        if next_page:
            yield scrapy.Request(response.urljoin(next_page), callback=self.parse)
EOF
$ scrapy runspider myspider.py
```

## Deploy them to Scrapy Cloud

```
$ shub login
Insert your Scrapinghub API Key: <API_KEY>

# Deploy the spider to Scrapy Cloud

$ shub deploy

# Schedule the spider for execution
 shub schedule blogspider
Spider blogspider scheduled, watch it running here:
https://app.scrapinghub.com/p/26731/job/1/8

# Retrieve the scraped data
$ shub items 26731/1/8
{"title": "Improved Frontera: Web Crawling at Scale with Python 3 Support"}
{"title": "How to Crawl the Web Politely with Scrapy"}
...
```
