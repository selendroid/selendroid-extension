#selendroid-extension


selendroid-extension shows how selendroid can be extended easily via execute_script functionality.
The idea is that user can implement a specific interface e.g. `io.selendroid.server.model.SelendroidScriptExtension` that will be invoked via execute script and the classes, provided by the end customer, are loaded dynamically at runtime. 

## Demo Extension

In my example I created the class `io.selendroid.extension.MyDemoExtension` and build a jar, dexed it, added it to a jar and then deployed it to the sdcard of the device (the build file is: [makeAndDeployExtension.sh](makeAndDeployExtension.sh)).

## Run the demo with Java

  package io.selendroid.extension;
   
  import io.selendroid.support.BaseAndroidExtensionTest;
  import org.junit.Test;
   
  import static org.junit.Assert.assertEquals;
   
  public class ExtensionLoadTest {
    @Test
    public void extensionCallShouldSucceed() {
      SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:1.0");
      capa.setSelendroidExtensions(myExtension.dex)
      WebDriver driver = new SelendroidDriver(capa);
      assertEquals("I'm an extension!",
        driver().callExtension("io.selendroid.extension.DemoExtensionHandler"));
    }
  }

