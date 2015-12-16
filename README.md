# Springer Assesment

# Installation

Clone the repository to your local drive and import it as a maven project.
```
$ git clone [git-repo-url]
```

# Running scenarios
You can run all the test by using the following command
```
mvn clean verify
```
You can also filter tests by using -Dmetafilter in your maven command, as follows:
```
mvn clean verify -Dmetafilter="+tag"
```

One of the most powerful features of serenity are the reports so make sure you check them after running the tests, they will be generated in the target folder
```
\target\site\serenity\index.html
```
#Some important properties
#####/serenity.properties
- *webdriver.driver:* What browser do you want your tests to run in, for example firefox, chrome, phantomjs or iexplorer. You can also use the driver property as a shortcut.
- *webdriver.remote.driver*:
The driver to be used for remote drivers
- *webdriver.remote.url:*
The URL to be used for remote drivers (including a selenium grid hub or SauceLabs URL)
- *webdriver.timeouts.implicitlywait:*
How long webdriver waits for elements to appear by default, in milliseconds.
- *webdriver.wait.for.timeout:*
How long webdriver waits by default when you use a fluent waiting method, in milliseconds.
- *webdriver.chrome.driver:*
Path to the Chrome driver, if it is not on the system path.
- *serenity.timeout:*
How long should the driver wait for elements not immediately visible.

## License
Serenity-BDD is released under the Apache 2 open source license.

