from abc import ABC, abstractmethod


# 没有任何初始化也可以创建类！
class XmlLogger:
    def log(self, xml_message: str) -> None:
        print(xml_message)


class JsonLogger(ABC):
    # 虚拟方法必须被重写
    @abstractmethod
    def log_message(self, message: str) -> None:
        pass


class LoggerAdapter(JsonLogger):
    def __init__(self, xml_logger: XmlLogger) -> None:
        self.xml_logger = xml_logger

    def log_message(self, message: str) -> None:
        self.xml_logger.log(message)


logger = LoggerAdapter(XmlLogger())
logger.log_message("<message>hello</message>")
