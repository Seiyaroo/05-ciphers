# ![CF](http://i.imgur.com/7v5ASc8.png) Ciphers

**ciphers.Cipher:** a secret or disguised way of writing; a code.

## Resources  
* [Wikipedia: ROT13](https://en.wikipedia.org/wiki/ROT13)
* [Caeser ShiftCipher](http://practicalcryptography.com/ciphers/caesar-cipher/)
* [Wikipedia: Keyword ciphers.Cipher](https://en.wikipedia.org/wiki/Keyword_cipher)

## Feature Tasks
For this assignment you will be implementing various ciphers to encode and
decode text. You will create a command line interface where users can type in
their console for your program to receive input. Users will be able to choose
the type of cipher they want to use, choose whether they want to encode or
decode with the cipher, paste text into the console and read text output to the
console.

Your program should handle input gracefully. Use `try-catch` statements to
prevent the program from crashing when users enter bad input and print out
helpful error messages instead.

Use inheritance to implement a base `ciphers.Cipher` class then have other
cipher classes extend from there.

## Requirements
Your project structure should contain the following classes and package:

* `Main.java` as the main file that handles command line input.
* `ciphers` package
  * `ciphers.Cipher.java`
  * `ciphers.ROT13Cipher.java`
  * `ciphers.CaesarShiftCipher.java`
  * `ciphers.KeywordCipher.java`


Refer to the resource links above to see the exact details of each cipher.

* You may assume all text in the ciphers is always lowercase.
* You may not assume text does not contain spaces or punctuation.

#### The Plain Text ciphers.Cipher Base Class
The `ciphers.Cipher` base class listed here just encodes and decodes alphabetic
characters to themselves. It maps "a" to "a" in encoding and maps "a"
back to "a" when decoding, for all letters.

The `ciphers.Cipher` class should have the following properties and methods:

```java
public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

public String encode(String payload) {}
public String decode(String payload) {}
protected String replaceCharacters(String payload, String source, String target) {
```

Every other cipher class extends from `ciphers.Cipher`. Each extended class (the sub-classes) should
override the `encode` and `decode` methods, but use the inherited
`replaceCharacters` utility method to perform the character replacement.

Reminder:

* `public` functions are accessible to all other classes.
* `private` functions are accessible only to the current class, and are not
  inherited.
* `protected` functions are accessible to the current class, and any class
  extending from the current class.

Notice that `replaceCharacters` is marked as `protected`. No one outside the
`ciphers.Cipher` class should need to call `replaceCharacters` directly.
Anyone outside the class should instead interact with the cipher class via
the public `encode` and `decode` methods. The `replaceCharacters` method is not
marked as `private` because we want to make the method available to the
sub-classes.

The `public static final String ALPHABET` property is made available so all
other cipher classes have a convenient access to the alphabet and you don't
have to rewrite that over and over. The `final` keyword prevents the variable
from ever changing, like `const` in JavaScript.

## Implementing the Ciphers
Each cipher should generate it's own replacement alphabet when it's
constructed. It will use the original alphabet and the replacement alphabet as
parameters to pass to the `replaceCharacters` function.

The cipher classes should have the following signatures for their constructors:

* `public ciphers.Cipher()`
* `public ciphers.ROT13Cipher()`
* `public ciphers.CaesarShiftCipher(int shiftAmount)`
* `public ciphers.KeywordCipher(String keyword)`

The `ciphers.Cipher` and the `ciphers.ROT13Cipher` classes don't have parameters for their
constructors because they're unconfigurable, they always behave the same.

The `ciphers.CaesarShiftCipher` and `ciphers.KeywordCipher` accept parameters for their
constructor because they are configurable. Use the constructor as a place to
generate the plaintext-to-ciphertext (and vice versa) alphabet mappings and
store them as private properties of the class.

## Testing
* Write unit tests for each type of cipher.
* Test cases should include
  * encoding an empty string
  * decoding an empty string
  * encoding a short word
  * decoding a short word
  * verifying encoded input is decoded back to the original input properly.
  * verifying encoding and decoding ignores non-alphabetic characters
    (whitespace, numbers, punctuation).

## Main.java CLI Tips
You will want to define a strategy for solving the problem **before you begin to
code.** Once you have a strategy defined, you can break it into steps that can be
split into helper methods. Each helper method should solve a small specific
problem. The main method should utilize the helper modules to execute your
original strategy.

Our example solution contains three private helper methods for receiving
different variations of user input, and the `main` method contains 31 lines of
code.

## Example Input / Output

Using the plaintext cipher:

```txt
Select your operation
1: encode
2: decode
Your choice: 1

Select your cipher
1: Plain Text ciphers.Cipher
2: ROT13 ciphers.Cipher
3: Caesar Shift ciphers.Cipher
4: Keyword ciphers.Cipher
Your choice: 1

You're encoding with the Plain Text ciphers.Cipher.

 plaintext: hello
ciphertext: hello
```

Decoding with the ROT13 cipher:

```txt
Select your operation
1: encode
2: decode
Your choice: 2

Select your cipher
1: Plain Text ciphers.Cipher
2: ROT13 ciphers.Cipher
3: Caesar Shift ciphers.Cipher
4: Keyword ciphers.Cipher
Your choice: 2

You're decoding with the ROT13 ciphers.Cipher.

ciphertext: trbetr jnfuvatgba
 plaintext: george washington
```

Encoding with the Caesar Shift ciphers.Cipher:

```txt
Select your operation
1: encode
2: decode
Your choice: 1

Select your cipher
1: Plain Text ciphers.Cipher
2: ROT13 ciphers.Cipher
3: Caesar Shift ciphers.Cipher
4: Keyword ciphers.Cipher
Your choice: 3

You're encoding with the Caesar Shift ciphers.Cipher
Enter shift amount [0-25]: 1
abcdefghijklmnopqrstuvwxyz
bcdefghijklmnopqrstuvwxyza

 plaintext: defend the east wall of the castle
ciphertext: efgfoe uif fbtu xbmm pg uif dbtumf
```

Encoding with Keyword ciphers.Cipher with simple keyword:

```txt
Select your operation
1: encode
2: decode
Your choice: 2

Select your cipher
1: Plain Text ciphers.Cipher
2: ROT13 ciphers.Cipher
3: Caesar Shift ciphers.Cipher
4: Keyword ciphers.Cipher
Your choice: 4

You're encoding with the Keyword ciphers.Cipher
Enter keyword: dog

abcdefghijklmnopqrstuvwxyz
abcefhijklmnpqrstuvwxyzdog

 plaintext: who's a good dogboi?
ciphertext: zjr'v a irre eribrk?
```

Encoding with the Keyword ciphers.Cipher where keyword includes duplicate letters.
Just count any duplicate letters in the keyword as if they only appeared
once.

```txt
Select your operation
1: encode
2: decode
Your choice: 2

Select your cipher
1: Plain Text ciphers.Cipher
2: ROT13 ciphers.Cipher
3: Caesar Shift ciphers.Cipher
4: Keyword ciphers.Cipher
Your choice: 4

You're encoding with the Keyword ciphers.Cipher
Enter keyword: slamma lamma dingdong

abcdefghijklmnopqrstuvwxyz
bcefhjkpqrtuvwxyzslamdingo

 plaintext: he's heating up!
ciphertext: ph'l phbaqwk my!
```

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request

## Stretch Goals
* Rearrange the ROT13 cipher so it's a subclass of the Caesar Shift cipher that
  always creates itself with a shift of `13`.
* Configure the `replaceCharacters` method to preserve capitalization.
* Configure the program to accept command line arguments via `main(String[] args)`
* Configure the program to allow users to enter filenames for their plaintext
  or ciphertext input.

