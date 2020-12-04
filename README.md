# ku-swt-012020

Author: Mai Norapong  
Student ID: 6110545619

<details markdown="1">
  <summary>Table of Contents</summary>

-   [Requirments](#requirements)
-   [Getting Started]()
    *   [Running the unit tests](#running-the-unit-tests)
        +   [IntelliJ way](#unit-tests-intellij-way)
        +   [Maven wrapper way](#unit-tests-maven-wrapper-way)
        +   [Maven way](#unit-tests-maven-way)
        +   [Troubleshooting](#unit-tests-troubleshooting)

</details>

# Requirements

- Java 8
- JUnit 5

# Getting Started

## Running the unit tests

There are many ways to run the unit test

<a id="unit-tests-intellij-way"></a>
### IntelliJ way \*Highly Recommended*

1. Open the cloned repository as a **maven** project.

2. Ensure IntelliJ recognizes it as a **maven** project.

3. Right click on src/test/java folder.

4. Click "Run 'All Tests'"

#### Troubleshooting

Please consult your favourite search engine or look at the comments in this IntelliJ blog post:
https://blog.jetbrains.com/idea/2016/08/using-junit-5-in-intellij-idea/

<a id="unit-tests-maven-wrapper-way"></a>
### Maven wrapper way

1. Ensure you have Java 8 installed

2. Go to the root of your cloned repository

3. Run JUnit tests using maven wrapper

```shell script
mvnw clean test
```

#### Troubleshooting

##### `JAVA_HOME` is not set

<details>
  <summary>Windows</summary>
Error message example:

```
Error: JAVA_HOME not found in your environment.  
Please set the JAVA_HOME variable in your environment to match the  
location of your Java installation.
```

You do not have the required environment variable `JAVA_HOME`.  
Set it to the location of a JDK home dir (e.g. `C:\Program Files\Java\jdk1.8.0_131`).

To set it locally (for the current terminal only) use the `set` command, e.g.

```shell script
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
```

For more detailed instructions on how to set it permanently,
please consult your favourite search engine.
</details>

<details>
  <summary>macOS/Linux</summary>
Error message example:

```
Error: JAVA_HOME is not defined correctly.  
  We cannot execute
```

You do not have the required environment variable `JAVA_HOME`.  
Set it to the location of a JDK home dir.

To set it locally (for the current terminal only) use the `export` command, e.g.

```shell script
export JAVA_HOME=path/to/your/java/jdk
```

For more detailed instructions on how to set it permanently,
please consult your favourite search engine.
</details>

<a id="unit-tests-maven-way"></a>
### Maven way

1. Ensure you have Java 8 and maven installed

2. Go to the root of your cloned repository

3. Run JUnit tests using maven wrapper

```shell script
mvn clean test
```

#### Troubleshooting

##### maven is not installed

<details>
  <summary>Windows</summary>
Error message example:

```
'mvn' is not recognized as an internal or external command,  
operable program or batch file.
```
</details>

<details>
  <summary>macOS</summary>
Error message example:

```
-bash: mvn: command not found
```

To install using [homebrew](https://brew.sh/),

```shell script
brew install maven
```

To install homebrew

```shell script
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

For more detailed instructions on how to install homebrew,
visit their site: https://brew.sh/.

For more detailed instructions on how to install maven,
please consult your favourite search engine.
</details>

<details>
  <summary>Linux</summary>
Error message example (Ubuntu):

```
Command 'mvn' not found, but can be installed with:

sudo apt install maven
```

You're using linux! You know more than me!
Follow the instructions included in the error message.
</details>

<a id="unit-tests-troubleshooting"></a>
### Troubleshooting

Another resource to look at is the user guide for JUnit:
https://junit.org/junit5/docs/current/user-guide/#running-tests
