# Bagels Game
In Bagels, a deductive logic game, you must guess a secret three-digit number based on clues. The game offers one of the following hints in response to your guess: 
- “Pico” when your guess has a correct digit in the wrong place
- “Fermi” when your guess has a correct digit in the correct place 
- “Bagels” if your guess has no correct digits 

You have 10 tries to guess the secret number.

## Example
```plaintext
==========================================================
I am thinking of a 3-digit number. Try to guess what it is.
Here are some clues:
When I say:     That means:
Pico            One digit is correct but in the wrong position.
Fermi           One digit is correct and in the right position.
Bagels          No digit is correct.

I have thought up a number.
You have 10 guesses to get it.

Guess #1: 452
Fermi Fermi
Guess #2: 524
Pico Pico
Guess #3: 198
Bagel
Guess #4: 462
You Got it!

Do you want to play again? (yes or no) no
Thanks for playing!
```
