package uk.co.jemos.podam.test.dto.pdm4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import uk.co.jemos.podam.common.PodamConstructor;

/**
 * Pojo to test to test multiple non-public constructors and setters
 * 
 * @author divanov
 * 
 */
public class PojoWithMultipleNonPublicConstructors {

	public static List<String> invocationOrder = new ArrayList<String>();

	private String value;
	
	protected PojoWithMultipleNonPublicConstructors(InputStream inputStream) {
		invocationOrder.add("InputStream");
		if (inputStream == null) {
			throw new NullPointerException("Invalid input stream provided");
		}
	}

	protected PojoWithMultipleNonPublicConstructors(int num, int num2) {
		invocationOrder.add("int,int");
		value = String.valueOf(num + num2);
	}
	
	@PodamConstructor(comment = "choose this one")
	private PojoWithMultipleNonPublicConstructors(String value) {
		invocationOrder.add("PodamConstructor");
		throw new IllegalStateException("Cannot use me");
	}

	protected PojoWithMultipleNonPublicConstructors() {
		invocationOrder.add("no-op");
		throw new IllegalStateException("Cannot use me too");
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("{value: '%s'}", value);
	}
}
