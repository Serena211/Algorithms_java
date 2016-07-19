package ex;
class A {
}

class B extends A {
}

class C extends B {
}

public class Carpet<V extends B> {
	public <X extends V> Carpet<? extends V> method(Carpet<? super X> e) {
		return new Carpet<V>();
		// insert code here
	}
}
