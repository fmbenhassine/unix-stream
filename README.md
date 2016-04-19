# What is UnixStream?

[![Gitter](https://badges.gitter.im/Join Chat.svg)](https://gitter.im/benas/UnixStream?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.benas/unix-stream/badge.svg?style=flat)](http://search.maven.org/#artifactdetails|io.github.benas|unix-stream|0.4|)
[![Build Status](https://travis-ci.org/benas/UnixStream.svg?branch=master)](https://travis-ci.org/benas/UnixStream)

UnixStream is an extension of the Java 8 Stream API to process data pipelines the Unix way.
It provides a set of components that mimic Unix commands (and more).

# Features

* 100% compatible with Java 8 Streams
* Intuitive, flexible and extensible API
* A toolbox of reusable components
* No dependencies
* Free and open source

# How to use it?

You can use UnixStream in 3 ways:

#### 1. Either unixifiy your stream and process it the unix way:

```java
Stream<String> stream = Stream.of("foo", "bar", "bar", "baz");

UnixStream.unixify(stream)
        .grep("a")
        .sort()
        .uniq()
        .nl()
        .to(stdOut());
        
// prints:
// 1 bar
// 2 baz
```

#### 2. Or write your pipelines as you read them:

```java
// cat input.txt | grep a | sort | uniq | nl > output.txt

UnixStream.cat("input.txt")
        .pipe(grep("a"))
        .pipe(sort())
        .pipe(uniq())
        .pipe(nl())
        .to(file("output.txt"));
```

#### 3. Or use functions and predicates provided by UnixStream with the standard Stream API:

```java
Stream.of("1,foo", "2,bar")
        .filter(grep("a"))
        .map(cut(",", 2))
        .forEach(System.out::println);
        
//prints:
//bar
```

# Where to find it?

Add the following maven dependency to your project:

 ```xml
<dependency>
    <groupId>io.github.benas</groupId>
    <artifactId>unix-stream</artifactId>
    <version>0.4</version>
</dependency>
 ```

Or [download the jar file](https://oss.sonatype.org/content/groups/public/io/github/benas/unix-stream/0.4/unix-stream-0.4.jar) and add it to your application's classpath.

# Components library

UnixStream provides a toolbox of reusable components that mimic Unix commands (and more).
Components are inspired by the [Unix philosophy](https://en.wikipedia.org/wiki/Unix_philosophy#Mike_Gancarz:_The_UNIX_Philosophy) and are intended to be:

* Small
* Portable
* Do one thing and do it well
* Side-effect free

Here are some of the built-in components:

![](https://github.com/benas/UnixStream/raw/master/unix-stream.jpeg)

You can find a complete reference of components in the [wiki page](https://github.com/benas/UnixStream/wiki).

# How to extend it ?

The `Stage` interface represents a stage of the pipeline:

```java
public interface Stage<I,O> {

  Stream<O> apply(Stream<I> input);

}
```

All built-in components are implemented as filters/transformers through this interface.
You can of course implement this interface to create your own components.

# Contribution

There are a lot of options for current components that are not implemented yet.
You are welcome to improve existing components or add new ones to make the toolbox as rich as possible!

# License

 UnixStream is released under the [MIT License](http://opensource.org/licenses/mit-license.php/):

 ```
 The MIT License

 Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ```
