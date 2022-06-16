package virtual_proxy;

public class Proxy implements ProxyInterface {

    ProxyInterface proxyInterface;

    @Override
    public void printStatement() {
        proxyInterface = new RealSubject();
        System.out.println("Here is Proxy Class");
        proxyInterface.printStatement();
    }
}
