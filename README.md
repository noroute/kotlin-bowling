# Bowling for Kotlin

This is my learning exercise into Kotlin. This might not be idiomatic
(or even good or correct) Kotlin code.

## Features

Takes a Bowling game description from a text file
and calculates the total score.

## File Format
Each line represents a game. Rolls are denoted
by number of pins down (0..9), spares (`/`) and
strikes (`X`) (see [Wikipedia](https://en.wikipedia.org/wiki/Ten-pin_bowling#Traditional_scoring)).

Frames are separated by comma (`,`) for readability.

The program checks the number of Frames to be 10
but does _not_ check or enforce correctness of the
input!

Example game:
```
14,45,6/,5/,X,01,7/,6/,X,2/6
```

## Running

`./gradlew run --args='filename.txt'`

## Requirements
* JDK 1.8
* Gradle
* Kotlin

## Limitations
* minimal error checking and enforcement
* command-line interface is very basic, no switches, no help, no standalone application

## Design considerations
(This was an attempt to learn some Kotlin so the design might
not be optimal for the language)
* make rules explicit
* readability over performance

## First impressions about Kotlin
* first-class functions are very nice
* feels very functional
* type system feels right (strong types, little clutter)
* integration into Java world is noisy at times (`JvmStatic`)
* language noise is hard to avoid (e.g. [Spek](https://spekframework.org/) is ugly, does not
  feel as elegant as [Spock](http://spockframework.org/))