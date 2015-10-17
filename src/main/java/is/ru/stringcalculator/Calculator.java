package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if((text.charAt(0) == '/') && (text.charAt(1) == '/') && (text.charAt(3) == '\n')) {
			char delim = text.charAt(2);
			text = text.substring(4);
			return sum(splitNumbers(text, delim));
		} 
		else if(text.contains(",") || (text.contains("\n"))){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[,\n]");
	}
    
	private static String[] splitNumbers(String numbers, char delim){
	    return numbers.split("[//"+delim+",\n]");
	}

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}