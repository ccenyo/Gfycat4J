# Gfycat4J

Gfycat is one of the most popular user-generated Gif website.

Gfycat for java is an open source java library for [https://gfycat.com](https://gfycat.com), it's basically a wrapper for the API.
you can find all information about the api [here](https://developers.gfycat.com/api/#introduction).
This api is still in developpement for now. If you want to help me finish it and maintain it, fill free to make a pull request. i will be more than happy to add you feature

If you find yourself on this page, it means that you have a java project and you need to communicate with your Nas Synology.
This wrapper can be a great startup for that.
I am trying to build the most complete wrapper for gif searching and downloading.


##Prerequisites

This project is written in java 15. you can only use it in a project that uses java 15 and above.
if you want to use it in any environment, make sure you the right JVM installed on the machine.

##Integration tests
For now, we are using a test account to make the all the tests. it's no use to try to hack it, it's not an actual account.
Make sure to run all the tests to ckeck they are working.

## How to use it

add the maven repository to your pom.xml

```java
        <dependency>
            <groupId>com.github.ccenyo</groupId>
            <artifactId>gfycat4j</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

##Basic usage

You will need a clientId and a clientSecret [Here](https://developers.gfycat.com/signup/#/apiform)


```java
    GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);
    var userInfo = client.me();
```

## Features

#### FileStation features

| Feature                                               | Description 
| ---                                                   |---                                                                   
| Login by credentials                                  | Login with api credentials
| Login by password                                     | Login with api credentials and username and password
| Check a user exist                                    | Given a username, you can check the user really exist on gfycat
| Get user informations                                 | Ge all the informations about a given user.
| Get current user informations                         | Get all the informations about the current logged in user.
| Search a gfycat by term                               | Given a term, search a gif that correspond to that term. 


##RoadMap
I will be completing new methods regularely

* User account search
* User Feeds
* Creating Gfycats

## Built With
* [Java SDK 15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) -  Java™ Platform
* [Maven](https://maven.apache.org/) - Dependency Management

## Author
* **Cenyo Medewou** - [medewou@gmail.com](mailto:medewou@gmail.com).

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details                                                                        
