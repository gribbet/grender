package org.gribbet.grender.example

object Main extends App {
  Console.println("Hello World example: ")
  Console.println(new HelloWorld().rendered)
  Console.println()
  Console.println("Address Book example: ")
  Console.println(new AddressBook().rendered)
  Console.println()
  Console.println("Layout example: ")
  Console.println(new Page().rendered)
}