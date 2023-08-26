public class Trade
{
	private static int count = 0;
	private int tradeNo;
	protected String name;
	protected String currencyPair;
	protected double amount;
	private double convertedAmount;

    //CONTRUCTORS
	public Trade(String name, String currencyPair, double amount, double convertedAmount) 
	{
		
		this.tradeNo = ++count;
		this.name = name;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
		
	}

    
	//GETTERS
	public String getName() {
		return name;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	@Override
    public String toString()
    {
    	return tradeNo + "\t" + currencyPair.toUpperCase() + "\t" + name + "\t" + convertedAmount + "\t" + Main.rate;
    }
    
	
}
