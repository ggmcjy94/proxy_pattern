package protection_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandler implements InvocationHandler {

    private ProtectionInterface protectionInterface;

    public UserHandler(ProtectionInterface protectionInterface) {
        this.protectionInterface = protectionInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(protectionInterface, args);
        } else if (method.getName().startsWith("set")) {
            return method.invoke(protectionInterface, args);
        }
        return null;
    }
}
