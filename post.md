# Write simple integration tests using testcontainers 

An year and half ago I wrote instructions to use Fabric8 in 
[this post](http://javanger.blogspot.com/2018/04/speed-up-your-spring-boot-integration.html "Speed up your Spring Boot integrations tests with Fabric8 docker maven plugin"). 
The goal of this page is to introduce a valid alternative to Fabric8: **testcontainers**.

## Context Overview 
In the official web page this tool is defined as *a Java library that supports JUnit tests providing lightweight, throwaway instances of common databases*. If you are a developer that needs to run application integrated test with attached backing services such as databases, message brokers or web servers this is the right tool for you.

The proof of context is available at [this repository](https://github.com/lorenzomartino86/integration-test-with-test-container).