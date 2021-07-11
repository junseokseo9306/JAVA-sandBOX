package Practice;

import java.util.*;

enum EMenu
{
	Coffee(1),Vanila(2),Lemon(3),GrapeFruit(4),WaterMelon(5),Tomato(6);
	
	private static final EMenu[] mValidMenu = EMenu.values();
	private final int mValue;
	
	private EMenu (int value)
	{
		this.mValue = value;
	}
	
	public int getValue()
	{
		return mValue;
	}
	
	public static EMenu of(int menu)
	{
		if(menu < 1 || menu > 6)
		{
			throw new IllegalArgumentException("invalidvalue");
		}
		return mValidMenu[menu - 1];
	}
}

public class CoffeeHouse extends Drink{
	
	public CoffeeHouse() {}

	static int index = 0;
	
	@SuppressWarnings("resource")
	public static void SelectMenu() {
		List<CoffeeHouse> coffeeCup = new ArrayList<CoffeeHouse>();
		
		for(int i = 0; i < 100; ++i)
			coffeeCup.add(new CoffeeHouse());
		
		StringBuilder builder = new StringBuilder(2048);
		Calendar cal = Calendar.getInstance();
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		coffeeCup.get(0).PrintMenu();
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();

		coffeeCup = CoffeeDecisionMaking(coffeeCup, builder, i);
		coffeeCup.get(index).PrintRecieptFront(day);
		
		int totalAmount = 0;
		for(int k = 0; k < 10; ++k)
		{
			if(coffeeCup.get(k).getfinish() == true) {
					if(coffeeCup.get(k).getwhich() < 3) {
						coffeeCup.get(k).PrintAllCoffee();
						coffeeCup.get(k).MakeTotal();
						totalAmount += coffeeCup.get(k).gettotalprice();
				} else {
					coffeeCup.get(k).PrintAllJuice();
					coffeeCup.get(k).MakeTotal();
					totalAmount += coffeeCup.get(k).gettotalprice();
				}
			}	
		}
		
		coffeeCup.get(index).PrintRecieptEnd(totalAmount);
		
	}
	
