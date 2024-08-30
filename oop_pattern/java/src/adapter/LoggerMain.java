package adapter;

public class LoggerMain {
    public static void main(String[] args) {
        JsonLogger logger = new LoggerAdapter(new XmlLogger());
        logger.logMessage("<message>hello</message>");
    }
}

interface JsonLogger {
    void logMessage(String message);
}

class XmlLogger {
    public void log(String xmlMessage) {
        System.out.println(xmlMessage);
    }
}

class LoggerAdapter implements JsonLogger {
    private final XmlLogger xmlLogger;

    public LoggerAdapter(XmlLogger xmlLogger) {
        this.xmlLogger = xmlLogger;
    }

    @Override
    public void logMessage(String message) {
        xmlLogger.log(message);
    }
}
