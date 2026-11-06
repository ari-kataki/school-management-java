# School management (Java)

Small console program made while learning Java OOP at ITS. It builds some school classes (students, teachers, subjects), writes them to `elenco.json`, reads them back and prints them. Class names and output are in Italian.

## Stack
- Java (JDK 25 in the IDE)
- Gson for the JSON file
- Log4j 2 for logging (console + `logs/app.log`, configured in `log4j2.xml`)

## Files
- `ITS.java` - `main`, builds the data and tests the JSON round trip (lots of old exercises left in comments)
- `SchoolClass`, `Student`, `Teacher`, `Subject` - the model
- `Utils.java` - writes / reads the JSON file
- `com/its/umbria/academy/exceptions/ITSException.java` - custom exception
- `Animal`, `Duck`, `Fish`, `Zebra` - inheritance exercise, not used by `main`
- `elenco.json` - example output of the program

## How to run
Put the Gson, log4j-api and log4j-core jars on the classpath, compile all the `.java` files and run `ITS` from this folder (the json and the log are read / written in the current folder). In IntelliJ just add the jars as libraries and run `ITS`.

## What it shows about learning
- Classes, getters/setters, inheritance, a custom exception
- Writing and reading JSON with Gson
- First use of a logger

## Known issues
- `ITSException.getMessage()` always returns the error time and ignores the message passed in the constructor.
- Both classes share the same teachers and subjects lists.
- The average mark of a student is never calculated.
- `ITS.java` and `Utils.java` still have unused imports (some from JDK internals) left by the IDE.
