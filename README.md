# Pet Hotel
The application manages a pet hotel. Implementation uses Classes and Interfaces.  
The whole project is designed by using an MVC architecture (Model - View - Controller)

## Functional Requirements
    Implement an application similar to PetHotel that simulates the management of dogs 
    and cats. Clients can come and leave their pets at the hotel while they are away 
    from the city, and during this time, the animals will be taken care of and engaged 
    in various activities. When an animal is accommodated at the hotel, a receipt is 
    created containing the client's name, the date they need to pick up their pet, and 
    the amount to be paid. Each animal corresponds to a unique receipt of this type.
    
    Each animal has a name, an ID, the check-in date, and the date they must leave 
    the PetHotel. Cats can drink milk, climb, sleep, and play, and their age is known
    (mature or junior). Dogs can fetch, be trained, sleep, and play, and additional 
    information is stored about their breed and whether they need to be walked daily or not.
    
    The maximum capacity of the hotel is 10 animals. If there are clients who want to 
    check in their animals, and the number of available spots is exhausted, they will 
    be placed on a waiting list in the order they arrived (a receipt is issued, and 
    clients with the corresponding receipt are added to the waiting list).
    
    Requirements:
    - Create the necessary classes to implement the described hotel.
    - Display the animals in the hotel based on their check-in date.
    - Display receipts that contain amounts greater than 200 and the associated animals.
    - Remove from the registry receipts with the departure date of the animal in the past.
    - Simulate playing for junior cats.
    - Simulate training for dogs that do not need to be walked daily.
    - Display the waiting list – receipt and corresponding client.
    - Remove from the waiting list clients with receipts totaling less than 50 lei.
[Link to the original functional requirements (in romanian)](./Tema%203.pdf)

## Execution
In `src` folder run `View.java`.

## Modules
The following .java files can be found in `src` folder:
- `Animal.java` - general class Animal, which is to be inherited by `Cat.java` and `Dog.java`
- `CatActions.java` - interface which describes the possible actions for a cat.
- `Cat.java` - class Cat, extends Animal, implements CatActions interface
- `DogActions.java` - interface which describes the possible actions for a dog.
- `Dog.java` - class Dog, extends Animal, implements DogActions interface
- `Chitanta.java` - implements class Chitanta (eng. Receipt)
- `Client.java` - implements class Client

- `Model.java`
- `View.java`
- `Controller.java`
