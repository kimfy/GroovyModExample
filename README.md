# GroovyModExample
[![Build Status](https://drone.io/github.com/kimfy/GroovyModExample/status.png)](https://drone.io/github.com/kimfy/GroovyModExample/latest)

In this repository you will find information and instructions on how you can code a Minecraft mod in Groovy.

### Notes
    I am not sure if this is actually the way to do this - all I know is it works and it's currently passing
    my somewhat shitty tests. Use at your own risk!

# Instructions

### build.gradle

1. Apply the 'groovy' plugin.  

    ```apply plugin: 'groovy```

2. Add shading configurations.

    ```
    configurations {
        shade
        compile.extendsFrom shade
    }
    ```
    
3. Add groovy to the dependencies.

    ```
    dependencies {
        shade 'org.codehaus.groovy:groovy-all:x.x.x'
    }
    ```
    
    You should obviously change the `x.x.x` to an actual version number like `2.4.4`
    
4. Add this jar config

    ```
    jar {
        configurations.shade.each { dep ->
            from(project.zipTree(dep)){
                exclude 'META-INF', 'META-INF/**'
            }
        }
    }
    ```
    
5. Last block of code we'll add to our `build.gradle` file is

    ```
    sourceSets {
        main {
            groovy {
                srcDirs = ['src/main/groovy']
            }
        }
    }
    ```

6. Re-run your gradle tasks and open your IDE

### IDE
1. Create two source directories for both java and groovy. E.g.
 
    ```
    Root
    \- src/main/java
    \- src/main/groovy
    ```
    
    If they aren't already, mark them as source directories.
    
3. Create a package in the `java` source dir. `yourname.dev`
4. New File-> Java Class -> Give it a valid name. I chose `OpenMe.java` - and leave the class completely empty. The reason for this is ForgeGradle will not be able to build your project if it can't find any java classes in `src/main/java`, I do not know enough about the whole building process to go into details.
5. Create a package in the `groovy` source dir. `com.yourname.modid`.
6. New File-> Groovy Class -> Give it a valid name. I chose my mod name. E.g. `GroovyModExample.groovy`
7. Annotate the class with the usual @Mod annotation and go on from here. Look in this repository for working examples.

Look for the build.gradle script in this repository if you want to see the final outcome.

### @CompileStatic

Any class or method where you're referencing Mojang code/deobfuscated code you HAVE to annotate with @CompileStatic.
Here are some links where you can read more about the @CompileStatic annotation 
* http://docs.groovy-lang.org/latest/html/documentation/#compilestatic-annotation
* http://docs.groovy-lang.org/next/html/gapi/groovy/transform/CompileStatic.html
