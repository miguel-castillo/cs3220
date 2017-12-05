package lab8;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IntToWord extends SimpleTagSupport{
	int integer;
	private static final String[] tensNames = {
			"",
			" ten",
			" twenty",
			" thirty",
			" forty",
			" fifty",
			" sixty",
			" seventy",
			" eighty",
			" ninety"
	};

	private static final String[] numNames = {
			"",
			" one",
			" two",
			" three",
			" four",
			" five",
			" six",
			" seven",
			" eight",
			" nine",
			" ten",
			" eleven",
			" twelve",
			" thirteen",
			" fourteen",
			" fifteen",
			" sixteen",
			" seventeen",
			" eighteen",
			" nineteen"
	};

	public IntToWord(){
		integer = 0;
	}

	public void setInteger(String integer) {
		
		this.integer = Integer.parseInt(integer);
	}

	@Override
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		String output = convertNumber(integer);
		out.print(output);
	}

	private String convertNumber(int number) {
		String word;

		if (number % 100 < 20){
			word = numNames[number % 100];
			number /= 100;
		}
		else {
			word = numNames[number % 10];
			number /= 10;

			word = tensNames[number % 10] + word;
			number /= 10;
		}
		if (number == 0) return word;
		return numNames[number] + " hundred" + word;
	}

}
