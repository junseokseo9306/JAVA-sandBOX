


public class Person
{
		private String mPersonName;
		private int mAccountNumber;
		private int mDefaultMoney;
		private int mRemainMoney;
		private int mNoAssignFee;
		private int mtemp;
		public char mChapterAssign;
		public char mAssign;
		public char mWendAttendance;
		public char mSundAttendance;
		
		public Person(String name)
		{
			mPersonName = name;
		}
		
		public Person(String name, int defaultMoney, char chapter, char assign, char wend, char sund)
		{
			this.mPersonName = name;
			this.mDefaultMoney = defaultMoney;
			this.mChapterAssign = chapter;
			this.mAssign = assign;
			this.mWendAttendance = wend;
			this.mSundAttendance = sund;
		}
		
		
		public Person(String name, int defaultMoney, int account, char chapter, char assign, char wend, char sund, int assignfee, int remain)
		{
			this.mPersonName = name;
			this.mDefaultMoney = defaultMoney;
			this.mAccountNumber = account;
			this.mChapterAssign = chapter;
			this.mAssign = assign;
			this.mWendAttendance = wend;
			this.mSundAttendance = sund;
			this.mNoAssignFee = assignfee;
			this.mRemainMoney = remain;
		}
		
		public void SetAssignFeeZero()
		{
			this.mChapterAssign = ' ';
			this.mAssign = ' ';
			this.mWendAttendance = ' ';
			this.mSundAttendance = ' ';
		}
		
		public void SetAssignFee(int chapter, int assign, int wend, int sund)
		{
			if(chapter == 'N')
			{
				mtemp -= 500;
				mNoAssignFee += 500;
				mChapterAssign = 'X';
			}
			else if(chapter == 'Y')
			{
				mChapterAssign = 'O';
			}
			
			if(assign == 'N')
			{
				mtemp -= 500;
				mNoAssignFee += 500;
				mAssign = 'X';
			}
			else if(assign == 'Y')
			{
				mAssign = 'O';
			}
			
			if(wend == 'N')
			{
				mtemp -= 1000;
				mNoAssignFee += 1000;
				mWendAttendance = 'X';
			}
			else if(wend == 'Y')
			{
				mWendAttendance = 'O';
			}
			
			
			if(sund == 'N')
			{
				mtemp -= 1000;
				mNoAssignFee += 1000;
				mSundAttendance = 'X';
			}
			else if(sund == 'Y')
			{
				mSundAttendance = 'O';
			}
			
				mRemainMoney = mDefaultMoney + mtemp;
		}