	static List<CoffeeHouse> CoffeeDecisionMaking(List<CoffeeHouse> coffee, StringBuilder builder, int selectedMenu){
		Scanner sc = new Scanner(System.in);
		
		String [] lookupTable = {"Default","아메리카노","바닐라라떼","레몬에이드","자몽에이드","수박주스","토마토주스"};
		
		builder.append(lookupTable[selectedMenu]);
		System.out.println(builder.toString());
		
		coffee.get(index).setprice(selectedMenu);
		coffee.get(index).setname(lookupTable[selectedMenu]);
		coffee.get(index).setwhich(selectedMenu);
		
		System.out.println("1.ice 2.hot 선택(주문취소 c)");
		int temp1 = sc.nextInt();
		sc.nextLine();
		if(temp1 == 1) {
			coffee.get(index).settemp(1);
			coffee.get(index).settempname("ice");
			builder.append("(ice");
		} else if (temp1 == 2) {
			coffee.get(index).settemp(2);
			coffee.get(index).settempname("hot");
			builder.append("(hot");
		} else {
			System.out.println("주문을 취소하시겠습니까? y/n");
			char cancelOrder1 = sc.nextLine().charAt(0);
			
			if(cancelOrder1 == 'y') {
				System.out.println("주문이 취소되었습니다 다시 주문해주세요");
				coffee.get(index).PrintMenu();
				builder.setLength(0);
				int next = sc.nextInt();
				return CoffeeDecisionMaking(coffee, builder, next);
			} else if (cancelOrder1 == 'n') {
				builder.setLength(0);
				return CoffeeDecisionMaking(coffee, builder, selectedMenu);
			}
		}
		System.out.println(builder.toString());
		
		if(selectedMenu < 3) {
			System.out.println("1. 1샷 (+0) 2. 2샷 (+500) (주문취소 c)");
			int temp2 = sc.nextInt();
			sc.nextLine();
			if(temp2 == 1) {
				coffee.get(index).setshots(temp2);
				coffee.get(index).setshotname("1샷");
				builder.append("/1샷");
			} else if(temp2 == 2) {
				coffee.get(index).setshots(temp2);
				coffee.get(index).setshotname("2샷");
				builder.append("/2샷");
			} else {
				System.out.println("주문을 취소하시겠습니까? y/n");
				char cancelOrder2 = sc.nextLine().charAt(0);
				
				if(cancelOrder2 == 'y') {
					System.out.println("주문이 취소되었습니다 다시 주문해주세요");
					coffee.get(index).PrintMenu();
					builder.setLength(0);
					int next = sc.nextInt();
					return CoffeeDecisionMaking(coffee, builder, next);
				} else if (cancelOrder2 == 'n') {
					builder.setLength(0);
					return CoffeeDecisionMaking(coffee, builder, selectedMenu);
				}
			}
		System.out.println(builder.toString());
		}
		
		System.out.println("1. S(+0원) 2. M(+500) 3.L(+1000) (주문취소 c)");
		int temp3 = sc.nextInt();
		sc.nextLine();
		if(temp3 == 1) {
			coffee.get(index).setcupsize(temp3);
			coffee.get(index).setcupsizename("S");
			builder.append("/S");
		} else if(temp3 == 2){
			coffee.get(index).setcupsize(temp3);
			coffee.get(index).setcupsizename("M");
			builder.append("/M");
		} else if (temp3 == 3) {
			coffee.get(index).setcupsize(temp3);
			coffee.get(index).setcupsizename("L");
			builder.append("/L");
		} else {
			System.out.println("주문을 취소하시겠습니까? y/n");
			char cancelOrder3 = sc.nextLine().charAt(0);
			
			if(cancelOrder3 == 'y') {
				System.out.println("주문이 취소되었습니다 다시 주문해주세요");
				coffee.get(index).PrintMenu();
				builder.setLength(0);
				int next = sc.nextInt();
				return CoffeeDecisionMaking(coffee, builder, next);
			} else if (cancelOrder3 == 'n') {
				builder.setLength(0);
				return CoffeeDecisionMaking(coffee, builder, selectedMenu);
			}
		}
		System.out.println(builder.toString());
		
		
		System.out.println("1. 매장이용(+500) 2. 테이크아웃 선택 (주문취소 c)");
		int temp4 = sc.nextInt();
		sc.nextLine();
		if(temp4 == 1) {
			coffee.get(index).settakeout(temp4);
			coffee.get(index).settakeoutname("매장이용");
			builder.append("/매장이용)");
		} else if(temp4 == 2){
			coffee.get(index).settakeout(temp4);
			coffee.get(index).settakeoutname("테이크아웃");
			builder.append("/테이크아웃)");
		} else {
			System.out.println("주문을 취소하시겠습니까? y/n");
			char cancelOrder4 = sc.nextLine().charAt(0);
			
			if(cancelOrder4 == 'y') {
				System.out.println("주문이 취소되었습니다 다시 주문해주세요");
				coffee.get(index).PrintMenu();
				builder.setLength(0);
				int next = sc.nextInt();
				return CoffeeDecisionMaking(coffee, builder, next);
			} else if (cancelOrder4 == 'n') {
				builder.setLength(0);
				return CoffeeDecisionMaking(coffee, builder, selectedMenu);
			}
		}
		System.out.println(builder.toString());
		coffee.get(index).setfinish(true);
		
		System.out.println("추가주문을하시겠습니까? y/n");
		int finish = sc.nextLine().charAt(0);
		
		if(finish == 'n') {
			return coffee;
		} 
		
		builder.setLength(0);
		++index;
		
		coffee.get(index).PrintMenu();
		int next = sc.nextInt();
		
		return CoffeeDecisionMaking(coffee, builder, next);
	}

	public void PrintRecieptFront(int day) {
		System.out.println("주문완료");
		System.out.println("=========================");
		System.out.println(String.format("       대기번호 : %d%02d", day, index + 1));
		System.out.println("==========결제내역=========");
		System.out.println("품목        수량        금액");
		System.out.println("-------------------------");
	}
	
	public void PrintRecieptEnd(int total) {
		System.out.println("-------------------------");
		System.out.println(String.format("합계 %1$21s", total));
		System.out.println("=========================");
	}
}
