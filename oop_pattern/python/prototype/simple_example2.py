from abc import ABC, abstractmethod


class Shape(ABC):
    @abstractmethod
    def clone(self):
        pass


class Square(Shape):
    def __init__(self, length: int):
        self.length = length

    def get_length(self) -> int:
        return self.length

    def clone(self) -> Shape:
        return Square(self.length)


class Rectangle(Shape):
    def __init__(self, width: int, height: int):
        self.width = width
        self.height = height

    def get_width(self) -> int:
        return self.width

    def get_height(self) -> int:
        return self.height

    def clone(self) -> Shape:
        return Rectangle(self.width, self.height)


class Test:
    def clone_shapes(self, shapes: list[Shape]) -> list[Shape]:
        return [shape.clone() for shape in shapes]
