class Stack:
    def __init__(self):
        self.stack = []

    def add(self, data):
        self.stack.append(data)

    def pull(self):
        if self.stack:
            data = self.stack[-1]
            self.stack = self.stack[:len(self.stack) - 1]
            print(f"Pulled Data: {data}\nStack: {self.stack}")
            return data
        else:
            print("Stack is empty!")

    def __repr__(self):
        return repr(self.stack)


_stack = Stack()

_stack.pull()
_stack.add(1)
print(_stack)
_stack.add(2)
print(_stack)
_stack.pull()