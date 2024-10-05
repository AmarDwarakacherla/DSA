package Pizza_Bill_Generator;

public class Pizza {
	private int price;
	private Boolean veg;
	
	private int addExtraCheesePrice = 100;
	private int addExtraToppingsPrice = 150;
	private int backPackPrice = 20;
	private int basePizzaPrice = 0;
	
	
	private boolean isExtraCheeseAdded = false;
	private boolean isExtraToppingsAdded = false;
	private boolean isOptedforTakeAway = false;
	
	
	
	public Pizza(Boolean veg)
	{
		this.veg = veg;
		if(this.veg)
		{
			this.price = 300;
		}
		else 
		{
			this.price = 400;
		}
		basePizzaPrice = this.price;
	}
	public void addExtraCheese()
	{
		isExtraCheeseAdded = true;
		this.price += addExtraCheesePrice;
	}
	
	public void addExtraToppings()
	{
		isExtraToppingsAdded = true;
		this.price += addExtraToppingsPrice;
	}
	public void takeAway()
	{
		isOptedforTakeAway = true;
		this.price += backPackPrice;
		
	}
	public void getBill()
	{
		String bill = "";
		System.out.println("Pizza: "+basePizzaPrice);
		if(isExtraCheeseAdded)
		{
			bill += "Extra Cheese Added: " + addExtraCheesePrice + "\n";
		}
		if(isExtraToppingsAdded)
		{
			bill += "Extra Topings Added: " + addExtraToppingsPrice + "\n";
		}
		if(isOptedforTakeAway)
		{
			bill += "Take away: " + backPackPrice + "\n"; 
		}
		bill += "Bill: " + this.price + "\n";
		System.out.print(bill);
		
	}

}
