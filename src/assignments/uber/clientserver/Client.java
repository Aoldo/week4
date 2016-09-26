package assignments.uber.clientserver;



import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.IOException;
import java.net.URL;

import static java.lang.System.err;
import static java.lang.System.out;


/*
 *  Simple XML-RPC client.
 *  Run as normal
 *
 *  This is just to send calls to server
 *  A user interface should be added to handle interaction
 */
public class Client {
    public static void main(String[] args) {
        new Client().program();
    }

    void program() {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://127.0.0.1:8080/xmlrpc"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Object[] params = new Object[]{new Integer(33), new Integer(9)};
            out.println("Call Server");
            Integer result = (Integer) client.execute("Calculator.add", params);
            out.println("Result is: " + result);

        } catch (IOException | XmlRpcException e) {
            err.println("Server: " + e);
        }
    }
}