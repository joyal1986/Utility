# Utility Library

## Overview

Utility library is a collection of Utility classes which provides static methods that are accessible for use across an application. 
The static methods in utility classes are used for performing common routines in our application. 

## Features
### Time Util
- Format milliseconds into seconds.
- Format milliseconds into minutes and seconds.
- Format milliseconds into hours, minutes, and seconds.
- Option to show/hide units for zero values.
- Two formatting options: Full and Short.

## Future enhancements

- Create a pipeline which build and publish the artifacts to rabobank's internal repository of artifacts.
- Add a new stage  in pipeline which run the unit tests and make sure the code meets the mandatory code coverage.
- Add a new stage in pipeline which integrates with SonarQuobe for assuring the code quality.

## Getting Started

### Prerequisites

- Java 17
- Maven

### Installation

Add the following dependency to your Maven project:

```xml
<dependencies>
    <dependency>
        <groupId>com.rabobank.digital.util</groupId>
        <artifactId>Utility</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>

## Future enhancements

- Create a pipeline which build and publish the artifacts to rabobank's internal repository of artifacts.
- Add a new stage  in pipeline which run the unit tests and make sure the code meets the mandatory code coverage.
- Add a new stage in pipeline which integrates with SonarQuobe for assuring the code quality.



