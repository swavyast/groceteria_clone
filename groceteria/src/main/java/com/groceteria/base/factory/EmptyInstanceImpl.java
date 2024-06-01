package com.groceteria.base.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

import com.groceteria.base.exception.InstantiationFailedException;

@Component
public class EmptyInstanceImpl<T> implements EmptyInstance<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T forClass(Class<T> clazz) throws InstantiationFailedException {
		try {

			Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();

			if (noArgConstructor != null) {

				noArgConstructor.setAccessible(true);

				return (T) noArgConstructor.newInstance();

			} else {

				throw new IllegalArgumentException(
						"No no-argument constructor found for the class: " + clazz.getName());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			throw new InstantiationFailedException(clazz, e);
		}
	}

}