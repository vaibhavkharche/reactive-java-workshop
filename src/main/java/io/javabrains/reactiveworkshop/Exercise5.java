package io.javabrains.reactiveworkshop;

import java.io.IOException;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

    // Subscribe to a flux using the error and completion hooks
    /*ReactiveSources.intNumbersFlux()
        .subscribe(number -> System.out.println(number),
            throwable -> System.out.println(throwable.getMessage()),
            () -> System.out.println("Complete")
        );*/

    // Subscribe to a flux using an implementation of BaseSubscriber
    ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

    System.out.println("Press a key to end");
    System.in.read();
  }

}

class MySubscriber<T> extends BaseSubscriber<T> {

  @Override
  protected void hookOnSubscribe(Subscription subscription) {
    System.out.println("Subscription happened.");
    request(1); // I'm ok to handle 1 request
  }

  @Override
  protected void hookOnNext(T value) {
    System.out.println(value.toString() + " received");
    request(2); // I'm ok to handle 2 requests (Flux will push next two emitted values)
  }

  @Override
  protected void hookOnComplete() {
    System.out.println("Complete");
  }
}