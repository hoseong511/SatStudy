
[![build status](https://ci.docker.com/public/job/cli/job/master/badge/icon)]( http://52.79.196.232 )
[![Build Status](https://ci.docker.com/public/job/cli/job/master/badge/icon)](https://ci.docker.com/public/job/cli/job/master)

Study
==========

This repository is the home of a cluster of Web and Algoritm.

Web
===========

`Web` is .

Build a linux binary:

```
$ make -f docker.Makefile binary
```

Build binaries for all supported platforms:

```
$ make -f docker.Makefile cross
```

Run all linting:

```
$ make -f docker.Makefile lint
```

List all the available targets:

```
$ make help
```

### In-container development environment

Start an interactive development environment:

```
$ make -f docker.Makefile shell
```

In the development environment you can run many tasks, including build binaries:

```
$ make binary
```

xxxx
=====
*Brought to you courtesy of our legal counsel. For more context,
please see the [NOTICE](https://github.com/docker/cli/blob/master/NOTICE) document in this repo.*

Use and transfer of Docker may be subject to certain restrictions by the
United States and other governments.

It is your responsibility to ensure that your use and/or transfer does not
violate applicable laws.

For more information, please see https://www.bis.doc.gov

ooooooooo
=========
docker/cli is licensed under the Apache License, Version 2.0. See
[LICENSE](https://github.com/docker/docker/blob/master/LICENSE) for the full
license text.