		public static void PrintMenu()
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("                          메뉴관리                        ");
			System.out.println("--------------------------------------------------------");
			System.out.println("   1. 정보입력");
			System.out.println("   2. 벌금현황");
			System.out.println("   3. 스터디관리");
			System.out.println("   4. 스터디탈퇴");
			System.out.println("   5. 종료");
			System.out.println("--------------------------------------------------------");
			
		}
		
		public static void PrintPersonInfo()
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("                          정보입력                        ");
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 이름");
			System.out.println("2. 보증금");
			System.out.println("3. 챕터정리 (Y/N)");
			System.out.println("4. 과제 (Y/N)");
			System.out.println("5. 수요일 참석 (Y/N)");
			System.out.println("6. 일요일 참석 (Y/N)");
			System.out.println("--------------------------------------------------------");
		}
		
		public static void PrintFixInfo()
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("                        수정할정보입력                      ");
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 챕터정리 (Y/N)");
			System.out.println("2. 과제 (Y/N)");
			System.out.println("3. 수요일 참석 (Y/N)");
			System.out.println("4. 일요일 참석 (Y/N)");
			System.out.println("--------------------------------------------------------");
		}
		
		
		
		public void PrintAll ()
		{
			System.out.println("-----------------------------------------------------------------");
			System.out.println("                       회원 정보 출력                               ");
			System.out.println("-----------------------------------------------------------------");
			System.out.println(String.format("%1$5s %2$6s %3$6s %4$5s %5$5s %6$5s %7$5s %8$3s %9$5s", "번호","이름","디파짓","챕터정리","과제","수요일참석","일요일참석","벌금","잔액"));
			System.out.print(String.format("%1$5s",mAccountNumber));
			System.out.print(String.format("%1$8s",mPersonName));
			System.out.print(String.format("%1$8s",mDefaultMoney));
			System.out.print(String.format("%1$6s",mChapterAssign));
			System.out.print(String.format("%1$7s",mAssign));
			System.out.print(String.format("%1$7s",mWendAttendance));
			System.out.print(String.format("%1$8s",mSundAttendance));
			System.out.print(String.format("%1$7s",mNoAssignFee));
			System.out.println(String.format("%1$7s",mRemainMoney));
			System.out.println("-----------------------------------------------------------------");
		}
		
		public String GetPersonName()
		{
			return mPersonName;
		}
		
		public void SetPersonName(String personName)
		{
			this.mPersonName = personName;
		}
		
		public void SetDefaultMoney(int defaultMoney)
		{
			this.mDefaultMoney = defaultMoney;
		}
		
		public void SetAssignFee(int assignfee)
		{
			this.mNoAssignFee = assignfee;
		}
		
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------------------------------");
		System.out.println("           프로그램을 시작합니다          ");
		System.out.println("------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("몇명의 스터디원을 모집하실 계획입니까? (숫자입력)");
		System.out.println("-------------------------------------");
		
		int personNumber = scanner.nextInt();
		
		Person[] people = new Person[personNumber];
		
		for (int i = 0; i < personNumber; ++i )
		{
			people[i] = new Person ("   ", 0, i, ' ', ' ', ' ', ' ', 0, 0);
		}
		
		
		int personNumberCount = 0;
		
		outer:
		while (true)
		{	
			PrintMenu();
			int menu = scanner.nextInt();

			switch (menu)
			{
				case 1:
					System.out.printf("0 ~ %d 입력할 고유 넘버 입력\n", personNumber - 1);
					int number = scanner.nextInt();
					
					PrintPersonInfo();
					String blank = scanner.nextLine();
					String name = scanner.nextLine();
					int defaultmoney = scanner.nextInt();
					String blank3 = scanner.nextLine();
					char chapter = scanner.nextLine().charAt(0);
					char assign = scanner.nextLine().charAt(0);
					char wend = scanner.nextLine().charAt(0);
					char sund = scanner.nextLine().charAt(0);
					
					people[number].SetPersonName(name);
					people[number].SetDefaultMoney(defaultmoney);
					people[number].SetAssignFee(chapter, assign, wend, sund);
					
					++personNumberCount;
					break;
					
				case 2:
					for (int i = 0; i < personNumberCount; ++i )
					{
						people[i].PrintAll();
					}	
					break;
					
				case 3:
					System.out.printf("0 ~ %d 입력할 고유 넘버 입력\n", personNumber - 1);
					int number2 = scanner.nextInt();
					
					PrintFixInfo();
					String blank2 = scanner.nextLine();
					char chapter2 = scanner.nextLine().charAt(0);
					char assign2 = scanner.nextLine().charAt(0);
					char wend2 = scanner.nextLine().charAt(0);
					char sund2 = scanner.nextLine().charAt(0);
					
					
					people[number2].SetAssignFee(chapter2, assign2, wend2, sund2);
					break;
					
				case 4:
					System.out.printf("0 ~ %d 입력할 고유 넘버 입력\n", personNumber - 1);
					int number3 = scanner.nextInt();
					
					people[number3].SetPersonName("탈 퇴");
					people[number3].SetDefaultMoney(0);
					people[number3].SetAssignFee(0);
					people[number3].SetAssignFeeZero();
					break;
					
				case 5:
					System.out.println("시스템 종료");
					break outer;
					
				default:
					break;
					
					
			}
		}
	}
}

