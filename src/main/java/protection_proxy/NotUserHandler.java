package protection_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NotUserHandler implements InvocationHandler {

    private ProtectionInterface protectionInterface;

    public NotUserHandler(ProtectionInterface protectionInterface) {
        this.protectionInterface = protectionInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(protectionInterface, args);
        } else if (method.getName().startsWith("set")) {
            System.out.println("유저에게 접근권한이 없습니다.");
        }
        return null;
    }
}
