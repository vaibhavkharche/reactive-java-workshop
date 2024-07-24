package io.javabrains.reactiveworkshop;

public class Exercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()

    // Print all numbers in the intNumbersStream stream
    // TODO: Write code here
    StreamSources.intNumbersStream()
        .forEach(System.out::println);

    // Print numbers from intNumbersStream that are less than 5
    System.out.println("Numbers less than 5");
    StreamSources.intNumbersStream()
        .filter(n -> n < 5)
        .forEach(System.out::println);

    // Print the second and third numbers in intNumbersStream that's greater than 5
    System.out.println("second and third numbers that's greater than 5");
    StreamSources.intNumbersStream()
        .filter(n -> n > 5)
        .skip(1)
        .limit(2)
        .forEach(n -> System.out.println(n));

    //  Print the first number in intNumbersStream that's greater than 5.
    //  If nothing is found, print -1
    System.out.println("first number that's greater than 5 else -1");
    Integer result = StreamSources.intNumbersStream()
        .filter(n -> n > 5)
        .findFirst()
        .orElse(-1);
    System.out.println(result);

    // Print first names of all users in userStream
    System.out.println("first names of all users");
    StreamSources.userStream()
        .map(user -> user.getFirstName())
        .forEach(fname -> System.out.println(fname));

    // Print first names in userStream for users that have IDs from number stream
    System.out.println("first names of users have IDs from number stream");
    StreamSources.userStream()
        .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
        .map(user -> user.getFirstName())
        .forEach(fName -> System.out.println(fName));

    //  or
    System.out.println("-----------");
    StreamSources.intNumbersStream()
        .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
        .map(user -> user.getFirstName())
        .forEach(fName -> System.out.println(fName));
  }

}
