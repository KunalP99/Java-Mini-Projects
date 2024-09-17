# Caesar Cipher
The Caesar cipher is an ancient encryption algorithm used by Julius Caesar. It encrypts letters by shifting them over by a certain number of places in the alphabet. We call the length of shift the key. For example, if the key is 3, then A becomes D, B becomes E, C becomes F, and so on. To decrypt the message, you must shift the encrypted letters in the opposite direction. This program lets the user encrypt and decrypt messages according to this algorithm.

More information 👉 [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher)

## Example
```plaintext
Do you want to (e)ncrypt or (d)ecrypt? e

Please enter the key (0 - 25) to use: 7

Enter the message to encrypt.
System.out.println("Hello World");

Your Message
ZFZALT.VBA.WYPUASU("OLSSV DVYSK");

Do you want to encrypt/decrypt another message? (y/n) y

Do you want to (e)ncrypt or (d)ecrypt? d

Please enter the key (0 - 25) to use: 7

Enter the message to decrypt.
ZFZALT.VBA.WYPUASU("OLSSV DVYSK");

Your message
SYSTEM.OUT.PRINTLN("HELLO WORLD");

Do you want to encrypt/decrypt another message? (y/n) n
Ending Program...
```