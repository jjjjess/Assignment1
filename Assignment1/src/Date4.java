// ***************************************
// Jesse Tripp
// COSC 211
// Assignment 1 - Refactoring Date.java
// ***************************************


import java.util.Scanner;

public class Date2 {
  private String month;
  private int day;
  private int year; // a four digit number.

  public Date2() {
    month = "January";
    day = 1;
    year = 1000;
  }

  public Date2(int monthInt, int day, int year) {
    setDate(monthInt, day, year);
  }

  public Date2(String monthString, int day, int year) {
    setDate(monthString, day, year);
  }

  // removed 2 unneeded date methods

  public void setDate(int monthInt, int day, int year) {
    if (dateOK(monthInt, day, year)) {
      this.month = monthString(monthInt);
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(String monthString, int day, int year) {
    if (dateOK(monthString, day, year)) {
      this.month = monthString;
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  // removed second setDate method

  public void setYear(int year) {
    if ((year < 1000) || (year > 9999)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.year = year;
  }

  public void setMonth(int monthNumber) {
    if ((monthNumber <= 0) || (monthNumber > 12)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      month = monthString(monthNumber);
  }

  public void setDay(int day) {
    if ((day <= 0) || (day > 31)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.day = day;
  }

  // Re-written getMonth() using new Switch statement expression
  public int getMonth() {
    switch (month) {
      case "January" -> System.out.println(1);
      case "February" -> System.out.println(2);
      case "March" -> System.out.println(3);
      case "April" -> System.out.println(4);
      case "May" -> System.out.println(5);
      case "June" -> System.out.println(6);
      case "July" -> System.out.println(7);
      case "August" -> System.out.println(8);
      case "September" -> System.out.println(9);
      case "October" -> System.out.println(10);
      case "November" -> System.out.println(11);
      case "December" -> System.out.println(12);
      default -> System.out.println("Error");
    }
    return 0; // Needed to keep the compiler happy
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return (month + " " + day + ", " + year);
  }

  public boolean equals(Date2 otherDate) {
    return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
  }

  public boolean precedes(Date2 otherDate) {
    return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
        || (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
  }

  public void readInput() {
    boolean tryAgain = true;
    Scanner keyboard = new Scanner(System.in);
    while (tryAgain) {
      System.out.println("Enter month, day, and year.");
      System.out.println("Do not use a comma.");
      var monthInput = keyboard.next(); // changed from type 'String'
      var dayInput = keyboard.nextInt(); // changed from type 'int'
      var yearInput = keyboard.nextInt(); // changed from type 'int'
      if (dateOK(monthInput, dayInput, yearInput)) {
        setDate(monthInput, dayInput, yearInput);
        tryAgain = false;
      } else
        System.out.println("Illegal date. Reenter input.");
    }
  }

  private boolean dateOK(int monthInt, int dayInt, int yearInt) {
    return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31)
        && (yearInt >= 1000) && (yearInt <= 9999));
  }

  private boolean dateOK(String monthString, int dayInt, int yearInt) {
    return (monthOK(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
        && (yearInt <= 9999));
  }

  // Re-written monthOK using Switch statement expression
  private boolean monthOK(String month) {
    switch (month) {
      case "Janurary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December":
        return true;
    }
    return true; // not sure if this line is correct - have to double check with prof
  }

  // Re-written monthString() using new Switch statement expression
  private String monthString(int monthNumber) {
    switch (monthNumber) {
      case 1 -> System.out.println("January");
      case 2 -> System.out.println("February");
      case 3 -> System.out.println("March");
      case 4 -> System.out.println("April");
      case 5 -> System.out.println("May");
      case 6 -> System.out.println("June");
      case 7 -> System.out.println("July");
      case 8 -> System.out.println("August");
      case 9 -> System.out.println("September");
      case 10 -> System.out.println("October");
      case 11 -> System.out.println("November");
      case 12 -> System.out.println("December");
      default -> System.out.println("Fatal Error");
    }
    System.exit(0);
    return "Error"; // to keep the compiler happy
  }
}
