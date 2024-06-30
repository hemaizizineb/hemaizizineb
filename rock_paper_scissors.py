# Import the random module to generate random numbers
import random

# Print the rules of the game
print('Winning rules of the game ROCK PAPER SCISSORS are:\n'
      + "Rock vs Paper -> Paper wins \n"
      + "Rock vs Scissors -> Rock wins \n"
      + "Paper vs Scissors -> Scissor wins \n")

# Start the game loop that will keep running until the user decides to quit
while True:

    # Display the options for the user to choose from
    print("Enter your choice \n 1 - Rock \n 2 - Paper \n 3 - Scissors \n")

    # Take the user's choice as input and convert it to an integer
    choice = int(input("Enter your choice: "))

    # Validate the user's input; if it's not a valid choice, keep asking for a valid one
    while choice > 3 or choice < 1:
        choice = int(input('Enter a valid choice please ☺'))

    # Map the user's choice to the corresponding name
    if choice == 1:
        choice_name = 'Rock'
    elif choice == 2:
        choice_name = 'Paper'
    else:
        choice_name = 'Scissors'

    # Print the user's choice
    print('User choice is:', choice_name)
    print('Now it\'s the Computer\'s Turn...')

    # Computer randomly chooses a number between 1 and 3
    comp_choice = random.randint(1, 3)

    # If the computer's choice matches the user's choice, generate a new choice 
    # This part is   removed to allow draws
    # while comp_choice == choice:
     #   comp_choice = random.randint(1, 3)

    # Map the computer's choice to the corresponding name
    if comp_choice == 1:
        comp_choice_name = 'Rock'
    elif comp_choice == 2:
        comp_choice_name = 'Paper'
    else:
        comp_choice_name = 'Scissors'

    # Print the computer's choice
    print("Computer choice is:", comp_choice_name)
    print(choice_name, 'vs', comp_choice_name)

    # Determine the result of the game
    # Check for a draw
    if choice == comp_choice:
        print('It\'s a Draw', end="")
        result = "DRAW"
    # Check all possible win conditions for the user
    elif (choice == 1 and comp_choice == 2):
        print('Paper wins =>', end="")
        result = 'Paper'
    elif (choice == 2 and comp_choice == 1):
        print('Paper wins =>', end="")
        result = 'Paper'
    elif (choice == 1 and comp_choice == 3):
        print('Rock wins =>', end="")
        result = 'Rock'
    elif (choice == 3 and comp_choice == 1):
        print('Rock wins =>', end="")
        result = 'Rock'
    elif (choice == 2 and comp_choice == 3):
        print('Scissors wins =>', end="")
        result = 'Scissors'
    elif (choice == 3 and comp_choice == 2):
        print('Scissors wins =>', end="")
        result = 'Scissors'

    # Print the result: either the user wins, the computer wins, or it's a tie
    if result == "DRAW":
        print("<== It's a tie ==>")
    elif result == choice_name:
        print("<== User wins ==>")
    else:
        print("<== Computer wins ==>")

    # Ask the user if they want to play again
    print("Do you want to play again? (Y/N)")
    ans = input().lower()

    # Break the loop if the user chooses not to play again
    if ans == 'n':
        break

# After exiting the loop, print a thank you message
print("Thanks for playing!")
