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
	// 比较函数
	void Compare() {
		
	}
	// 判断是否为同花顺
	boolean dealTongHuaShun(int num[],String decor[]) {
		boolean result = false;
		if(decor[0].equals(decor[1]) && decor[1].equals(decor[2]) && decor[2].equals(decor[3]) && decor[3].equals(decor[4])) {
			if(num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
				result = true;
				num[5] = num[4];
			}
		}
		return result;
	}
	// 判断是否为顺子
	boolean dealShunZi(int num[]) {
		boolean result = false;
		if(num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 判断是否为三条
	boolean dealSanTiao(int num[]) {
		boolean result = false;
		if(num[0] == num[1] && num[1] == num[2]) {
			result = true;
			num[5] = num[0];
		}else if(num[1] == num[2] && num[2] == num[3]) {
			result = true;
			num[5] = num[1];
		}else if(num[2] == num[3] && num[3] == num[4]) {
			result = true;
			num[5] = num[2];
		}
		return result;
	}
	// 判断是否为两对
	boolean dealLiangDui(int num[]) {
		boolean result = false;
		if(num[0] == num[1] && num[2] == num[3]) {
			result = true;
			num[5] = num[3];
		}else if(num[1] == num[2] && num[3] == num[4]) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 判断是否为对子
//	boolean dealDuiZi(int num[]) {
//		
//	}
	// 调用
	String GetValue(String black[], String white[]) {
		String result = null;
		int blacknum[] = new int[] {0,0,0,0,0,0};
		int whitenum[] = new int[] {0,0,0,0,0,0};
		String blackdecor[] = new String[] {"","","","",""};
		String whitedecor[] = new String[] {"","","","",""};
		boolean blackT = false;
		boolean whiteT= false;
		dealInput(black,blacknum,blackdecor);
		dealInput(white,whitenum,whitedecor);
		blackT = dealTongHuaShun(blacknum,blackdecor);
		blackT = dealShunZi(blacknum);
		blackT = dealSanTiao(blacknum);
		blackT = dealLiangDui(blacknum);
		System.out.println(blackT);
		System.out.println(blacknum[5]);
		return result;
	}
}
