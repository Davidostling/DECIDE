# DECIDE
DECIDE is a hypothetical anti-ballistic missile system that based upon 15 different 
preset conditions decides whether one should launch an interceptor.

PARAGRAPH DESCRIBING WHAT IT IS
DECIDE uses a set of 15 different Launch Interceptor Conditions (LICs) to decide whether an interceptor 
should be launched based upon an input of radar tracking information. Which is set into a Conditions Met 
Vector (CMV). Something that is determined based upon if a relevant combination of the LICs are true for
the given input. This is done using a Logical Connector Matrix (LCM) that defines what each combination 
of LICs results in. The LCM being a 15x15 symmetric matrix consisting of the statements ANDD, ORR or 
NOTUSED with the result being stored in a Preliminary Unlocking Matrix (PUM). Additionally a Preliminary
Unlocking Vector (PUV) is also used to decide which LICs are of importance for the particular launch 
determination that the input describes. Something that in combination with the PUM is used to generate the
Final Unlocking Vector (FUV), a 15 element vector that only if each element is set as true allows the interceptor
to be launched.


# Classes and functions

**DECIDE: The main class for the project**
- DECIDE(Parameters) : Creates a new DECIDE instance, sets up CMV, PUM, FUV and LAUNCH using Parameters
- getLAUNCH() : Returns either true or false representing the choice of launching an interceptor

**CMV: The class for calculating LICs**
- CMV(Patrameters) : 
- setCMV() :
- getCMV(int) :

**Includes the 15 different LIC functions**
- LIC0()
- LIC1()
- LIC2()
- LIC3()
- LIC4()
- LIC5()
- LIC6()
- LIC7()
- LIC8()
- LIC9()
- LIC10()
- LIC11()
- LIC12()
- LIC13()
- LIC14()

**PUM:**
- PUM(Boolean[] CMVVector, LCM[][] LCMMatrix)
- setPUM()
- getPUMMatrix()

**FUV: The class that generates the final vector used for calculating LAUNCH**
- FUV(Boolean[][] PUMMatrix, Boolean[] PUVVector)
- setFUV()
- getFUV(int)
- getFUVVector()

**Coordinate: Class that allows for both the X and Y coordinate to be stored in one object**

**Parameters: Class that holds all the different parameters used in the calculations for DECIDE**

# Statement of contributions
Johan: I created the repository and set up Maven. I also set up ci with github actions to have the code compiled and tested when a PR or push is made to the main branch. I also structured the program in classes and methods together with David. I set up all the issues for the program.
I coded LIC0, LIC1 and LIC2 including tests. I created the assignment of PUM including the test for Example 1.

Sebaztian: I programmed Lic12, LIC13, LIC14 and FUV with three unit tests included for each. Furthermore I also created the base structure for the documentation including writing the introduction to the project and the descriptions of the classes. 

David: Me and Johan created the skeleton for the program by forming the classes and methods needed. I also coded LIC9, LIC10 and LIC11 together with their corresponding tests. I also wrote our way-of-working paragraph.

Zehao: I implemented LIC3, LIC4 and LIC5 and their corresponding three unit tests. I also set up the skeleton code for the whole test for CMV function. 

Program specification (January 1986):
- J. C. Knight
- N. G. Leveson

Adapted by (June 2016):
- John Regehr
- Martin Monperrus

Programmers and testers:
- Johan Ekberg
- Vilma Jalava
- Zehao Jiang
- Sebaztian Öjebrant
- David Östling



