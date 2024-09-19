# Todo List
A simple todo list that allows you to create, update, delete and view the todos in the todo list. Using OOP principles, the list is functional on the command line. I also added unit tests using JUnit.

## Example
```plaintext
================================

Commands:
add: add a todo to list
remove: remove todo from list
print: print your todo list
set: set if task is complete
end: quit application

================================

Enter your command: add
Add new todo: Clean my room

Clean my room successfully added!

Enter you command: print

Your todo list
1. Clean my room

Enter your command: add
Add new todo: Wash dishes

Wash dishes successfully added!

Enter your command: set
Which todo do you want to modify (Enter name)?  Wash dishes
Is this todo complete (y/n)? y
Wash dishes successfully modified

Enter your command: print

Your todo list
1. Clean my room
2. Wash dishes ✅

Enter your command: remove
Remove a todo: Wash dishes
Wash dishes successfully removed!

Enter your command: print

Your todo list
1. Clean my room

Enter your command: end
Ending application...
```