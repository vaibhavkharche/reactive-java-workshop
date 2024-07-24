package io.javabrains.reactiveworkshop;

import java.io.IOException;
import reactor.core.publisher.SignalType;

public class Exercise8 {


  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFluxWithException()

    // Print values from intNumbersFluxWithException and print a message when error happens
//    ReactiveSources.intNumbersFluxWithException()
//        .subscribe(n -> System.out.println(n),
//            err -> System.out.println("Error happened"));
    // or

//    ReactiveSources.intNumbersFluxWithException()
//        .doOnError(e -> System.out.println("Error!!" + e.getMessage()))
//        .subscribe(n -> System.out.println(n));

    // Print values from intNumbersFluxWithException and continue on errors
//    ReactiveSources.intNumbersFluxWithException()
//        .onErrorContinue(
//            (e, item) -> System.out.println(
//                "Error: " + e.getMessage() + " happened for: " + item))
//        .subscribe(n -> System.out.println(n));

    // Print values from intNumbersFluxWithException and when errors
    // happen, replace with a fallback sequence of -1 and -2
//    ReactiveSources.intNumbersFluxWithException()
//        .onErrorResume(err -> Flux.just(-1, -2))
//        .subscribe(n -> System.out.println(n));

    // Print message when Flux is completed or throws an error
    ReactiveSources.intNumbersFlux()//intNumbersFluxWithException()
        .doFinally(signalType -> {
          if (signalType == SignalType.ON_COMPLETE) {
            System.out.println("Done");
          } else if (signalType == SignalType.ON_ERROR) {
            System.out.println("Error happened");
          }
        })
        .subscribe(n -> System.out.println(n));

    System.out.println("Press a key to end");
    System.in.read();
  }

}
