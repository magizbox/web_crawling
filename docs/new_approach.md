# A New Approach to Dynamic Crawler

Build a crawler system for dynamic websites is not easy task. While you can use a web browser automator (like [`selenium`](http://www.seleniumhq.org/)), or event when you can integrate selenium with nutch (by using [`nutch-selenium`](https://github.com/momer/nutch-selenium)). These solutions are still hard to develop, hard to test and hard to manage sessions because we still "translate" our process to languages (such as java or python)

I suppose a new approach for this problem. Instead of using a  web browser automator, we can inject native javascript codes into browser (via extension or add-on).The advantages of this approach is we can easily inject third party libraries (like `jquery` (for dom selector), `Run.js` (for complicated process) and APIs that supported by browsers). And we can take advance of debugging tool and testing framework in javascript world.

If you want to know about more details, feel free to [contact me](brother.rain.1024@gmail.com).

