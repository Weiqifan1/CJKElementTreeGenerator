In order to use the program, a few extra files are needed.
in the folder
it is a file named ids.txt
you can get it here: https://github.com/cjkvi/cjkvi-ids

and these two files:
Junda2005.txt and 
Tzai2006.txt 

toMake the Program work,
you need to have a file named customIdsJsonMap.txt
in the folder CustomData.
This file can be generated from the ids.txt file
by the class CustomDataGeneratorMain

The Project has 3 files that need ongoing work:
org/example/InputMethods/InputMethodCodeGenerators/
AYMethodCodeGeneratorService.java
org/example/InputMethods/InputMethodData/
AYmethodInputData.java
and
org/example/InputMethods/
customIdsSupplementMaps.java

to work on them, run this test:
CustomDataGenerator/
AYMethodCodeGeneratorServiceTest.java
--testCreateCodesForTziaAndJunda_TzaiAndJunda