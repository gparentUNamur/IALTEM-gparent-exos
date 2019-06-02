package be.pj;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World !");
        PrintService[] services = PrintServiceLookup.lookupPrintServices(
                DocFlavor.INPUT_STREAM.JPEG, null);
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        if (services.length > 0) {
            PrintService service = ServiceUI.printDialog(null, 50, 50,
                    services, services[0],
                    null,
                    attributes);
            System.out.println(service);
        }
    }
}
