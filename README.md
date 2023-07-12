In order to use the program, a few extra files are needed.
in the folder
it is a file named ids.txt
you can get it here: https://github.com/cjkvi/cjkvi-ids

and these three files:
Junda2005.txt and 
Tzai2006.txt
heisigSimp.txt (list of the simplified heisig characters)
heisigTrad.txt (list of the traditional heisig characters)
can be found here:
https://github.com/agj/3000-traditional-hanzi/tree/master/data/external


toMake the Program work,
you need to have a file named customIdsJsonMap.txt
in the folder CustomData.
This file can be generated from the ids.txt file
by the class CustomDataGeneratorMain

The Project has 3 files that need ongoing work:
org/example/InputMethods/InputMethodCodeGenerators/
AYMethodCodeGeneratorService.java 

in particular this function: generateFullCodeFromCodeMap

org/example/InputMethods/InputMethodData/
AYmethodInputData.java
and
org/example/InputMethods/
customIdsSupplementMaps.java

to work on them, run this test:
CustomDataGenerator/
AYMethodCodeGeneratorServiceTest.java
--testCreateCodesForTziaAndJunda_TzaiAndJunda

and uncomment the exception throws in the function:
generateFullCodeFromCodeMap