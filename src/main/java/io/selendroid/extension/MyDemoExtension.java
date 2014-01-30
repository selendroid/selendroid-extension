/*
 * Copyright 2014 eBay Software Foundation and selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.extension;

import io.selendroid.ServerInstrumentation;

/**
 * A sample extension that can be used e.g. for execute script.
 * 
 * @author ddary
 * 
 */
public class MyDemoExtension implements SelendroidScriptExtension {
  /**
   * This could be an endpoint we offer the selendroid users that they can invoke via execute
   * script. They have the full power of the Android Instrumentation library.
   * 
   * @param instrumentation
   * @param args
   */
  public Object executeScript(ServerInstrumentation instrumentation, String... args) {
    System.out.println("Hello World, I'm an extension :)");
    if (args != null && args.length > 0) {
      System.out.println("Arguments: " + args[0]);
    } else {
      System.out.println("No arguments provided");
    }
    return "Current Activity: " + instrumentation.getCurrentActivity();
  }
}
