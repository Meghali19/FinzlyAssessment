import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main 
{
	protected static double rate = 66.00;
	private static double convertedAmount;
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Trade> trades = new ArrayList<>();
	
	
	public static void main(String[] args) 
	{
		
		while(true)
		{
			System.out.println("Enter 1: Book Trade");
		    System.out.println("Enter 2: Print Trade");
		    System.out.println("Enter 3: Exit");
		    String enter = sc.nextLine();
		    
		    switch(enter.trim())
		    {
                case "1":
                    bookTrade();
                    break;
                case "2":
                    printTrades();
                    break;
                case "3":
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }		    
		}
	
	}
	
	
	//Method for checking Currency pair
	public static boolean checkPair(String currencyPair)
	{
		if(!currencyPair.equalsIgnoreCase("USDINR"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	//Method for checking name
	public static boolean checkName(String name)
	{
		if(name==null)
		{
			return false;
		}
		for(char c : name.toCharArray())
		{
			if(!Character.isLetter(c) && c != ' ')
			{
				return false;
			}
		}
		return true;
		
	}
	
	
	//Method for checking amount
	public static boolean checkAmount(double amount)
	{
		if(amount<0)
		{
			return false;
		}
		else if(amount==0)
		{
			return false;	
		}
		else
		{
			return true;
		}
			
	}
	
	
	//BOOK-TRADE
	private static void bookTrade()
	{
		System.out.println("Enter customer Name: ");
		sc.nextLine();
        String name = sc.nextLine();
        while(!checkName(name))
        {
        	System.out.println("Enter Proper Name");
        	name = sc.nextLine();
        }

        System.out.println("Enter Currency Pair: ");
        String currencyPair = sc.nextLine();
        while(!checkPair(currencyPair))
        {
        	System.out.println("Enter proper currency pair...(i.e 'USDINR')");
        	currencyPair = sc.nextLine();
       	}
        //sc.nextLine();
        
        System.out.println("Enter amount to transfer: ");
        String amount = sc.nextLine();
        while(amount!=null)
        {
        	if((amount.trim()).matches("[0-9]+"))
        		break;
        	else
        	{
        		System.out.println("Amount should be number ");
        		amount = sc.nextLine();
        	}
        }
        double amountInt = Double.parseDouble(amount);
        while(!checkAmount(amountInt))
        {
        	System.out.println("Amount should be greater than zero/0. Enter Proper Amount");
        	amount = sc.nextLine();
        }
        //amountInt = Double.parseDouble(amount);
        
        System.out.println("Do you want to get Rate: (yes/no)");
		String getRate = sc.next();
		
		convertedAmount = amountInt * rate;
		
		if(getRate.equalsIgnoreCase("yes") || getRate.equalsIgnoreCase("y"))
		{
			  System.out.println("You are transferring " + convertedAmount + " to " +name+" (Assuming that rate was " + rate + ")");
		}
		
		else
		{
			System.out.println("You are transferring INR "+convertedAmount+" to "+name);
		}
		
		System.out.println("Book/Cancel this trade? ");
		String bookCancelTrade = sc.next();
		
		
		if(bookCancelTrade.equalsIgnoreCase("book"))
		{
			trades.add(new Trade(name, currencyPair, amountInt, convertedAmount));
			System.out.println("Trade for "+currencyPair+" has been booked with rate "+rate+" , The amount of Rs "+convertedAmount+" will  be transferred in 2 working days to "+name+"..");
		}
		else if(bookCancelTrade.equalsIgnoreCase("cancel"))
		{
			System.out.println("Trade is Canceled.");   
		}
		else 
		{
            System.out.println("Invalid choice.");
        }
        
	}
	
	
	//PRINT-TRADE
	private static void printTrades()
	{
		System.out.println("TradeNo\tCurrencyPair\tCustomerName\tAmount\tRate");
        for (Trade trade : trades) {
            System.out.println(trade);
        }
	}
	
	
	//Exit-PROGRAM
	private static void exitProgram()
	{
		System.out.print("Do you really want to exit (y/n): ");
        String value = sc.next();
        if (value.equalsIgnoreCase("Y")) {
            System.out.println("Bye - have a good day");
            System.exit(0);
        }
		
	}

}
