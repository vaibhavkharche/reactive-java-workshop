package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

    // Print all values from intNumbersFlux that's greater than 5
//    ReactiveSources.intNumbersFlux()
//        .log()
//        .filter(n -> n > 5)
//        .subscribe(System.out::println);

    // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
//    ReactiveSources.intNumbersFlux()
//        .filter(n -> n > 5)
//        .map(n -> n * 10)
////        .log()
//        .subscribe(System.out::println);

    // Print 10 multiplied by each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//    ReactiveSources.intNumbersFlux()
//        .filter(n -> n > 5)
//        .map(n -> n * 10)
//        .take(3)
//        .subscribe(System.out::println);

    // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//    ReactiveSources.intNumbersFlux()
//        .filter(n -> n > 20)
//        .defaultIfEmpty(-1)
//        .subscribe(System.out::println);

    // Switch ints from intNumbersFlux to the right user from userFlux
//    ReactiveSources.intNumbersFlux()
//        .flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id).take(1))
//        .subscribe(user -> System.out.println(user));

    // Print only distinct numbers from intNumbersFluxWithRepeat
//    ReactiveSources.intNumbersFluxWithRepeat()
//        .distinct()
//        .log()
//        .subscribe();

    // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
    ReactiveSources.intNumbersFluxWithRepeat()
        .distinctUntilChanged()
        .log()
        .subscribe();

    System.out.println("Press a key to end");
    System.in.read();
  }

}
