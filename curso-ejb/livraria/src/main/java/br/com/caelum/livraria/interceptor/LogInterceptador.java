package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object interceptor(InvocationContext context) throws Exception {

		long millis = System.currentTimeMillis();

		Object object = context.proceed();
		String metodo = context.getMethod().getName();
		String clazz = context.getTarget().getClass().getName();

		System.out.println(":====: INTERCEPTOR :====: ::: Classe [" + clazz + "] === Metodo [" + metodo + "] === Tempo gasto ["
				+ (System.currentTimeMillis() - millis) + "]");

		return object;
	}
}