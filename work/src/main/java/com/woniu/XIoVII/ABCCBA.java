package com.woniu.XIoVII;

public class ABCCBA {
	public static void main(String[] args) {
		Foo f = new Foo();
		Thread t1 = new Thread(new A(f));
		Thread t2 = new Thread(new B(f));
		Thread t3 = new Thread(new C(f));
		t1.start();
		t2.start();
		t3.start();
	}
}

class A implements Runnable {
	private Foo f;

	public A(Foo f) {
		super();
		this.f = f;
	}

	public void run() {
		while (true) {
			synchronized (f) {
				while (f.x != 1) {
					try {
						f.notifyAll();
						f.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("A");
				
				if (f.a) {
					f.a = !f.a;
				} else {
					f.x++;
				}
			}
		}

	}
}

class B implements Runnable {
	private Foo f;

	public B(Foo f) {
		super();
		this.f = f;
	}

	public void run() {
		while (true) {
			synchronized (f) {
				while (f.x != 2) {
					try {
						f.notifyAll();
						f.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("B");

				if (f.a) {
					f.x--;
				} else {
					f.x++;
				}

			}
		}

	}
}

class C implements Runnable {
	private Foo f;

	public C(Foo f) {
		super();
		this.f = f;
	}

	public void run() {
		while (true) {
			synchronized (f) {
				while (f.x != 3) {
					try {
						f.notifyAll();
						f.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("C");

				if (f.a) {
					f.x--;
				} else {
					f.a = !f.a;
				}
			}
		}

	}
}

class Foo {
	int x = 1;
	boolean a = false;
}