# codeforces-api [![Maven Central](https://img.shields.io/maven-central/v/ru.perveevm/codeforces-api.svg)](https://search.maven.org/artifact/ru.perveevm/codeforces-api) [![javadoc](https://javadoc.io/badge2/ru.perveevm/codeforces-api/javadoc.svg)](https://javadoc.io/doc/ru.perveevm/codeforces-api)


This project implements all Codeforces API methods described [here](https://codeforces.com/apiHelp). If there are any errors in the implementation of some methods, contact me, and I'll fix them.

### Building

Use `mvn package` if you need a `.jar` file.

### Usage

The main class is `CodeforcesSession`. It implements all API methods. Constructor takes two parameters – `key` and `secret`. You can get them in your profile settings on CodeForces.

All entity classes, for example, `Party`, `BlogEntry`, etc., are in the `ru.perveevm.codeforces.api.entities` package.

To add it into your pom.xml use:

```xml
<dependency>
    <groupId>ru.perveevm</groupId>
    <artifactId>codeforces-api</artifactId>
    <version>Put the version you want here</version>
</dependency>
```
