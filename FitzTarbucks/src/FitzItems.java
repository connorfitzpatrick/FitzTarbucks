
public class FitzItems {
	private boolean nameSort;
	private boolean priceSort;
	private boolean typeSort;
	private double price1;
	private double price2;
	private int combo;
	private boolean coffee;
	private boolean tea;
	private boolean pastry;
	private boolean sandwich;
	private boolean bagel;
	private boolean cookie;
	private boolean scone;
	private boolean other;
	
	public FitzItems() {
		nameSort = false;
		priceSort = false;
		typeSort = false;
		price1 = 0.00;
		price2 = 0.00;
		combo = 5;
		coffee = false;
		tea = false;
		pastry = false;
		sandwich = false;
		bagel = false;
		cookie = false;
		scone = false;
		other = false;
	} // Prices
	
	public FitzItems(double newPrice1, double newPrice2, boolean ns, boolean ps, boolean ts, int cmbo, boolean cf, boolean t, boolean py, boolean sw, boolean bg, boolean ck, boolean sn, boolean oth) {
		super();
		price1 = newPrice1;
		price2 = newPrice2;
		nameSort = ns;
		priceSort = ps;
		typeSort = ts;
		combo = cmbo;
		coffee = cf;
		tea = t;
		pastry = py;
		sandwich = sw;
		bagel = bg;
		cookie = ck;
		scone = sn;
		other = oth;
	} // prices()
	
	public void setPrice1(double newPrice1) {
		price1 = newPrice1;
	} // setPrice1
	
	public void setPrice2(double newPrice2) {
		price2 = newPrice2;
	} // setPrice2
	
	public void setNameSort(boolean ns) {
		nameSort = ns;
	} // setNameSort()
	
	public void setPriceSort(boolean ps) {
		priceSort = ps;
	} // setPriceSort()
	
	public void setTypeSort(boolean ts) {
		typeSort = ts;
	} // setTypeSort()
	
	public void setCombo(int cmbo) {
		combo = cmbo;
	} // setCombo()
	
	public void setCoffee(boolean cf) {
		coffee = cf;
	} // setCoffee()
	
	public void setTea(boolean t) {
		tea = t;
	} // setTea()
	
	public void setPastry(boolean py) {
		pastry = py;
	} // setPastry()
	
	public void setSandwich(boolean sw) {
		sandwich = sw;
	} // setSandwich()
	
	public void setBagel(boolean bg) {
		bagel = bg;
	} // setBagel()
	
	public void setCookie(boolean ck) {
		cookie = ck;
	} // setCookie()
	
	public void setScone(boolean sn) {
		scone = sn;
	} // setScone()
	
	public void setOther(boolean oth) {
		other = oth;
	} // setOther()
	
	public double getPrice1() {
		return price1;
	} // getPrice1
	
	public double getPrice2() {
		return price2;
	} // getPrice2
	
	public boolean getNameSort() {
		return nameSort;
	} // getNameSort()
	
	public boolean getPriceSort() {
		return priceSort;
	} // getPriceSort()
	
	public boolean getTypeSort() {
		return typeSort;
	} // getTypeSort()
	
	public int getCombo() {
		return combo;
	} // getCombo()
	
	public boolean getCoffee() {
		return coffee;
	} // getCoffee()
	
	public boolean getTea() {
		return tea;
	} // getTea()
	
	public boolean getPastry() {
		return pastry;
	} // getPastry()
	
	public boolean getSandwich() {
		return sandwich;
	} // getSandwich()
	
	public boolean getBagel() {
		return bagel;
	} // getBagel()
	
	public boolean getCookie() {
		return cookie;
	} // getCookie()
	
	public boolean getScone() {
		return scone;
	} // getScone()
	
	public boolean getOther() {
		return other;
	} // getOther()
}
