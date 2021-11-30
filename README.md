# SALES TAXES APP ASSIGNMENT

## Requirements
The following are necessary:

>JDK 1.8 or greater

>Apache Maven

## Assignment

<p>Basic   sales   tax   is   applicable at a rate of <strong>10% on all   goods, except   books,   food,   and   medical   products</strong>  
that   are   <strong>exempt</strong>.   <strong>Import   duty</strong> is   an   additional   sales   tax    applicable   on   <strong>all   imported   goods   at   a   rate   of   5%</strong>, 
with   <strong>no   exemptions</strong>.   When   I  purchase   items   I   receive a   receipt   which   lists   the   name   of   all   the   items   and  
their   price   (including   tax), finishing   with   the   <strong>total   cost</strong>   of   the   items,    and   <strong>the   total   amounts of   sales   taxes   paid.</strong>
The   <strong>rounding   rules</strong>    for   sales   tax   are   that   <strong>for   a   tax   rate   of   n%,   a   shelf   price   of   p   contains   (np/100   rounded   up   to   the   nearest   0.05)</strong> 
amount   of   sales   tax.      Write   an   application   that   prints   out   the   receipt   details   for   these   shopping   baskets... </p>     

### Input   

**Input   1**    
>   1   book   at   12.49        
>   1   music   CD   at   14.99        
>   1   chocolate   bar   at   0.85      

**Input   2**    
>   1   imported   box   of   chocolates   at   10.00        
>   1   imported   bottle   of   perfume   at   47.50          

**Input   3**    
>   1   imported   bottle   of   perfume   at   27.99        
>   1   bottle   of   perfume   at   18.99        
>   1   packet   of   headache   pills   at   9.75        
>   1   box   of   imported   chocolates   at   11.25      

### Output

**Output   1**  
>   1   book:   12.49        
>   1   music   CD:   16.49        
>   1   chocolate   bar:   0.85        
>   Sales   Taxes:   1.50        
>   Total:   29.83 
         
**Output   2**    
>   1   imported   box   of   chocolates:   10.50        
>   1   imported   bottle   of   perfume:   54.65        
>   Sales   Taxes:   7.65        
>   Total:   65.15      

**Output   3**    
>   1   imported   bottle   of   perfume:   32.19        
>   1   bottle   of   perfume:   20.89        
>   1   packet   of   headache   pills:   9.75        
>   1   imported   box   of   chocolates:   11.85        
>   Sales   Taxes:   6.70        
>   Total:   74.68  


# APP DESCRIPTION

<p>This app is an attempt at creating an app that would be able to print a bill based on the input of a user. 
Input would be read from the "src/main/resources" folder, in which every ".txt" file represents an order. 

</p>

## How to use the app

### Build

The application needs to be built with Apache Maven, using the following command:

```
mvn clean install
```

Once the application is built, the jar is saved in the "target" folder of the application, named "sales-taxes".
It can then be run with the following command.

### Run

You can run the application represented by sales-taxes.jar file. Please use the following command, in the project's base folder.

```
java -jar target/sales-taxes.jar
```

The user is going to be presented with a choice to select one of the 3 options (1, 2, or 3), which will then read inputs given in 
the assignment. Namely, each will read the following file:
>   1 = input1

>   2 = input2

>   3 = input3

### JUnit

The unit tests are run using the following command:

```
mvn test
```

The result of the test can be read from the console.


