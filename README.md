#selendroid-extension


selendroid-extension shows how selendroid can be extended easily via execute_script functionality.
The idea is that user can implement a specific interface e.g. `io.selendroid.server.model.SelendroidScriptExtension` that will be invoked via execute script and the classes, provided by the end customer, are loaded dynamically at runtime. 

## Demo Extension

In my example I created the class `io.selendroid.extension.MyDemoExtension` and build a jar, dexed it, added it to a jar and then deployed it to the sdcard of the device (the build file is: [makeAndDeployExtension.sh](makeAndDeployExtension.sh)).

## Run the demo with Python

```python
#in Python:
from selenium import webdriver;
driver=webdriver.Remote(desired_capabilities={'aut': 'io.selendroid.testapp:0.8.0-SNAPSHOT'})
driver.execute_script('io.selendroid.extension.MyDemoExtension','useThis');
#--> result in python is: u'Current Activity: io.selendroid.testapp.HomeScreenActivity@b39a6f68'
```

Result on the adb logcat:
```
01-31 08:23:31.716: I/System.out(1689): Hello World, I'm an extension :)
01-31 08:23:31.716: I/System.out(1689): Arguments: useThis
```

