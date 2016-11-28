# Installation

## Ubuntu

Step 1. Download sdk

```
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
```

Step 2. Create folder jvm

```
sudo mkdir /usr/lib/jvm/
```

Step 3. cd to folder downloads jdk and run command

```
sudo mv jdk1.7.0_x/ /usr/lib/jvm/jdk1.7.0_x
```

### Run install java
```
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0_x/jre/bin/java 0
```

Add path jdk : /usr/lib/jvm/jdk1.7.0_x

```
su -
nano /etc/environment
```

