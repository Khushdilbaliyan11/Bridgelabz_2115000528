import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static boolean contains(String key) {
        return cache.containsKey(key);
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    public static void put(String key, Object value) {
        cache.put(key, value);
    }
}

class CachedComputation {
    @CacheResult
    public int expensiveCalculation(int number) {
        System.out.println("Computing factorial for: " + number);
        return factorial(number);
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public Object invokeWithCache(String methodName, Object... args) throws Exception {
        Method method = this.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = methodName + "(" + args[0] + ")";
            if (CacheManager.contains(cacheKey)) {
                System.out.println("Returning cached result for: " + args[0]);
                return CacheManager.get(cacheKey);
            }

            Object result = method.invoke(this, args);
            CacheManager.put(cacheKey, result);
            return result;
        }

        return method.invoke(this, args);
    }
}

public class CustomCacheSystem {
    public static void main(String[] args) throws Exception {
        CachedComputation computation = new CachedComputation();

        System.out.println("Result: " + computation.invokeWithCache("expensiveCalculation", 5));
        System.out.println("Result: " + computation.invokeWithCache("expensiveCalculation", 5));
        System.out.println("Result: " + computation.invokeWithCache("expensiveCalculation", 6));
    }
}
