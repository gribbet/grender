package org.gribbet.grender.example

/*
 TODO:
 1. Jersey adapter and examples?
 2. Shorten Contain(
 */
object Main extends App {
  Console.println("Hello World example: ")
  Console.println(new HelloWorld().render())
  Console.println()
  Console.println("Address Book example: ")
  Console.println(new AddressBook().render())
  Console.println()
  Console.println("Layout example: ")
  Console.println(new Page().render())
}