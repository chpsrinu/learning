package JavaLOB;

public class Order {
	private int timestamp;
	private boolean limit;
	private int quantity;
	private String side;
	private double price;
	private int qId;
	private int tId;
	private Order nextOrder;
	private Order prevOrder;
	private OrderList oL;
	public Order(int timestamp, boolean limit, int quantity, String side, int tId) {
		this.timestamp = timestamp;
		this.limit = limit;
		this.quantity = quantity;
		this.side = side;
		this.tId = tId;
	}
	public Order(int timestamp, boolean limit, int quantity, String side, Double price, int tId) {
		this.timestamp = timestamp;
		this.limit = limit;
		this.quantity = quantity;
		this.side = side;
		if (price != null) 
			this.price = (double)price;
		this.tId = tId;
	}
	
	public void updateQty(int qty, int tstamp) {
		if((qty > this.quantity) && (this.oL.getTailOrder() != this)) {
			// Move order to the end fo the List.
			this.oL.moveTail(this);
			this.timestamp = tstamp;
		}
		oL.setVolume(oL.getVolume()-(this.quantity-qty));
		this.quantity = qty;
	}
	
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Order getNextOrder() {
		return nextOrder;
	}
	public void setNextOrder(Order nextOrder) {
		this.nextOrder = nextOrder;
	}
	public Order getPrevOrder() {
		return prevOrder;
	}
	public void setPrevOrder(Order prevOrder) {
		this.prevOrder = prevOrder;
	}
	public OrderList getoL() {
		return oL;
	}
	public void setoL(OrderList oL) {
		this.oL = oL;
	}
	
	@Override
	public String toString() {
		return Integer.toString(quantity) + "\t@\t" + Double.toString(price) + 
        		"\tt=" + Integer.toString(timestamp) + 
        		"\tqId=" + Integer.toString(qId) +
        		"\ttId=" + Integer.toString(tId);
	}
	
	
	

}
