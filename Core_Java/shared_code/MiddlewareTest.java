class StringOpr {
	public String getCapital(String name) {
		return name.toUpperCase();
	}
}
class Middleware {
	public static Object invokeMethod(String className, String methodName, Class paramTypes[], Object paramValues[]) {
	
	}
}
class MiddlewareTest {
	public static void main(String args[]) throws Exception {
		Class paramTypes[] = new Class[1];
		paramTypes[0] = java.lang.String.class;
		Object paramValues[] = new Object[1];
		paramValues[0] = "iter";
		Middleware.invokeMethod("StringOpr", "getCapital", paramTypes, paramValues);
	}
}


