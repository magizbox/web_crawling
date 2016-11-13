# Java: Package Manager

# Gradle

![](http://www.agilearts.nl/wp-content/uploads/2013/03/gradle.png)

## Create your first project with gradle

Step 1: Create new project folder

```
mkdir gradle_sample
```

Step 2: Make folder structure

```
gradle init --type java-library
```

Step 3: Import to IntelliJ

```
Open IntelliJ, click File > New... > Project From Existing Sources... 
```

### Plugins

#### [Application plugin](https://docs.gradle.org/current/userguide/application_plugin.html)

**Usages**

**1.** Using the application plugin

Add this line in `build.gradle`

```
apply plugin: 'application'
```

**2.**  Configure the application main class

```
mainClassName = "org.gradle.sample.Main"
```

