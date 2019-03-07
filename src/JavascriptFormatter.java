/**
 * @author Waheed Nazir
 *
 */
public class JavascriptFormatter {

	/**
	 * Constant variable to hold newline character
	 */
	private String newLine = "\n";
	/**
	 * Constant variable to hold semicolon character
	 */
	private String semiColon = ";";
	/**
	 * Constant variable to hold opening curly brace character
	 */
	private String openingCurlyBrace = "{";
	/**
	 * Constant variable to hold closing curly brace character
	 */
	private String closingCurlyBrace = "}";
	/**
	 * Constant variable to hold closing parenthesis character
	 */
	private String openingParentheses = "(";
	/**
	 * Constant variable to hold opening parenthesis character
	 */
	private String closingParentheses = ")";
	/**
	 * Constant variable to hold indent level character
	 */
	private int indentLevel = 0;
	/**
	 * Constant variable to hold boolean to quit upon error while doing
	 * formatting character
	 */
	public static boolean closeDueToError = false;
	/**
	 * Constant Stack object
	 */
	private JSStack jsStack;

	/**
	 * enum BlockType that holds BRACE to indicate open and closing brace, PAREN
	 * to indicate open and closing parenthesis and FOR to indicate for loop
	 *
	 */
	public enum BlockType {
		BRACE, PAREN, FOR
	}

	/**
	 * JavascriptFormatter default constructor to initialize stack and indent
	 * level
	 */
	public JavascriptFormatter() {
		indentLevel = 0;
		jsStack = new JSStack();
	}

	/**
	 * @param output
	 *            is the string read from file and ready to format with proper
	 *            indentation
	 * @param charInput
	 *            is { } ( ) and ; character that is currently being read
	 * @return Returns the formatted output with proper indentation
	 */
	public String format(String output, String charInput) {

		if (output.length() >= 4 && charInput.equalsIgnoreCase(openingParentheses)) {
			String forText = output.substring(output.length() - 3);
			if (forText.equalsIgnoreCase("for")) {
				jsStack.push(BlockType.FOR);
			}
		}
		if ((charInput.equalsIgnoreCase(semiColon))) {
			// Semi-colon or Curly brace outside For loop
			indentLevel++;
			if (jsStack.empty() || (!jsStack.peek().equals(BlockType.FOR))) {
				charInput = charInput + newLine;
			}
		}

		if (charInput.equalsIgnoreCase(openingCurlyBrace)) {
			jsStack.push(BlockType.BRACE);
			indentLevel++;
			charInput = charInput + newLine;
			charInput = addSpaces(charInput, indentLevel, true);
		}

		if (charInput.equalsIgnoreCase(openingParentheses)) {
			String forText = output.substring(output.length() - 3);
			if (!forText.equalsIgnoreCase("for")) {
				jsStack.push(BlockType.PAREN);
			}
		}
		if (charInput.equalsIgnoreCase(closingParentheses)) {

			if (jsStack.peek().equals(BlockType.FOR)) {
				jsStack.pop();
				return output + charInput;
			}
			if (jsStack.empty() || !jsStack.pop().equals(BlockType.PAREN)) {
				charInput = "\n\nERROR:extra closing parenthesis found.";
				closeDueToError = true;
				return output + charInput;
			}
		}
		if (charInput.equalsIgnoreCase(closingCurlyBrace)) {
			if (jsStack.empty() || !jsStack.pop().equals(BlockType.BRACE)) {
				charInput = "\n\nERROR:extra brace found";
				closeDueToError = true;
				return output + charInput;
			} else {
				return output + charInput;
			}
		}
		return output + charInput;
	}

	/**
	 * @param output
	 *            String value for applying spaces
	 * @param spaces
	 *            Number of spaces / tabs to add
	 * @param after
	 *            Boolean value to confirm that spaces to be added after or
	 *            before
	 * @return
	 */
	private String addSpaces(String output, int spaces, boolean after) {

		for (int i = 0; i < spaces; i++) {
			if (after) {
				// Spaces after string
				output = output + " ";
			} else {
				// Spaces before string
				output = " " + output;
			}
		}
		return output;
	}
}
