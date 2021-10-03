# Tests with Jenkins and Selenoid<br>

###Information<br>
Used services:<br>
```https://jenkins.autotests.cloud/``` <br>
```https://selenoid.autotests.cloud```<br><br>

Important options for selenoid:
```
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", true);
Configuration.browserCapabilities = capabilities;
Configuration.remote = "https://path-to-selenoid-server";
```
<br>

```Attach.java``` - added screenshots and video from selenoid for the best details into Allure report