public class EmptyStackException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg Error message to print on screen
	 */
	public EmptyStackException(String msg) {
		System.out.println("Stack is currently empty!");
	}
}
