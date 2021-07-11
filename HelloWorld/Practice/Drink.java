package Practice;

public class Drink {
	
	private int mTakeOut;
	private int mTemp;
	private int mCupSize;
	private int mAddShots;
	private int mPrice;
	private int mEmpty;
	private int mTotalPrice;
	private int mWhich;
	private boolean mFinish;
	private String mName;
	private String mTempName;
	private String mShotsName;
	private String mTakeOutName;
	private String mCupSizeName;
	
	public Drink () {}
	
	public void Hot(int x) {
		this.mTemp = x;
	}
	
	public void CupSize (int x) {
		if(x == 1) {
			this.mCupSize = 0;
		} else if(x == 2) {
			this.mCupSize = 500;
		} else if(x == 3) {
			this.mCupSize = 1000;
		}
	}
	
	public void TakeOut(int x) {
		this.mTakeOut = x;
	}
	
	public int gettemp() {
		return mTemp;
	}
	
	public void settemp (int temp) {
		this.mTemp = temp;
	}
	
	public void settempname(String name) {
		this.mTempName = name;
	}
	
	public void setshotname(String name) {
		this.mShotsName = name;
	}
	
	public void settakeoutname(String name) {
		this.mTakeOutName = name;
	}
	
	public void setcupsizename(String name) {
		this.mCupSizeName = name;
	}
	
	public int gettakeout() {
		return mTakeOut;
	}
	
	public void settakeout(int takeout) {
		if(takeout == 1) {
			this.mTakeOut = 500;
		} else {
			this.mTakeOut = 0;
		}
	}
	
	public int getcupsize() {
		return mCupSize;
	}
	
	public void setcupsize(int cupsize) {
		if(cupsize == 1) {
			this.mCupSize = 0;
		} else if (cupsize == 2) {
			this.mCupSize = 500;
		} else if (cupsize == 3) {
			this.mCupSize = 1000;
		}
	}
	
	public int getprice() {
		return mPrice;
	}
	
	public void setshots(int number) {
		if(number == 1) {
			this.mAddShots = 0;
		} else if(number == 2) {
			this.mAddShots = 500;
		}
	}
	
	public int getshots() {
		return mAddShots;
	}
	
	public void setprice(int price) {
		if (price == 1) {
			this.mPrice = 1000;
		} else if (price == 2) {
			this.mPrice = 2000;
		} else if (price == 3 || price == 4) {
			this.mPrice = 3000;
		} else if (price == 5 || price == 6) {
			this.mPrice = 4000;
		}
			
	}
	
	public int gettotalprice() {
		return mTotalPrice;
	}
	
	public void setfinish(boolean finish) {
		this.mFinish = finish;
	}
	
	public boolean getfinish() {
		return mFinish;
	}
	
	public int gettotal() {
		return mTotalPrice;
	}
	
	public String getname() {
		return mName;
	}
	
	public void setname(String name) {
		this.mName = name;
	}
	
	public int getwhich() {
		return mWhich;
	}
	
	public void setwhich(int a) {
		this.mWhich = a;
	}
	
	public void MakeTotal() {
		
		this.mTotalPrice += this.mPrice;
		this.mTotalPrice += this.mAddShots;
		this.mTotalPrice += this.mCupSize;
		this.mTotalPrice += this.mTakeOut;
	}
	
	public void PrintMenu () {
		System.out.println("메뉴");
		System.out.println("1.아메리카노 1000원");
		System.out.println("2.바닐라라떼 2500원");
		System.out.println("3.레몬에이드 3000원");
		System.out.println("4.자몽에이드 3000원");
		System.out.println("5.수박주스  4000원");
		System.out.println("6.토마토주스 4000원");
	}
	
	public void PrintAllCoffee() {
		System.out.println(String.format("%1$-5s %2$7s %3$8s",mName, 1, mPrice));
		System.out.println(String.format("추가 %1$-9s %2$1s %3$8s",mTempName,1,mEmpty));
		System.out.println(String.format("추가 %1$-9s %2$1s %3$8s",mShotsName,1,mAddShots));
		System.out.println(String.format("추가 %1$1s사이즈 %2$5s %3$8s",mCupSizeName,1,mCupSize));
		System.out.println(String.format("추가 %1$-7s %2$1s %3$8s",mTakeOutName,1,mTakeOut));
		System.out.println("-------------------------");
	}
		
	public void PrintAllJuice() {
		System.out.println(String.format("%1$-5s %2$7s %3$8s",mName, 1, mPrice));
		System.out.println(String.format("추가 %1$-9s %2$1s %3$8s",mTempName,1, mEmpty));
		System.out.println(String.format("추가 %1$1s사이즈 %2$5s %3$8s",mCupSizeName, 1, mCupSize));
		System.out.println(String.format("추가 %1$-7s %2$1s %3$8s", mTakeOutName,1, mTakeOut));
		System.out.println("-------------------------");
		
		
	}

	
}
