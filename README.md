## Project Nebula

### Creates (2 raised to the provided power) number of stars

#### Limitations

* The maximum value of a String is Integer.MAX_VALUE. In terms of the maximum power of 2, it means 2^31-1.
    This means that the maximum provided power can be 30.
    
    Of course, this is a limitation of what can be physically be returned by the "starString()" method, not of what 
    can actually be printed to a file for example by multiple calls to this method and using a PrintStream/PrintWriter
    to write the contents.

* I have found an issue with the heap space while running the project using the JDK8 runtime.
    Unfortunately, I didn't manage to perform additional investigations and find the root cause.
    The limitation appears when trying to use a power of 2 greater than 29.
    However, running the program using the JDK11 runtime presents no issue for the power 30.
    
#### Testing

* Tests are ran using the exec-maven-plugin  
* maven-surefire-plugin is disabled
