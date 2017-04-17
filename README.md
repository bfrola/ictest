# ictest

Folder `doc` contaisn subfolder part1, which contains 

Folder `src` contains subfolders part2 and part3, which implement solutions of relative problems #2 and #3.
See classes `IcTest2Main` and `IcTest3Main` for details.

To run example code:

```
mvn install
mvn exec:java -Dexec.mainClass="part2.IcTest2Main"
mvn exec:java -Dexec.mainClass="part3.IcTest3Main"
```

To run tests:
```
mvn test
```