package virtual_proxy;

public class Client {

    //인터페이스를 통해 RealSubject 와 Proxy 객체가 사용할 메소드를 정의합니다.
    // 이후, Proxy 객체에서 제어 혹은 기능을 추가하여 구현할 수 있습니다.

    public static void main(String[] args) {
        ProxyInterface proxyInterface = new Proxy();
        proxyInterface.printStatement();

    }
}
