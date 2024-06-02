from abc import ABC, abstractmethod


class JsonLogger(ABC):
    @abstractmethod
    def log_message(self, message: str) -> None:
        pass


class XmlLogger:
    def log(self, xml_message: str) -> None:
        print(xml_message)


class LoggerAdapter(JsonLogger):
    def __init__(self, xml_logger: XmlLogger) -> None:
        self.xml_logger = xml_logger

    def log_message(self, message: str) -> None:
        self.xml_logger.log(message)


logger = LoggerAdapter(XmlLogger())
logger.log_message("<message>hello</message>")


# Practice
class Square:
    def __init__(self, sideLength=0.0):
        self.sideLength = sideLength

    def getSideLength(self) -> float:
        return self.sideLength


class SquareHole:
    def __init__(self, sideLength: float):
        self.sideLength = sideLength

    def canFit(self, square: Square):
        return self.sideLength >= square.getSideLength()


class Circle:
    def __init__(self, radius: float):
        self.radius = radius

    def getRadius(self):
        return self.radius


class CircleToSquareAdapter(Square):
    def __init__(self, circle: Circle):
        self.circle = circle

    def getSideLength(self) -> float:
        return 2 * self.circle.getRadius()
