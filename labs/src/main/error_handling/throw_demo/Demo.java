package error_handling.throw_demo;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;

/**
 * Created by LanAnh on 12/12/2016.
 */
public class Demo {
    public void deposit(double amount) throws RemoteException {
        // Method implementation
        throw new RemoteException();
    }

    public void withdraw(double amount) throws RemoteException, FileNotFoundException {
        // Method implementation
    }
}

