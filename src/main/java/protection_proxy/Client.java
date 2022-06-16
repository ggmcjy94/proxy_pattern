package protection_proxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ProtectionInterface protectionInterface = new ProtectionSubjectImpl("이현석");
        ProtectionInterface userProxy = getProxy(protectionInterface);
        System.out.println("TEST");
        System.out.println(userProxy.getName());
        userProxy.setName("User");
        System.out.println(userProxy.getName());

        System.out.println();
        System.out.println();

        ProtectionInterface notUserProxy = getNotUserProxy(protectionInterface);
        System.out.println("TEST");
        System.out.println(notUserProxy.getName());
        notUserProxy.setName("Not User");
        System.out.println(notUserProxy.getName());
    }

    private static ProtectionInterface getProxy(ProtectionInterface protectionInterface) {
        return (ProtectionInterface) Proxy.newProxyInstance(
                protectionInterface.getClass().getClassLoader(),
                protectionInterface.getClass().getInterfaces(),
                new UserHandler(protectionInterface));
    }

    private static ProtectionInterface getNotUserProxy(ProtectionInterface protectionInterface) {
        return (ProtectionInterface) Proxy.newProxyInstance(
                protectionInterface.getClass().getClassLoader(),
                protectionInterface.getClass().getInterfaces(),
                new NotUserHandler(protectionInterface));
    }
}
