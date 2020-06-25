public class Card {
	// 输入函数 
	void dealInput(String input[],int num[],String decor[]) {
		int i;
		int length;
		String temp;
		for(i = 0;i < 5;i++) {
			length = input[i].length();
			if(length == 2) {
				temp = input[i].substring(0, 1);
				switch(temp) {
				case "A":
					num[i] = 14;
					break;
				case "K":
					num[i] = 13;
					break;
				case "Q":
					num[i] = 12;
					break;
				case "J":
					num[i] = 11;
					break;
				default:
					num[i] = Integer.parseInt(temp);
				}
				decor[i] = input[i].substring(1,2);
			}else if(length == 3) {
				num[i] = 10;
				decor[i] = input[i].substring(2, 3);
			}
		}
	}
	// 输出函数（打印信息）
	void dealOutput() {
		
	}
	// 冒泡排序
	void Bubble(int a[]) {
		
	}
	// 比较函数
	void Compare() {
		
	}
	// 调用
	String GetValue(String black[], String white[]) {
		String result = null;
		int blacknum[] = new int[] {0,0,0,0,0};
		int whitenum[] = new int[] {0,0,0,0,0};
		String blackdecor[] = new String[] {"","","","",""};
		String whitedecor[] = new String[] {"","","","",""};
		dealInput(black,blacknum,blackdecor);
		dealInput(white,whitenum,whitedecor);
		System.out.println(whitedecor[0]);
		System.out.println(whitedecor[1]);
		System.out.println(whitedecor[2]);
		System.out.println(whitedecor[3]);
		System.out.println(whitedecor[4]);
		return result;
	}
}
