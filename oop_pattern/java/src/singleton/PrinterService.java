package singleton;

class PrinterService {

    private static volatile PrinterService uniqueInstance = null;

    private String mode = null;

    private PrinterService() {
        this.mode = "GrayScale";
    }

    // 单例模式确保只创建一个实例，比如state统一管理或者log统一管理的场景
    public static PrinterService getInstance() {
        if (uniqueInstance == null) {
            synchronized (PrinterService.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new PrinterService();
                }
            }
        }
        return uniqueInstance;
    }

    public String getPrinterStatus() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
        System.out.println("Mode changed to " + mode);
    }
}
