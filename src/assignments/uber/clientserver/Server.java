package assignments.uber.clientserver;



import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

import static java.lang.System.out;

/*
 *  Simple XML-RPC server.
 *  Run as normal
 *
 *  This is just to handle the network, all logic in Calculator
 */
public class Server {
    final int port = 8080;

    public static void main(String[] args) throws Exception {
        new Server().program();

    }

    void program() {
        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try {
            phm.addHandler("Calculator", Calculator.class);
            xmlRpcServer.setHandlerMapping(phm);

        /*XmlRpcServerConfigImpl serverConfig =
                (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);*/
            out.println("Starting server on port: " + port);

            webServer.start();
        } catch (IOException | XmlRpcException e) {
            e.printStackTrace();
        }
    }

}