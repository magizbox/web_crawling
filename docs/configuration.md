## Configuration

[`pyconfiguration`](pypi.python.org/pypi/pyconfiguration)

### Installation

```
conda install -c rain1024 pyconfiguration
```

### Usage

Step 1: Create `config.json` file

```
{
  "SERVICE_URL": "http://api.service.com"
}
```

Step 2: Add these code to `main.py` file

```
from pyconfiguration import Configuration
Configuration.load('config.json')
print Configuration.SERVICE_URL

> http://api.service.com
```

References: What's the best practice using a settings file [^1]

[^1]: [What's the best practice using a settings file in Python?](http://stackoverflow.com/questions/5055042/whats-the-best-practice-using-a-settings-file-in-python)