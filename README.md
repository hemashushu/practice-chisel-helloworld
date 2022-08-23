# Practice - Chisel

1. Install openjdk

install openjdk with your system package manager.

it's recommended to install `src` and `doc` of openjdk.

2. Install _Coursier_

https://get-coursier.io/

3. Install sbt and scala etc. by _Coursier_

```
cs install scala
cs install sbt
cs install scalafmt
```

4. Run the current Chisel application

```bash
$ sbt run
or
$ sbt "runMain hello.HelloWorldApp"
```

5. Unit test

```bash
$ sbt test
```
