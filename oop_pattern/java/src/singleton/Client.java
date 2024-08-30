package singleton;

class Client {

    public static void main(String[] args) {
        PrinterService worker1 = PrinterService.getInstance();
        PrinterService worker2 = PrinterService.getInstance();

        worker1.setMode("Color");
        worker2.setMode("Grayscale");

        String worker1Mode = worker1.getPrinterStatus();
        String worker2Mode = worker2.getPrinterStatus();

        System.out.println(worker1Mode); //
        System.out.println(worker2Mode);
    }
}
