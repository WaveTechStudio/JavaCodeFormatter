import java.util.Stack;

/**
 * @author Amna Munawar
 *
 */
public class JSStack extends Stack<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#empty()
	 */
	@Override
	public boolean empty() {
		return super.empty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#peek()
	 */
	@Override
	public synchronized Object peek() {
		return super.peek();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#pop()
	 */
	@Override
	public synchronized Object pop() {
		return super.pop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#push(java.lang.Object)
	 */
	@Override
	public Object push(Object arg0) {
		return super.push(arg0);
	}

}
