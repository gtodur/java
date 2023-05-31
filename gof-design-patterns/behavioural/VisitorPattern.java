package com.patterns.behavioural;

public class VisitorPattern {

	public static void main(String[] args) {
		MacMailClientVisitor macVisitor = new MacMailClientVisitor();
		LinuxMailClientVisitor linuxVisitor = new LinuxMailClientVisitor();
		WindowsMailClientVisitor windowsVisitor = new WindowsMailClientVisitor();
		OperaMailClient operaMailClient = new OperaMailClient();
		SquirrelMailClient squirrelMailClient = new SquirrelMailClient();
		ZimbraMailClient zimbraMailClient = new ZimbraMailClient();

		System.out.println("-----Testing Opera Mail Client for different environments-----");
		// all return true
		operaMailClient.accept(macVisitor);
		operaMailClient.accept(linuxVisitor);
		operaMailClient.accept(windowsVisitor);

		System.out.println("\n-----Testing Squirrel Mail Client for different environments-----");
		// all return true
		squirrelMailClient.accept(macVisitor);
		squirrelMailClient.accept(linuxVisitor);
		squirrelMailClient.accept(windowsVisitor);

		System.out.println("\n-----Testing Zimbra Mail Client for different environments-----");
		// all return true
		zimbraMailClient.accept(macVisitor);
		zimbraMailClient.accept(linuxVisitor);
		zimbraMailClient.accept(windowsVisitor);

	}

}

/*
 * Element Is an interface that contains accept() method that takes a visitor as
 * an argument.
 */
interface MailClient {
	void sendMail(String[] mailInfo);

	void receiveMail(String[] mailInfo);

	boolean accept(MailClientVisitor visitor);
}

/*
 * Concrete Element Implements the accept() method declared in Element.
 */
class OperaMailClient implements MailClient {
	@Override
	public void sendMail(String[] mailInfo) {
		System.out.println(" OperaMailClient: Sending mail");
	}

	@Override
	public void receiveMail(String[] mailInfo) {
		System.out.println(" OperaMailClient: Receiving mail");
	}

	@Override
	public boolean accept(MailClientVisitor visitor) {
		visitor.visit(this);
		return true;
	}
}

/*
 * Concrete Element Implements the accept() method declared in Element.
 */
class SquirrelMailClient implements MailClient {
	@Override
	public void sendMail(String[] mailInfo) {
		System.out.println(" SquirrelMailClient: Sending mail");
	}

	@Override
	public void receiveMail(String[] mailInfo) {
		System.out.println(" SquirrelMailClient: Receiving mail");
	}

	@Override
	public boolean accept(MailClientVisitor visitor) {
		visitor.visit(this);
		return true;
	}
}

/*
 * Concrete Element Implements the accept() method declared in Element.
 */
class ZimbraMailClient implements MailClient {
	@Override
	public void sendMail(String[] mailInfo) {
		System.out.println(" ZimbraMailClient: Sending mail");
	}

	@Override
	public void receiveMail(String[] mailInfo) {
		System.out.println(" ZimbraMailClient: Receiving mail");
	}

	@Override
	public boolean accept(MailClientVisitor visitor) {
		visitor.visit(this);
		return true;
	}
}

/*
 * Visitor Is an interface that declares a visit() method for each class of
 * ConcreteElement in the object structure.
 */
interface MailClientVisitor {
	void visit(OperaMailClient mailClient);

	void visit(SquirrelMailClient mailClient);

	void visit(ZimbraMailClient mailClient);
}

/*
 * Concrete Visitor concrete classes that implements each method declared by
 * Visitor.
 */
class WindowsMailClientVisitor implements MailClientVisitor {
	@Override
	public void visit(OperaMailClient mailClient) {
		System.out.println("Configuration of Opera mail client for Windows complete");
	}

	@Override
	public void visit(SquirrelMailClient mailClient) {
		System.out.println("Configuration of Squirrel mail client for Windows complete");
	}

	@Override
	public void visit(ZimbraMailClient mailClient) {
		System.out.println("Configuration of Zimbra mail client for Windows complete");
	}
}

/*
 * Concrete Visitor concrete classes that implements each method declared by
 * Visitor.
 */
class MacMailClientVisitor implements MailClientVisitor {
	@Override
	public void visit(OperaMailClient mailClient) {
		System.out.println("Configuration of Opera mail client for Mac complete");
	}

	@Override
	public void visit(SquirrelMailClient mailClient) {
		System.out.println("Configuration of Squirrel mail client for Mac complete");
	}

	@Override
	public void visit(ZimbraMailClient mailClient) {
		System.out.println("Configuration of Zimbra mail client for Mac complete");
	}
}

/*
 * Concrete Visitor concrete classes that implements each method declared by
 * Visitor.
 */
class LinuxMailClientVisitor implements MailClientVisitor {
	@Override
	public void visit(OperaMailClient mailClient) {
		System.out.println("Configuration of Opera mail client for Linux complete");
	}

	@Override
	public void visit(SquirrelMailClient mailClient) {
		System.out.println("Configuration of Squirrel mail client for Linux complete");
	}

	@Override
	public void visit(ZimbraMailClient mailClient) {
		System.out.println("Configuration of Zimbra mail client for Linux complete");
	}
}
