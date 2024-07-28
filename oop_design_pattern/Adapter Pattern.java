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

class Main {
  public static void main(String[] args) {
    JsonLogger logger = new LoggerAdapter(new XmlLogger());
    logger.logMessage("<message>hello</message>");
  }
}


// Practice
class SquareHole {
    private double sideLength;

    public SquareHole(double sideLength) {
        this.sideLength = sideLength;
    }

    public boolean canFit(Square square) {
        return this.sideLength >= square.getSideLength();
    }
}

class Square {
    private double sideLength;

    public Square() {}

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return this.sideLength;
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

class CircleToSquareAdapter extends Square {
    private Circle circle;

    public CircleToSquareAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public double getSideLength() {
        return 2 * this.circle.getRadius();
    }
}
