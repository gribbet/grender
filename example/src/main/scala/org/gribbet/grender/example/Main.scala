package org.gribbet.grender.example

object Main extends App {
  Console.println("Hello World example: ")
  Console.println(new HelloWorld().render())
  Console.println()
  Console.println()
  Console.println("Address Book example: ")
  Console.println(new AddressBook().render())
}