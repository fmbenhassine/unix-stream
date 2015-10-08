# What is XStream?

XStream (uniX Stream) is an extension of the Java 8 Stream API to process data pipelines the Unix way.
It provides a set of components that mimic most of Unix processing commands.

# Features

* 100% compatibles with Java 8 Streams
* Intuitive, flexible and extensible API
* A toolbox of reusable data-science components
* No dependencies
* Free and open source

# How to use it?

You can use XSteam in two ways:

#### 1. Either unixifiy your stream and process it the unix way:

```java
Stream<String> stream = Stream.of("foo", "bar", "bar", "baz");

XStream.unixify(stream)
        .grep("a")
        .sort()
        .uniq()
        .nl()
        .to(stdOut());
        
// prints:
// 1 bar
// 2 baz
```

#### 2. Or write your pipelines as you read them

```java
// cat input.txt | grep a | sort | uniq | nl > output.txt

XStream.cat("input.txt")
        .pipe(grep("a"))
        .pipe(sort())
        .pipe(uniq())
        .pipe(nl())
        .to(file("output.txt"));
```

# Where to find it?

Add the following dependency to your project:

 ```xml
<dependency>
    <groupId>com.github.benas</groupId>
    <artifactId>xstream</artifactId>
    <version>0.1</version>
</dependency>
 ```

# Built-in components library

XStream provides a toolbox of reusable components that mimic Unix's text utilities (and more).
Components are inspired by the [Unix philosophy](https://en.wikipedia.org/wiki/Unix_philosophy#Mike_Gancarz:_The_UNIX_Philosophy) and are intended to be:

* Small
* Portable
* Do one thing and do it well
* Side-effect free

Here are some of the built-in components:

![](https://github.com/benas/xstream/raw/master/xstream.jpeg)

You can find a complete reference of components in the [wiki page](https://github.com/benas/xstream/wiki).

# How to extend it ?

The `Stage` interface represents a stage of the pipeline:

```java
public interface Stage<I,O> {

  Stream<O> apply(Stream<I> input);

}
```

All built-in components are implemented as filters/transformers through this interface.
You can implement this interface to contribute your own your components.

# Contribution

You are welcome to contribute components to make the toolbox as rich as possible!

# License

 XStream is released under the [MIT License](http://opensource.org/licenses/mit-license.php/):

 ```
 The MIT License

 Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)

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
