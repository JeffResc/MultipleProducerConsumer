# MultipleProducerConsumer
Multiple Producer Consumer Extra Credit Project for CS242

# Short Write-Up
This project encompasses the topics of multithreading and syncronized methods in an example involving a Customer, Restaurant, Table and Waiter. The waiter serves the customer via the table class. The customer then eats the served dish. The waiter must wait for the customer to be finished with the last dish in order to serve them, hence the serve() and eat() methods are syncronized.

# Example Outputs
## general.txt
```
Enter the name of the file to test:
general.txt
W_1 serves C1_1: A1_1
C1_1 is eating: A1_1
W_2 serves C1_2: A1_2
C1_2 is eating: A1_2
W_2 serves C1_2: M1_2
W_2 serves C1_2: D1_2
C1_2 is eating: M1_2
W_1 serves C1_1: M1_1
C1_1 is eating: M1_1
C1_2 is eating: D1_2
W_2 serves C2_2: A2_2
C2_2 is eating: A2_2
W_2 serves C2_2: M2_2
W_1 serves C1_1: D1_1
C1_1 is eating: D1_1
W_1 serves C2_1: A2_1
C2_1 is eating: A2_1
W_1 serves C2_1: M2_1
C2_2 is eating: M2_2
C2_1 is eating: M2_1
W_1 serves C2_1: D2_1
W_2 serves C2_2: D2_2
C2_2 is eating: D2_2
C2_1 is eating: D2_1
W_1 serves C3_1: A3_1
C3_1 is eating: A3_1
W_1 serves C3_1: M3_1
W_1 serves C3_1: D3_1
C3_1 is eating: M3_1
C3_1 is eating: D3_1
```

## minions.txt
```
Enter the name of the file to test:
minions.txt
Bob serves Phil: bread
Phil is eating: bread
Dave serves Stuart: calamari
Stuart is eating: calamari
Josh serves Steve: soup
Steve is eating: soup
Josh serves Steve: steak
Bob serves Phil: pizza
Dave serves Stuart: pasta
Josh serves Steve: chocolate_gelato
Steve is eating: steak
Phil is eating: pizza
Stuart is eating: pasta
Steve is eating: chocolate_gelato
Josh serves Mark: sandwich
Mark is eating: sandwich
Josh serves Mark: chicken_wings
Bob serves Phil: banana_bread
Phil is eating: banana_bread
Bob serves Jerry: chips_and_salsa
Jerry is eating: chips_and_salsa
Dave serves Stuart: banana_ice_cream
Stuart is eating: banana_ice_cream
Mark is eating: chicken_wings
Dave serves Kevin: bruschetta
Kevin is eating: bruschetta
Josh serves Mark: strawberry_gelato
Mark is eating: strawberry_gelato
Bob serves Jerry: tacos
Jerry is eating: tacos
Josh serves Mike: scone
Mike is eating: scone
Josh serves Mike: fish_and_chips
Dave serves Kevin: chicken_marsala
Kevin is eating: chicken_marsala
Mike is eating: fish_and_chips
Bob serves Jerry: banana_flan
Jerry is eating: banana_flan
Josh serves Mike: blackberry_gelato
Mike is eating: blackberry_gelato
Dave serves Kevin: banana_pudding
Kevin is eating: banana_pudding
Josh serves Chris: wontons
Chris is eating: wontons
Bob serves Carl: salad
Carl is eating: salad
Bob serves Carl: fish
Carl is eating: fish
Josh serves Chris: noodles
Chris is eating: noodles
Bob serves Carl: banana_cheesecake
Josh serves Chris: cake
Carl is eating: banana_cheesecake
Chris is eating: cake
```