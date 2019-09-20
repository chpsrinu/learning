package JavaLOB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//https://github.com/DrAshBooth/JavaLOB/blob/master/src/lob/OrderBook.java
public class OrderBook {
	
	private List<Trade> tape = new ArrayList<Trade>();
	private OrderTree bids = new OrderTree();
	private OrderTree asks = new OrderTree();
	private double tickSize;
	private int time;
	private int nextQuoteID;
	private int lastOrderSign;
	
	public OrderBook(double tickSize) {
		this.tickSize = tickSize;
		this.reset();
	}
	
	public void reset() {
		tape.clear();
		bids.reset();
		asks.reset();
		time = 0;
		nextQuoteID = 0;
		lastOrderSign = 1;
	}
	
	private double clipPrice(double price) {
		int numDecPlaces = (int)Math.log10(1/this.tickSize);
		BigDecimal bd =new BigDecimal(price);
		BigDecimal rounded = bd.setScale(numDecPlaces, BigDecimal.ROUND_HALF_UP);
		return rounded.doubleValue();
	}

	public OrderReport processOrder(Order quote, boolean verbose) {
		boolean isLimit = quote.isLimit();
		
	}
}
