import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class WebServer {
    public static void main(String[] args) throws Exception {
        Server sw = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(Home.class, "/");

        sw.setHandler(handler);
        sw.start();
        sw.join();
    }
}
